import grpc
import logging
import automaticlights_pb2
import automaticlights_pb2_grpc
from concurrent import futures

import serial

'''arduinoAdr='/dev/ttyACM0'
ser = serial.Serial(arduinoAdr, 115200, timeout=1)
ser.reset_input_buffer()'''

count=0
OnOff=False
intensity=0
participants=[]

class AutomaticLightsServicer(automaticlights_pb2_grpc.AutomaticLightsServicer):

    def __init__(self):
        self.OnOff=OnOff
        self.intensity=intensity
        self.count=count
        self.participants=participants

    def TurnOnOff(self, request, context):
        if len(self.participants)>0:
            voteID=1
        elif request.OnOff==True:
            if self.intensity==0:
                voteID=1
            else:
                self.OnOff=request.OnOff
                voteID=0
        else:
            self.OnOff=request.OnOff
            voteID=0
        return automaticlights_pb2.requestMessage(OnOff=self.OnOff, voteID=voteID)

    def status(self, request, context):
        return automaticlights_pb2.queryMessage(OnOff=self.OnOff, intensity=self.intensity, voteID=0, participants=self.participants)


def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    automaticlights_pb2_grpc.add_AutomaticLightsServicer_to_server(
        AutomaticLightsServicer(), server)
    server.add_insecure_port('[::]:50051')
    server.start()
    server.wait_for_termination()

if __name__ == '__main__':
    '''logging.basicConfig()
    serve()'''

example=AutomaticLightsServicer()
request1=automaticlights_pb2.requestMessage(OnOff=True, voteID=1)
request2=automaticlights_pb2.requestMessage(OnOff=False, voteID=1)

example.TurnOnOff(request1,2)
state1=example.status(1,2)
example.intensity=1
example.TurnOnOff(request1,2)
state2=example.status(1,2)
example.TurnOnOff(request2,2)
state3=example.status(1,2)
example.participants=['Joaquim','Joaquina']
example.TurnOnOff(request1,2)
state4=example.status(1,2)

print(state1.OnOff,state1.intensity,state1.participants)
print(state2.OnOff,state2.intensity,state2.participants)
print(state3.OnOff,state3.intensity,state3.participants)
print(state4.OnOff,state4.intensity,state4.participants)