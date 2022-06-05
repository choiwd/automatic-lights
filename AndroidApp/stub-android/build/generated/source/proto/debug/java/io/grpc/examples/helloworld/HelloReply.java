// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: io/grpc/examples/helloworld/hello_world.proto

package io.grpc.examples.helloworld;

/**
 * <pre>
 * The response message containing the greetings
 * </pre>
 *
 * Protobuf type {@code helloworld.HelloReply}
 */
public  final class HelloReply extends
    com.google.protobuf.GeneratedMessageLite<
        HelloReply, HelloReply.Builder> implements
    // @@protoc_insertion_point(message_implements:helloworld.HelloReply)
    HelloReplyOrBuilder {
  private HelloReply() {
    message_ = "";
  }
  public static final int MESSAGE_FIELD_NUMBER = 1;
  private java.lang.String message_;
  /**
   * <code>string message = 1;</code>
   * @return The message.
   */
  @java.lang.Override
  public java.lang.String getMessage() {
    return message_;
  }
  /**
   * <code>string message = 1;</code>
   * @return The bytes for message.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getMessageBytes() {
    return com.google.protobuf.ByteString.copyFromUtf8(message_);
  }
  /**
   * <code>string message = 1;</code>
   * @param value The message to set.
   */
  private void setMessage(
      java.lang.String value) {
    java.lang.Class<?> valueClass = value.getClass();
  
    message_ = value;
  }
  /**
   * <code>string message = 1;</code>
   */
  private void clearMessage() {
    
    message_ = getDefaultInstance().getMessage();
  }
  /**
   * <code>string message = 1;</code>
   * @param value The bytes for message to set.
   */
  private void setMessageBytes(
      com.google.protobuf.ByteString value) {
    checkByteStringIsUtf8(value);
    message_ = value.toStringUtf8();
    
  }

  public static io.grpc.examples.helloworld.HelloReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static io.grpc.examples.helloworld.HelloReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static io.grpc.examples.helloworld.HelloReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static io.grpc.examples.helloworld.HelloReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static io.grpc.examples.helloworld.HelloReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static io.grpc.examples.helloworld.HelloReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static io.grpc.examples.helloworld.HelloReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static io.grpc.examples.helloworld.HelloReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static io.grpc.examples.helloworld.HelloReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static io.grpc.examples.helloworld.HelloReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static io.grpc.examples.helloworld.HelloReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static io.grpc.examples.helloworld.HelloReply parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return (Builder) DEFAULT_INSTANCE.createBuilder();
  }
  public static Builder newBuilder(io.grpc.examples.helloworld.HelloReply prototype) {
    return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
  }

  /**
   * <pre>
   * The response message containing the greetings
   * </pre>
   *
   * Protobuf type {@code helloworld.HelloReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        io.grpc.examples.helloworld.HelloReply, Builder> implements
      // @@protoc_insertion_point(builder_implements:helloworld.HelloReply)
      io.grpc.examples.helloworld.HelloReplyOrBuilder {
    // Construct using io.grpc.examples.helloworld.HelloReply.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>string message = 1;</code>
     * @return The message.
     */
    @java.lang.Override
    public java.lang.String getMessage() {
      return instance.getMessage();
    }
    /**
     * <code>string message = 1;</code>
     * @return The bytes for message.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString
        getMessageBytes() {
      return instance.getMessageBytes();
    }
    /**
     * <code>string message = 1;</code>
     * @param value The message to set.
     * @return This builder for chaining.
     */
    public Builder setMessage(
        java.lang.String value) {
      copyOnWrite();
      instance.setMessage(value);
      return this;
    }
    /**
     * <code>string message = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearMessage() {
      copyOnWrite();
      instance.clearMessage();
      return this;
    }
    /**
     * <code>string message = 1;</code>
     * @param value The bytes for message to set.
     * @return This builder for chaining.
     */
    public Builder setMessageBytes(
        com.google.protobuf.ByteString value) {
      copyOnWrite();
      instance.setMessageBytes(value);
      return this;
    }

    // @@protoc_insertion_point(builder_scope:helloworld.HelloReply)
  }
  @java.lang.Override
  @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
  protected final java.lang.Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      java.lang.Object arg0, java.lang.Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new io.grpc.examples.helloworld.HelloReply();
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case BUILD_MESSAGE_INFO: {
          java.lang.Object[] objects = new java.lang.Object[] {
            "message_",
          };
          java.lang.String info =
              "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u0208";
          return newMessageInfo(DEFAULT_INSTANCE, info, objects);
      }
      // fall through
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        com.google.protobuf.Parser<io.grpc.examples.helloworld.HelloReply> parser = PARSER;
        if (parser == null) {
          synchronized (io.grpc.examples.helloworld.HelloReply.class) {
            parser = PARSER;
            if (parser == null) {
              parser =
                  new DefaultInstanceBasedParser<io.grpc.examples.helloworld.HelloReply>(
                      DEFAULT_INSTANCE);
              PARSER = parser;
            }
          }
        }
        return parser;
    }
    case GET_MEMOIZED_IS_INITIALIZED: {
      return (byte) 1;
    }
    case SET_MEMOIZED_IS_INITIALIZED: {
      return null;
    }
    }
    throw new UnsupportedOperationException();
  }


  // @@protoc_insertion_point(class_scope:helloworld.HelloReply)
  private static final io.grpc.examples.helloworld.HelloReply DEFAULT_INSTANCE;
  static {
    HelloReply defaultInstance = new HelloReply();
    // New instances are implicitly immutable so no need to make
    // immutable.
    DEFAULT_INSTANCE = defaultInstance;
    com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
      HelloReply.class, defaultInstance);
  }

  public static io.grpc.examples.helloworld.HelloReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<HelloReply> PARSER;

  public static com.google.protobuf.Parser<HelloReply> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

