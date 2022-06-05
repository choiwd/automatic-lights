package se;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The AutomaticLights service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.0)",
    comments = "Source: io/grpc/examples/se/automaticlights.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AutomaticLightsGrpc {

  private AutomaticLightsGrpc() {}

  public static final String SERVICE_NAME = "autoLights.AutomaticLights";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<se.requestMessage,
      se.requestMessage> getTurnOnOffMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TurnOnOff",
      requestType = se.requestMessage.class,
      responseType = se.requestMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<se.requestMessage,
      se.requestMessage> getTurnOnOffMethod() {
    io.grpc.MethodDescriptor<se.requestMessage, se.requestMessage> getTurnOnOffMethod;
    if ((getTurnOnOffMethod = AutomaticLightsGrpc.getTurnOnOffMethod) == null) {
      synchronized (AutomaticLightsGrpc.class) {
        if ((getTurnOnOffMethod = AutomaticLightsGrpc.getTurnOnOffMethod) == null) {
          AutomaticLightsGrpc.getTurnOnOffMethod = getTurnOnOffMethod =
              io.grpc.MethodDescriptor.<se.requestMessage, se.requestMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TurnOnOff"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  se.requestMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  se.requestMessage.getDefaultInstance()))
              .build();
        }
      }
    }
    return getTurnOnOffMethod;
  }

  private static volatile io.grpc.MethodDescriptor<se.queryMessage,
      se.queryMessage> getStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "status",
      requestType = se.queryMessage.class,
      responseType = se.queryMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<se.queryMessage,
      se.queryMessage> getStatusMethod() {
    io.grpc.MethodDescriptor<se.queryMessage, se.queryMessage> getStatusMethod;
    if ((getStatusMethod = AutomaticLightsGrpc.getStatusMethod) == null) {
      synchronized (AutomaticLightsGrpc.class) {
        if ((getStatusMethod = AutomaticLightsGrpc.getStatusMethod) == null) {
          AutomaticLightsGrpc.getStatusMethod = getStatusMethod =
              io.grpc.MethodDescriptor.<se.queryMessage, se.queryMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "status"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  se.queryMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  se.queryMessage.getDefaultInstance()))
              .build();
        }
      }
    }
    return getStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AutomaticLightsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutomaticLightsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AutomaticLightsStub>() {
        @java.lang.Override
        public AutomaticLightsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AutomaticLightsStub(channel, callOptions);
        }
      };
    return AutomaticLightsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AutomaticLightsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutomaticLightsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AutomaticLightsBlockingStub>() {
        @java.lang.Override
        public AutomaticLightsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AutomaticLightsBlockingStub(channel, callOptions);
        }
      };
    return AutomaticLightsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AutomaticLightsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AutomaticLightsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AutomaticLightsFutureStub>() {
        @java.lang.Override
        public AutomaticLightsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AutomaticLightsFutureStub(channel, callOptions);
        }
      };
    return AutomaticLightsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The AutomaticLights service definition.
   * </pre>
   */
  public static abstract class AutomaticLightsImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a simple request to turn on/off the lights. 
     * The client message contains its desired state.
     * The server returns the state after processing the request. If it succedes, voteID = 0; non-zero number, otherwise.
     * </pre>
     */
    public void turnOnOff(se.requestMessage request,
        io.grpc.stub.StreamObserver<se.requestMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTurnOnOffMethod(), responseObserver);
    }

    /**
     * <pre>
     * Queries the state of the room (light intensity, state on/off, vote going on)
     * Every 5s(?) queries the server about: 
     * 1. the light intensity (numerical value of the sensor reading);
     * 2. current state (true if on, false otherwise);
     * 3. If there is a vote going on (vote id number, randomly generated, 0 if none)
     * 4. The list of people inside the room
     * </pre>
     */
    public void status(se.queryMessage request,
        io.grpc.stub.StreamObserver<se.queryMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTurnOnOffMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                se.requestMessage,
                se.requestMessage>(
                  this, METHODID_TURN_ON_OFF)))
          .addMethod(
            getStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                se.queryMessage,
                se.queryMessage>(
                  this, METHODID_STATUS)))
          .build();
    }
  }

  /**
   * <pre>
   * The AutomaticLights service definition.
   * </pre>
   */
  public static final class AutomaticLightsStub extends io.grpc.stub.AbstractAsyncStub<AutomaticLightsStub> {
    private AutomaticLightsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutomaticLightsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutomaticLightsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a simple request to turn on/off the lights. 
     * The client message contains its desired state.
     * The server returns the state after processing the request. If it succedes, voteID = 0; non-zero number, otherwise.
     * </pre>
     */
    public void turnOnOff(se.requestMessage request,
        io.grpc.stub.StreamObserver<se.requestMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTurnOnOffMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Queries the state of the room (light intensity, state on/off, vote going on)
     * Every 5s(?) queries the server about: 
     * 1. the light intensity (numerical value of the sensor reading);
     * 2. current state (true if on, false otherwise);
     * 3. If there is a vote going on (vote id number, randomly generated, 0 if none)
     * 4. The list of people inside the room
     * </pre>
     */
    public void status(se.queryMessage request,
        io.grpc.stub.StreamObserver<se.queryMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The AutomaticLights service definition.
   * </pre>
   */
  public static final class AutomaticLightsBlockingStub extends io.grpc.stub.AbstractBlockingStub<AutomaticLightsBlockingStub> {
    private AutomaticLightsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutomaticLightsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutomaticLightsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a simple request to turn on/off the lights. 
     * The client message contains its desired state.
     * The server returns the state after processing the request. If it succedes, voteID = 0; non-zero number, otherwise.
     * </pre>
     */
    public se.requestMessage turnOnOff(se.requestMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTurnOnOffMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Queries the state of the room (light intensity, state on/off, vote going on)
     * Every 5s(?) queries the server about: 
     * 1. the light intensity (numerical value of the sensor reading);
     * 2. current state (true if on, false otherwise);
     * 3. If there is a vote going on (vote id number, randomly generated, 0 if none)
     * 4. The list of people inside the room
     * </pre>
     */
    public se.queryMessage status(se.queryMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The AutomaticLights service definition.
   * </pre>
   */
  public static final class AutomaticLightsFutureStub extends io.grpc.stub.AbstractFutureStub<AutomaticLightsFutureStub> {
    private AutomaticLightsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AutomaticLightsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AutomaticLightsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a simple request to turn on/off the lights. 
     * The client message contains its desired state.
     * The server returns the state after processing the request. If it succedes, voteID = 0; non-zero number, otherwise.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<se.requestMessage> turnOnOff(
        se.requestMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTurnOnOffMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Queries the state of the room (light intensity, state on/off, vote going on)
     * Every 5s(?) queries the server about: 
     * 1. the light intensity (numerical value of the sensor reading);
     * 2. current state (true if on, false otherwise);
     * 3. If there is a vote going on (vote id number, randomly generated, 0 if none)
     * 4. The list of people inside the room
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<se.queryMessage> status(
        se.queryMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_TURN_ON_OFF = 0;
  private static final int METHODID_STATUS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AutomaticLightsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AutomaticLightsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TURN_ON_OFF:
          serviceImpl.turnOnOff((se.requestMessage) request,
              (io.grpc.stub.StreamObserver<se.requestMessage>) responseObserver);
          break;
        case METHODID_STATUS:
          serviceImpl.status((se.queryMessage) request,
              (io.grpc.stub.StreamObserver<se.queryMessage>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AutomaticLightsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getTurnOnOffMethod())
              .addMethod(getStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
