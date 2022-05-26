# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
"""Client and server classes corresponding to protobuf-defined services."""
import grpc

import automaticlights_pb2 as automaticlights__pb2


class AutomaticLightsStub(object):
    """The AutomaticLights service definition.
    """

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.TurnOnOff = channel.unary_unary(
                '/autoLights.AutomaticLights/TurnOnOff',
                request_serializer=automaticlights__pb2.requestMessage.SerializeToString,
                response_deserializer=automaticlights__pb2.requestMessage.FromString,
                )
        self.status = channel.unary_unary(
                '/autoLights.AutomaticLights/status',
                request_serializer=automaticlights__pb2.queryMessage.SerializeToString,
                response_deserializer=automaticlights__pb2.queryMessage.FromString,
                )


class AutomaticLightsServicer(object):
    """The AutomaticLights service definition.
    """

    def TurnOnOff(self, request, context):
        """Sends a simple request to turn on/off the lights. 
        The client message contains its desired state.
        The server returns the state after processing the request. If it succedes, voteID = 0; non-zero number, otherwise.
        """
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def status(self, request, context):
        """Queries the state of the room (light intensity, state on/off, vote going on)
        Every 5s(?) queries the server about: 
        1. the light intensity (numerical value of the sensor reading);
        2. current state (true if on, false otherwise);
        3. If there is a vote going on (vote id number, randomly generated, 0 if none)
        4. The list of people inside the room
        """
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_AutomaticLightsServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'TurnOnOff': grpc.unary_unary_rpc_method_handler(
                    servicer.TurnOnOff,
                    request_deserializer=automaticlights__pb2.requestMessage.FromString,
                    response_serializer=automaticlights__pb2.requestMessage.SerializeToString,
            ),
            'status': grpc.unary_unary_rpc_method_handler(
                    servicer.status,
                    request_deserializer=automaticlights__pb2.queryMessage.FromString,
                    response_serializer=automaticlights__pb2.queryMessage.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'autoLights.AutomaticLights', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class AutomaticLights(object):
    """The AutomaticLights service definition.
    """

    @staticmethod
    def TurnOnOff(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/autoLights.AutomaticLights/TurnOnOff',
            automaticlights__pb2.requestMessage.SerializeToString,
            automaticlights__pb2.requestMessage.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def status(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            insecure=False,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_unary(request, target, '/autoLights.AutomaticLights/status',
            automaticlights__pb2.queryMessage.SerializeToString,
            automaticlights__pb2.queryMessage.FromString,
            options, channel_credentials,
            insecure, call_credentials, compression, wait_for_ready, timeout, metadata)
