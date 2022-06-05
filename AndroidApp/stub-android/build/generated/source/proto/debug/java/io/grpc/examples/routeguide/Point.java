// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: io/grpc/examples/routeguide/route_guide.proto

package io.grpc.examples.routeguide;

/**
 * <pre>
 * Points are represented as latitude-longitude pairs in the E7 representation
 * (degrees multiplied by 10**7 and rounded to the nearest integer).
 * Latitudes should be in the range +/- 90 degrees and longitude should be in
 * the range +/- 180 degrees (inclusive).
 * </pre>
 *
 * Protobuf type {@code io.grpc.examples.routeguide.Point}
 */
public  final class Point extends
    com.google.protobuf.GeneratedMessageLite<
        Point, Point.Builder> implements
    // @@protoc_insertion_point(message_implements:io.grpc.examples.routeguide.Point)
    PointOrBuilder {
  private Point() {
  }
  public static final int LATITUDE_FIELD_NUMBER = 1;
  private int latitude_;
  /**
   * <code>int32 latitude = 1;</code>
   * @return The latitude.
   */
  @java.lang.Override
  public int getLatitude() {
    return latitude_;
  }
  /**
   * <code>int32 latitude = 1;</code>
   * @param value The latitude to set.
   */
  private void setLatitude(int value) {
    
    latitude_ = value;
  }
  /**
   * <code>int32 latitude = 1;</code>
   */
  private void clearLatitude() {
    
    latitude_ = 0;
  }

  public static final int LONGITUDE_FIELD_NUMBER = 2;
  private int longitude_;
  /**
   * <code>int32 longitude = 2;</code>
   * @return The longitude.
   */
  @java.lang.Override
  public int getLongitude() {
    return longitude_;
  }
  /**
   * <code>int32 longitude = 2;</code>
   * @param value The longitude to set.
   */
  private void setLongitude(int value) {
    
    longitude_ = value;
  }
  /**
   * <code>int32 longitude = 2;</code>
   */
  private void clearLongitude() {
    
    longitude_ = 0;
  }

  public static io.grpc.examples.routeguide.Point parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static io.grpc.examples.routeguide.Point parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static io.grpc.examples.routeguide.Point parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static io.grpc.examples.routeguide.Point parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static io.grpc.examples.routeguide.Point parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static io.grpc.examples.routeguide.Point parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static io.grpc.examples.routeguide.Point parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static io.grpc.examples.routeguide.Point parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static io.grpc.examples.routeguide.Point parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static io.grpc.examples.routeguide.Point parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static io.grpc.examples.routeguide.Point parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static io.grpc.examples.routeguide.Point parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return (Builder) DEFAULT_INSTANCE.createBuilder();
  }
  public static Builder newBuilder(io.grpc.examples.routeguide.Point prototype) {
    return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
  }

  /**
   * <pre>
   * Points are represented as latitude-longitude pairs in the E7 representation
   * (degrees multiplied by 10**7 and rounded to the nearest integer).
   * Latitudes should be in the range +/- 90 degrees and longitude should be in
   * the range +/- 180 degrees (inclusive).
   * </pre>
   *
   * Protobuf type {@code io.grpc.examples.routeguide.Point}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        io.grpc.examples.routeguide.Point, Builder> implements
      // @@protoc_insertion_point(builder_implements:io.grpc.examples.routeguide.Point)
      io.grpc.examples.routeguide.PointOrBuilder {
    // Construct using io.grpc.examples.routeguide.Point.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <code>int32 latitude = 1;</code>
     * @return The latitude.
     */
    @java.lang.Override
    public int getLatitude() {
      return instance.getLatitude();
    }
    /**
     * <code>int32 latitude = 1;</code>
     * @param value The latitude to set.
     * @return This builder for chaining.
     */
    public Builder setLatitude(int value) {
      copyOnWrite();
      instance.setLatitude(value);
      return this;
    }
    /**
     * <code>int32 latitude = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearLatitude() {
      copyOnWrite();
      instance.clearLatitude();
      return this;
    }

    /**
     * <code>int32 longitude = 2;</code>
     * @return The longitude.
     */
    @java.lang.Override
    public int getLongitude() {
      return instance.getLongitude();
    }
    /**
     * <code>int32 longitude = 2;</code>
     * @param value The longitude to set.
     * @return This builder for chaining.
     */
    public Builder setLongitude(int value) {
      copyOnWrite();
      instance.setLongitude(value);
      return this;
    }
    /**
     * <code>int32 longitude = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearLongitude() {
      copyOnWrite();
      instance.clearLongitude();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:io.grpc.examples.routeguide.Point)
  }
  @java.lang.Override
  @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
  protected final java.lang.Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      java.lang.Object arg0, java.lang.Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new io.grpc.examples.routeguide.Point();
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case BUILD_MESSAGE_INFO: {
          java.lang.Object[] objects = new java.lang.Object[] {
            "latitude_",
            "longitude_",
          };
          java.lang.String info =
              "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002\u0004" +
              "";
          return newMessageInfo(DEFAULT_INSTANCE, info, objects);
      }
      // fall through
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        com.google.protobuf.Parser<io.grpc.examples.routeguide.Point> parser = PARSER;
        if (parser == null) {
          synchronized (io.grpc.examples.routeguide.Point.class) {
            parser = PARSER;
            if (parser == null) {
              parser =
                  new DefaultInstanceBasedParser<io.grpc.examples.routeguide.Point>(
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


  // @@protoc_insertion_point(class_scope:io.grpc.examples.routeguide.Point)
  private static final io.grpc.examples.routeguide.Point DEFAULT_INSTANCE;
  static {
    Point defaultInstance = new Point();
    // New instances are implicitly immutable so no need to make
    // immutable.
    DEFAULT_INSTANCE = defaultInstance;
    com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
      Point.class, defaultInstance);
  }

  public static io.grpc.examples.routeguide.Point getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<Point> PARSER;

  public static com.google.protobuf.Parser<Point> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

