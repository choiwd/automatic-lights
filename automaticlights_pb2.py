# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: automaticlights.proto
"""Generated protocol buffer code."""
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\x15\x61utomaticlights.proto\x12\nautoLights\"(\n\x07request\x12\r\n\x05OnOff\x18\x01 \x01(\x08\x12\x0e\n\x06voteID\x18\x03 \x01(\x05\"9\n\x05query\x12\r\n\x05OnOff\x18\x01 \x01(\x08\x12\x11\n\tintensity\x18\x02 \x01(\x05\x12\x0e\n\x06voteID\x18\x03 \x01(\x05\x32|\n\x0f\x41utomaticLights\x12\x37\n\tTurnOnOff\x12\x13.autoLights.request\x1a\x13.autoLights.request\"\x00\x12\x30\n\x06status\x12\x11.autoLights.query\x1a\x11.autoLights.query\"\x00\x42 \n\x02seB\x0f\x61utomaticLightsP\x01\xa2\x02\x06\x61utltsb\x06proto3')



_REQUEST = DESCRIPTOR.message_types_by_name['request']
_QUERY = DESCRIPTOR.message_types_by_name['query']
request = _reflection.GeneratedProtocolMessageType('request', (_message.Message,), {
  'DESCRIPTOR' : _REQUEST,
  '__module__' : 'automaticlights_pb2'
  # @@protoc_insertion_point(class_scope:autoLights.request)
  })
_sym_db.RegisterMessage(request)

query = _reflection.GeneratedProtocolMessageType('query', (_message.Message,), {
  'DESCRIPTOR' : _QUERY,
  '__module__' : 'automaticlights_pb2'
  # @@protoc_insertion_point(class_scope:autoLights.query)
  })
_sym_db.RegisterMessage(query)

_AUTOMATICLIGHTS = DESCRIPTOR.services_by_name['AutomaticLights']
if _descriptor._USE_C_DESCRIPTORS == False:

  DESCRIPTOR._options = None
  DESCRIPTOR._serialized_options = b'\n\002seB\017automaticLightsP\001\242\002\006autlts'
  _REQUEST._serialized_start=37
  _REQUEST._serialized_end=77
  _QUERY._serialized_start=79
  _QUERY._serialized_end=136
  _AUTOMATICLIGHTS._serialized_start=138
  _AUTOMATICLIGHTS._serialized_end=262
# @@protoc_insertion_point(module_scope)
