// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: io/grpc/examples/se/automaticlights.proto

package se;

/**
 * Protobuf type {@code autoLights.requestMessage}
 */
public  final class requestMessage extends
    com.google.protobuf.GeneratedMessageLite<
        requestMessage, requestMessage.Builder> implements
    // @@protoc_insertion_point(message_implements:autoLights.requestMessage)
    requestMessageOrBuilder {
  private requestMessage() {
  }
  public static final int ONOFF_FIELD_NUMBER = 1;
  private boolean onOff_;
  /**
   * <code>bool OnOff = 1;</code>
   * @return The onOff.
   */
  @java.lang.Override
  public boolean getOnOff() {
    return onOff_;
  }
  /**
   * <code>bool OnOff = 1;</code>
   * @param value The onOff to set.
   */
  private void setOnOff(boolean value) {
    
    onOff_ = value;
  }
  /**
   * <code>bool OnOff = 1;</code>
   */
  private void clearOnOff() {
    
    onOff_ = false;
  }

  public static final int VOTEID_FIELD_NUMBER = 3;
  private int voteID_;
  /**
   * <code>int32 voteID = 3;</code>
   * @return The voteID.
   */
  @java.lang.Override
  public int getVoteID() {
    return voteID_;
  }
  /**
   * <code>int32 voteID = 3;</code>
   * @param value The voteID to set.
   */
  private void setVoteID(int value) {
    
    voteID_ = value;
  }
  /**
   * <code>int32 voteID = 3;</code>
   */
  private void clearVoteID() {
    
    voteID_ = 0;
  }

  public static se.requestMessage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static se.requestMessage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static se.requestMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static se.requestMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static se.requestMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static se.requestMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static se.requestMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static se.requestMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static se.requestMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static se.requestMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static se.requestMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static se.requestMessage parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return (Builder) DEFAULT_INSTANCE.createBuilder();
  }
  public static Builder newBuilder(se.requestMessage prototype) {
    return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
  }

  /**
   * Protobuf type {@code autoLights.requestMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        se.requestMessage, Builder> implements
      // @@protoc_insertion_point(builder_implements:autoLights.requestMessage)
      se.requestMessageOrBuilder {
    // Construct using se.requestMessage.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>bool OnOff = 1;</code>
     * @return The onOff.
     */
    @java.lang.Override
    public boolean getOnOff() {
      return instance.getOnOff();
    }
    /**
     * <code>bool OnOff = 1;</code>
     * @param value The onOff to set.
     * @return This builder for chaining.
     */
    public Builder setOnOff(boolean value) {
      copyOnWrite();
      instance.setOnOff(value);
      return this;
    }
    /**
     * <code>bool OnOff = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearOnOff() {
      copyOnWrite();
      instance.clearOnOff();
      return this;
    }

    /**
     * <code>int32 voteID = 3;</code>
     * @return The voteID.
     */
    @java.lang.Override
    public int getVoteID() {
      return instance.getVoteID();
    }
    /**
     * <code>int32 voteID = 3;</code>
     * @param value The voteID to set.
     * @return This builder for chaining.
     */
    public Builder setVoteID(int value) {
      copyOnWrite();
      instance.setVoteID(value);
      return this;
    }
    /**
     * <code>int32 voteID = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearVoteID() {
      copyOnWrite();
      instance.clearVoteID();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:autoLights.requestMessage)
  }
  @java.lang.Override
  @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
  protected final java.lang.Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      java.lang.Object arg0, java.lang.Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new se.requestMessage();
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case BUILD_MESSAGE_INFO: {
          java.lang.Object[] objects = new java.lang.Object[] {
            "onOff_",
            "voteID_",
          };
          java.lang.String info =
              "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u0007\u0003\u0004" +
              "";
          return newMessageInfo(DEFAULT_INSTANCE, info, objects);
      }
      // fall through
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        com.google.protobuf.Parser<se.requestMessage> parser = PARSER;
        if (parser == null) {
          synchronized (se.requestMessage.class) {
            parser = PARSER;
            if (parser == null) {
              parser =
                  new DefaultInstanceBasedParser<se.requestMessage>(
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


  // @@protoc_insertion_point(class_scope:autoLights.requestMessage)
  private static final se.requestMessage DEFAULT_INSTANCE;
  static {
    requestMessage defaultInstance = new requestMessage();
    // New instances are implicitly immutable so no need to make
    // immutable.
    DEFAULT_INSTANCE = defaultInstance;
    com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
      requestMessage.class, defaultInstance);
  }

  public static se.requestMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<requestMessage> PARSER;

  public static com.google.protobuf.Parser<requestMessage> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

