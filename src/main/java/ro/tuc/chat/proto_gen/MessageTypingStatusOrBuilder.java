// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package ro.tuc.chat.proto_gen;

public interface MessageTypingStatusOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ro.tuc.chat.proto_gen.MessageTypingStatus)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string typerUserName = 1;</code>
   * @return The typerUserName.
   */
  java.lang.String getTyperUserName();
  /**
   * <code>string typerUserName = 1;</code>
   * @return The bytes for typerUserName.
   */
  com.google.protobuf.ByteString
      getTyperUserNameBytes();

  /**
   * <code>string recipientUserName = 2;</code>
   * @return The recipientUserName.
   */
  java.lang.String getRecipientUserName();
  /**
   * <code>string recipientUserName = 2;</code>
   * @return The bytes for recipientUserName.
   */
  com.google.protobuf.ByteString
      getRecipientUserNameBytes();

  /**
   * <code>bool typing = 3;</code>
   * @return The typing.
   */
  boolean getTyping();
}
