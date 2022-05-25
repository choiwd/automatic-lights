import grpc
import automaticlights_pb2
import automaticlights_pb2_grpc
from concurrent import futures

class AutomaticLightsServicer(automaticlights_pb2_grpc.AutomaticLightsServicer):

    def __init__(self):
        self.OnOff=False
        self.intensity=0

    def TurnOnOff(self, request, context):
        self.OnOff=request.OnOff
        return automaticlights_pb2.request(OnOff=self.OnOff, voteID=0)

    def status(self, request, context):
        return automaticlights_pb2.query(OnOff=self.OnOff, intensity=self.intensity, voteID=0)


def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=10))
    automaticlights_pb2_grpc.add_AutomaticLightsServicer_to_server(
        AutomaticLightsServicer(), server)
    server.add_insecure_port('[::]:50051')
    server.start()
    server.wait_for_termination()