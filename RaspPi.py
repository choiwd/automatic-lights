import grpc
import logging
import automaticlights_pb2
import automaticlights_pb2_grpc
from concurrent import futures
import time
import serial
import threading

#inializar a comunicação com o Arduino
arduinoAdr='/dev/ttyACM0' 
ser = serial.Serial(arduinoAdr, 115200, timeout=1) 
ser.reset_input_buffer()

count=0 #números de pessoas dentro da sala
OnOff=False #estado da luz: ligada (True) ou desligada (False)
intensity=1 #intensidade da sala: 1 se houver pouca luz, 0 se houver muita luz
usersInRoom={} #dicionário com os utilizadores ligados à app Android. Associa um IP a um nome {"IP do utilizador":"Nome do utilizador"}
usersTimer={} #dicionário com o último tempo que cada utilizador chamou a função status. Associa um IP a um tempo {"IP":"tempo"}

#Classe com as funções a serem chamadas por gRPC
class AutomaticLightsServicer(automaticlights_pb2_grpc.AutomaticLightsServicer):

    #Função de pedir para ligar e desligar a luz chamada pelo Android
    #Retorna o estado da luz no final e se o RaspPi aprovou o pedido (voteID=1) ou se o reprovou (voteID=0)
    def TurnOnOff(self, request, context): 
        global OnOff
        global intensity
        global ser
        if request.OnOff==True:
            if intensity==0:
                voteID=1
            else:
                OnOff=request.OnOff
                ser.write(str(int(OnOff)).encode('utf-8'))
                voteID=0
        else:
            OnOff=request.OnOff
            ser.write(str(int(OnOff)).encode('utf-8'))
            voteID=0
        print('turn on/off')
        return automaticlights_pb2.requestMessage(OnOff=OnOff, voteID=voteID)

    #Função para pedir o estado do sistema chamada de 2 em 2 segundos pelo Android
    def status(self, request, context):
        global OnOff
        global intensity
        global usersInRoom
        global usersTimer
        print('status')
        userid=context.peer() #IP do utilizador que pediu o estado do sistema
        username=request.name #Nome do utilizador que pediu o estado do sistema
        if userid not in usersInRoom: #Se o utilizador não estiver em usersInRoom adiciona-o ao dicinário e dá uma mensagem de boas-vindas
            usersInRoom[userid]=username
            print('Boas vindas '+username)
        usersTimer[userid]=time.time() #Guarda o tempo em que o utilizador chamou a função status

        participants=list(usersInRoom.values())
        return automaticlights_pb2.queryMessage(OnOff=OnOff, intensity=intensity, voteID=0, participants=participants, name=username)

# Função para utilizar o protocolo de gRPC
def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    automaticlights_pb2_grpc.add_AutomaticLightsServicer_to_server(
        AutomaticLightsServicer(), server)
    server.add_insecure_port('[::]:50051')
    server.start()
    server.wait_for_termination()

if __name__ == '__main__':
    logging.basicConfig()
    x=threading.Thread(target=serve)
    x.start() # Thread utilizada para o RaspPi poder correr o protocolo gRPC e o código abaixo, ao mesmo tempo
    print('Begin service')
    
    while True:

        #Se o tempo que passou entre a última vez que um utilizador chamou a função status for maior do que 10s retirá-lo
        #dos dicionários usersInRoom e usersTimer
        timerKeys=list(usersTimer.keys())
        for key in timerKeys:
            passedTime=time.time()-usersTimer[key]
            if passedTime>10:
                usersTimer.pop(key)
                usersInRoom.pop(key)

        #A correr se houver alguma mensagem vinda do Arduino
        if ser.in_waiting > 0:
            line = ser.readline().decode('utf-8').rstrip()

            if line=="Entered":
                count+=1
                print(count)
            elif line=="Left" and count>0:
                count-=1
                print(count)

            elif line=="0":
                intensity=0
            elif line=="1":
                intensity=1

            if count==0 and OnOff==True:
                OnOff=False
                ser.write(str(int(OnOff)).encode('utf-8'))

            elif count>0 and OnOff==False and intensity==1:
                OnOff=True
                ser.write(str(int(OnOff)).encode('utf-8'))