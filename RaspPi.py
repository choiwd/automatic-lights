import grpc
import logging
import automaticlights_pb2
import automaticlights_pb2_grpc
from concurrent import futures

import serial

arduinoAdr='/dev/ttyACM0'
ser = serial.Serial(arduinoAdr, 115200, timeout=1)
ser.reset_input_buffer()

count=0
OnOff=False
intensity=0
participants=[]


class AutomaticLightsServicer(automaticlights_pb2_grpc.AutomaticLightsServicer):

    def TurnOnOff(self, request, context):
        if len(participants)>0:
            voteID=1
        elif request.OnOff==True:
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
        return automaticlights_pb2.requestMessage(OnOff=OnOff, voteID=voteID)

    def status(self, request, context):
        return automaticlights_pb2.queryMessage(OnOff=OnOff, intensity=intensity, voteID=0, participants=participants)


def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    automaticlights_pb2_grpc.add_AutomaticLightsServicer_to_server(
        AutomaticLightsServicer(), server)
    server.add_insecure_port('[::]:50051')
    server.start()
   # server.wait_for_termination()

if __name__ == '__main__':
    logging.basicConfig()
    serve()
    
    while True:
        """print('Qualquer coisa')
        import time
        time.sleep(1) """

        if ser.in_waiting > 0:
            line = ser.readline().decode('utf-8').rstrip()

            if line=="Entered":
                count+=1
            elif line=="Left" and count>0:
                count-=1

            elif line=="0":
                intensity=0
            elif line=="1":
                intensity=1

            if count==0 and OnOff==True:
                OnOff=False
                ser.write(str(int(OnOff)).encode('utf-8'))

            if count>0 and OnOff==False and intensity==1:
                OnOff=True
                ser.write(str(int(OnOff)).encode('utf-8'))