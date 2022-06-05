// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: io/grpc/examples/se/automaticlights.proto

package se;

public interface queryMessageOrBuilder extends
    // @@protoc_insertion_point(interface_extends:autoLights.queryMessage)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool OnOff = 1;</code>
   * @return The onOff.
   */
  boolean getOnOff();

  /**
   * <code>int32 intensity = 2;</code>
   * @return The intensity.
   */
  int getIntensity();

  /**
   * <code>int32 voteID = 3;</code>
   * @return The voteID.
   */
  int getVoteID();

  /**
   * <code>repeated string participants = 4;</code>
   * @return A list containing the participants.
   */
  java.util.List<java.lang.String>
      getParticipantsList();
  /**
   * <code>repeated string participants = 4;</code>
   * @return The count of participants.
   */
  int getParticipantsCount();
  /**
   * <code>repeated string participants = 4;</code>
   * @param index The index of the element to return.
   * @return The participants at the given index.
   */
  java.lang.String getParticipants(int index);
  /**
   * <code>repeated string participants = 4;</code>
   * @param index The index of the value to return.
   * @return The bytes of the participants at the given index.
   */
  com.google.protobuf.ByteString
      getParticipantsBytes(int index);

  /**
   * <code>string name = 5;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 5;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();
}
