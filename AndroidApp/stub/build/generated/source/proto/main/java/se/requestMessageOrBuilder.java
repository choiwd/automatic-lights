// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: io/grpc/examples/se/automaticlights.proto

package se;

public interface requestMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:autoLights.requestMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool OnOff = 1;</code>
   * @return The onOff.
   */
  boolean getOnOff();

  /**
   * <code>int32 voteID = 3;</code>
   * @return The voteID.
   */
  int getVoteID();
}
