import grpc
import logging
import automaticlights_pb2
import automaticlights_pb2_grpc
from concurrent import futures
import time
import serial
import threading

arduinoAdr='/dev/ttyACM0'
ser = serial.Serial(arduinoAdr, 115200, timeout=1)
ser.reset_input_buffer()

count=0
OnOff=False
intensity=1
usersInRoom={}
usersTimer={}


class AutomaticLightsServicer(automaticlights_pb2_grpc.AutomaticLightsServicer):

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

    def status(self, request, context):
        global OnOff
        global intensity
        global usersInRoom
        global usersTimer
        print('status')
        userid=context.peer()
        username=request.name
        if userid not in usersInRoom:
            usersInRoom[userid]=username
            print('Boas vindas '+username)
        usersTimer[userid]=time.time()

        participants=list(usersInRoom.values())
        return automaticlights_pb2.queryMessage(OnOff=OnOff, intensity=intensity, voteID=0, participants=participants, name=username)


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
    x.start()
    print('Begin service')
    
    while True:

        timerKeys=list(usersTimer.keys())
        for key in timerKeys:
            passedTime=time.time()-usersTimer[key]
            if passedTime>10:
                usersTimer.pop(key)
                usersInRoom.pop(key)

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