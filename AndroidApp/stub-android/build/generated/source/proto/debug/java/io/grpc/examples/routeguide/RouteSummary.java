// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: io/grpc/examples/routeguide/route_guide.proto

package io.grpc.examples.routeguide;

/**
 * <pre>
 * A RouteSummary is received in response to a RecordRoute rpc.
 * It contains the number of individual points received, the number of
 * detected features, and the total distance covered as the cumulative sum of
 * the distance between each point.
 * </pre>
 *
 * Protobuf type {@code io.grpc.examples.routeguide.RouteSummary}
 */
public  final class RouteSummary extends
    com.google.protobuf.GeneratedMessageLite<
        RouteSummary, RouteSummary.Builder> implements
    // @@protoc_insertion_point(message_implements:io.grpc.examples.routeguide.RouteSummary)
    RouteSummaryOrBuilder {
  private RouteSummary() {
  }
  public static final int POINT_COUNT_FIELD_NUMBER = 1;
  private int pointCount_;
  /**
   * <pre>
   * The number of points received.
   * </pre>
   *
   * <code>int32 point_count = 1;</code>
   * @return The pointCount.
   */
  @java.lang.Override
  public int getPointCount() {
    return pointCount_;
  }
  /**
   * <pre>
   * The number of points received.
   * </pre>
   *
   * <code>int32 point_count = 1;</code>
   * @param value The pointCount to set.
   */
  private void setPointCount(int value) {
    
    pointCount_ = value;
  }
  /**
   * <pre>
   * The number of points received.
   * </pre>
   *
   * <code>int32 point_count = 1;</code>
   */
  private void clearPointCount() {
    
    pointCount_ = 0;
  }

  public static final int FEATURE_COUNT_FIELD_NUMBER = 2;
  private int featureCount_;
  /**
   * <pre>
   * The number of known features passed while traversing the route.
   * </pre>
   *
   * <code>int32 feature_count = 2;</code>
   * @return The featureCount.
   */
  @java.lang.Override
  public int getFeatureCount() {
    return featureCount_;
  }
  /**
   * <pre>
   * The number of known features passed while traversing the route.
   * </pre>
   *
   * <code>int32 feature_count = 2;</code>
   * @param value The featureCount to set.
   */
  private void setFeatureCount(int value) {
    
    featureCount_ = value;
  }
  /**
   * <pre>
   * The number of known features passed while traversing the route.
   * </pre>
   *
   * <code>int32 feature_count = 2;</code>
   */
  private void clearFeatureCount() {
    
    featureCount_ = 0;
  }

  public static final int DISTANCE_FIELD_NUMBER = 3;
  private int distance_;
  /**
   * <pre>
   * The distance covered in metres.
   * </pre>
   *
   * <code>int32 distance = 3;</code>
   * @return The distance.
   */
  @java.lang.Override
  public int getDistance() {
    return distance_;
  }
  /**
   * <pre>
   * The distance covered in metres.
   * </pre>
   *
   * <code>int32 distance = 3;</code>
   * @param value The distance to set.
   */
  private void setDistance(int value) {
    
    distance_ = value;
  }
  /**
   * <pre>
   * The distance covered in metres.
   * </pre>
   *
   * <code>int32 distance = 3;</code>
   */
  private void clearDistance() {
    
    distance_ = 0;
  }

  public static final int ELAPSED_TIME_FIELD_NUMBER = 4;
  private com.google.protobuf.Duration elapsedTime_;
  /**
   * <pre>
   * The duration of the traversal.
   * </pre>
   *
   * <code>.google.protobuf.Duration elapsed_time = 4;</code>
   */
  @java.lang.Override
  public boolean hasElapsedTime() {
    return elapsedTime_ != null;
  }
  /**
   * <pre>
   * The duration of the traversal.
   * </pre>
   *
   * <code>.google.protobuf.Duration elapsed_time = 4;</code>
   */
  @java.lang.Override
  public com.google.protobuf.Duration getElapsedTime() {
    return elapsedTime_ == null ? com.google.protobuf.Duration.getDefaultInstance() : elapsedTime_;
  }
  /**
   * <pre>
   * The duration of the traversal.
   * </pre>
   *
   * <code>.google.protobuf.Duration elapsed_time = 4;</code>
   */
  private void setElapsedTime(com.google.protobuf.Duration value) {
    value.getClass();
  elapsedTime_ = value;
    
    }
  /**
   * <pre>
   * The duration of the traversal.
   * </pre>
   *
   * <code>.google.protobuf.Duration elapsed_time = 4;</code>
   */
  @java.lang.SuppressWarnings({"ReferenceEquality"})
  private void mergeElapsedTime(com.google.protobuf.Duration value) {
    value.getClass();
  if (elapsedTime_ != null &&
        elapsedTime_ != com.google.protobuf.Duration.getDefaultInstance()) {
      elapsedTime_ =
        com.google.protobuf.Duration.newBuilder(elapsedTime_).mergeFrom(value).buildPartial();
    } else {
      elapsedTime_ = value;
    }
    
  }
  /**
   * <pre>
   * The duration of the traversal.
   * </pre>
   *
   * <code>.google.protobuf.Duration elapsed_time = 4;</code>
   */
  private void clearElapsedTime() {  elapsedTime_ = null;
    
  }

  public static io.grpc.examples.routeguide.RouteSummary parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static io.grpc.examples.routeguide.RouteSummary parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static io.grpc.examples.routeguide.RouteSummary parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static io.grpc.examples.routeguide.RouteSummary parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static io.grpc.examples.routeguide.RouteSummary parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data);
  }
  public static io.grpc.examples.routeguide.RouteSummary parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, data, extensionRegistry);
  }
  public static io.grpc.examples.routeguide.RouteSummary parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static io.grpc.examples.routeguide.RouteSummary parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static io.grpc.examples.routeguide.RouteSummary parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input);
  }
  public static io.grpc.examples.routeguide.RouteSummary parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
  }
  public static io.grpc.examples.routeguide.RouteSummary parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input);
  }
  public static io.grpc.examples.routeguide.RouteSummary parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageLite.parseFrom(
        DEFAULT_INSTANCE, input, extensionRegistry);
  }

  public static Builder newBuilder() {
    return (Builder) DEFAULT_INSTANCE.createBuilder();
  }
  public static Builder newBuilder(io.grpc.examples.routeguide.RouteSummary prototype) {
    return (Builder) DEFAULT_INSTANCE.createBuilder(prototype);
  }

  /**
   * <pre>
   * A RouteSummary is received in response to a RecordRoute rpc.
   * It contains the number of individual points received, the number of
   * detected features, and the total distance covered as the cumulative sum of
   * the distance between each point.
   * </pre>
   *
   * Protobuf type {@code io.grpc.examples.routeguide.RouteSummary}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageLite.Builder<
        io.grpc.examples.routeguide.RouteSummary, Builder> implements
      // @@protoc_insertion_point(builder_implements:io.grpc.examples.routeguide.RouteSummary)
      io.grpc.examples.routeguide.RouteSummaryOrBuilder {
    // Construct using io.grpc.examples.routeguide.RouteSummary.newBuilder()
    private Builder() {
      super(DEFAULT_INSTANCE);
    }


    /**
     * <pre>
     * The number of points received.
     * </pre>
     *
     * <code>int32 point_count = 1;</code>
     * @return The pointCount.
     */
    @java.lang.Override
    public int getPointCount() {
      return instance.getPointCount();
    }
    /**
     * <pre>
     * The number of points received.
     * </pre>
     *
     * <code>int32 point_count = 1;</code>
     * @param value The pointCount to set.
     * @return This builder for chaining.
     */
    public Builder setPointCount(int value) {
      copyOnWrite();
      instance.setPointCount(value);
      return this;
    }
    /**
     * <pre>
     * The number of points received.
     * </pre>
     *
     * <code>int32 point_count = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearPointCount() {
      copyOnWrite();
      instance.clearPointCount();
      return this;
    }

    /**
     * <pre>
     * The number of known features passed while traversing the route.
     * </pre>
     *
     * <code>int32 feature_count = 2;</code>
     * @return The featureCount.
     */
    @java.lang.Override
    public int getFeatureCount() {
      return instance.getFeatureCount();
    }
    /**
     * <pre>
     * The number of known features passed while traversing the route.
     * </pre>
     *
     * <code>int32 feature_count = 2;</code>
     * @param value The featureCount to set.
     * @return This builder for chaining.
     */
    public Builder setFeatureCount(int value) {
      copyOnWrite();
      instance.setFeatureCount(value);
      return this;
    }
    /**
     * <pre>
     * The number of known features passed while traversing the route.
     * </pre>
     *
     * <code>int32 feature_count = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearFeatureCount() {
      copyOnWrite();
      instance.clearFeatureCount();
      return this;
    }

    /**
     * <pre>
     * The distance covered in metres.
     * </pre>
     *
     * <code>int32 distance = 3;</code>
     * @return The distance.
     */
    @java.lang.Override
    public int getDistance() {
      return instance.getDistance();
    }
    /**
     * <pre>
     * The distance covered in metres.
     * </pre>
     *
     * <code>int32 distance = 3;</code>
     * @param value The distance to set.
     * @return This builder for chaining.
     */
    public Builder setDistance(int value) {
      copyOnWrite();
      instance.setDistance(value);
      return this;
    }
    /**
     * <pre>
     * The distance covered in metres.
     * </pre>
     *
     * <code>int32 distance = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearDistance() {
      copyOnWrite();
      instance.clearDistance();
      return this;
    }

    /**
     * <pre>
     * The duration of the traversal.
     * </pre>
     *
     * <code>.google.protobuf.Duration elapsed_time = 4;</code>
     */
    @java.lang.Override
    public boolean hasElapsedTime() {
      return instance.hasElapsedTime();
    }
    /**
     * <pre>
     * The duration of the traversal.
     * </pre>
     *
     * <code>.google.protobuf.Duration elapsed_time = 4;</code>
     */
    @java.lang.Override
    public com.google.protobuf.Duration getElapsedTime() {
      return instance.getElapsedTime();
    }
    /**
     * <pre>
     * The duration of the traversal.
     * </pre>
     *
     * <code>.google.protobuf.Duration elapsed_time = 4;</code>
     */
    public Builder setElapsedTime(com.google.protobuf.Duration value) {
      copyOnWrite();
      instance.setElapsedTime(value);
      return this;
      }
    /**
     * <pre>
     * The duration of the traversal.
     * </pre>
     *
     * <code>.google.protobuf.Duration elapsed_time = 4;</code>
     */
    public Builder setElapsedTime(
        com.google.protobuf.Duration.Builder builderForValue) {
      copyOnWrite();
      instance.setElapsedTime(builderForValue.build());
      return this;
    }
    /**
     * <pre>
     * The duration of the traversal.
     * </pre>
     *
     * <code>.google.protobuf.Duration elapsed_time = 4;</code>
     */
    public Builder mergeElapsedTime(com.google.protobuf.Duration value) {
      copyOnWrite();
      instance.mergeElapsedTime(value);
      return this;
    }
    /**
     * <pre>
     * The duration of the traversal.
     * </pre>
     *
     * <code>.google.protobuf.Duration elapsed_time = 4;</code>
     */
    public Builder clearElapsedTime() {  copyOnWrite();
      instance.clearElapsedTime();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:io.grpc.examples.routeguide.RouteSummary)
  }
  @java.lang.Override
  @java.lang.SuppressWarnings({"unchecked", "fallthrough"})
  protected final java.lang.Object dynamicMethod(
      com.google.protobuf.GeneratedMessageLite.MethodToInvoke method,
      java.lang.Object arg0, java.lang.Object arg1) {
    switch (method) {
      case NEW_MUTABLE_INSTANCE: {
        return new io.grpc.examples.routeguide.RouteSummary();
      }
      case NEW_BUILDER: {
        return new Builder();
      }
      case BUILD_MESSAGE_INFO: {
          java.lang.Object[] objects = new java.lang.Object[] {
            "pointCount_",
            "featureCount_",
            "distance_",
            "elapsedTime_",
          };
          java.lang.String info =
              "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0002\u0004" +
              "\u0003\u0004\u0004\t";
          return newMessageInfo(DEFAULT_INSTANCE, info, objects);
      }
      // fall through
      case GET_DEFAULT_INSTANCE: {
        return DEFAULT_INSTANCE;
      }
      case GET_PARSER: {
        com.google.protobuf.Parser<io.grpc.examples.routeguide.RouteSummary> parser = PARSER;
        if (parser == null) {
          synchronized (io.grpc.examples.routeguide.RouteSummary.class) {
            parser = PARSER;
            if (parser == null) {
              parser =
                  new DefaultInstanceBasedParser<io.grpc.examples.routeguide.RouteSummary>(
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


  // @@protoc_insertion_point(class_scope:io.grpc.examples.routeguide.RouteSummary)
  private static final io.grpc.examples.routeguide.RouteSummary DEFAULT_INSTANCE;
  static {
    RouteSummary defaultInstance = new RouteSummary();
    // New instances are implicitly immutable so no need to make
    // immutable.
    DEFAULT_INSTANCE = defaultInstance;
    com.google.protobuf.GeneratedMessageLite.registerDefaultInstance(
      RouteSummary.class, defaultInstance);
  }

  public static io.grpc.examples.routeguide.RouteSummary getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static volatile com.google.protobuf.Parser<RouteSummary> PARSER;

  public static com.google.protobuf.Parser<RouteSummary> parser() {
    return DEFAULT_INSTANCE.getParserForType();
  }
}

