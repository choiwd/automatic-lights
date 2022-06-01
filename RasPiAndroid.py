import grpc
import logging
import automaticlights_pb2
import automaticlights_pb2_grpc
from concurrent import futures
import time


count=0
OnOff=False
intensity=1
usersInRoom={}
usersTimer={}

class AutomaticLightsServicer(automaticlights_pb2_grpc.AutomaticLightsServicer):

    def TurnOnOff(self, request, context):
        global OnOff
        global intensity
        if request.OnOff==True:
            if intensity==0:
                voteID=1
            else:
                OnOff=request.OnOff
                voteID=0
        else:
            OnOff=request.OnOff
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
    #server.wait_for_termination()

if __name__ == '__main__':
    logging.basicConfig()
    serve()

    while True:
        timerKeys=list(usersTimer.keys())
        for key in timerKeys:
            passedTime=time.time()-usersTimer[key]
            if passedTime>10:
                usersTimer.pop(key)
                usersInRoom.pop(key)

