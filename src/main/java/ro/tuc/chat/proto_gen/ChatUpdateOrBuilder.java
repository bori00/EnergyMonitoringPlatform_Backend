// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package ro.tuc.chat.proto_gen;

public interface ChatUpdateOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ro.tuc.chat.proto_gen.ChatUpdate)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.ro.tuc.chat.proto_gen.ChatMessage message = 1;</code>
   * @return Whether the message field is set.
   */
  boolean hasMessage();
  /**
   * <code>.ro.tuc.chat.proto_gen.ChatMessage message = 1;</code>
   * @return The message.
   */
  ro.tuc.chat.proto_gen.ChatMessage getMessage();
  /**
   * <code>.ro.tuc.chat.proto_gen.ChatMessage message = 1;</code>
   */
  ro.tuc.chat.proto_gen.ChatMessageOrBuilder getMessageOrBuilder();

  /**
   * <code>.ro.tuc.chat.proto_gen.MessageReadingStatus readingStatus = 2;</code>
   * @return Whether the readingStatus field is set.
   */
  boolean hasReadingStatus();
  /**
   * <code>.ro.tuc.chat.proto_gen.MessageReadingStatus readingStatus = 2;</code>
   * @return The readingStatus.
   */
  ro.tuc.chat.proto_gen.MessageReadingStatus getReadingStatus();
  /**
   * <code>.ro.tuc.chat.proto_gen.MessageReadingStatus readingStatus = 2;</code>
   */
  ro.tuc.chat.proto_gen.MessageReadingStatusOrBuilder getReadingStatusOrBuilder();

  /**
   * <code>.ro.tuc.chat.proto_gen.MessageTypingStatus typingStatus = 3;</code>
   * @return Whether the typingStatus field is set.
   */
  boolean hasTypingStatus();
  /**
   * <code>.ro.tuc.chat.proto_gen.MessageTypingStatus typingStatus = 3;</code>
   * @return The typingStatus.
   */
  ro.tuc.chat.proto_gen.MessageTypingStatus getTypingStatus();
  /**
   * <code>.ro.tuc.chat.proto_gen.MessageTypingStatus typingStatus = 3;</code>
   */
  ro.tuc.chat.proto_gen.MessageTypingStatusOrBuilder getTypingStatusOrBuilder();

  /**
   * <code>.ro.tuc.chat.proto_gen.SessionClosedUpdate sessionClosedUpdate = 4;</code>
   * @return Whether the sessionClosedUpdate field is set.
   */
  boolean hasSessionClosedUpdate();
  /**
   * <code>.ro.tuc.chat.proto_gen.SessionClosedUpdate sessionClosedUpdate = 4;</code>
   * @return The sessionClosedUpdate.
   */
  ro.tuc.chat.proto_gen.SessionClosedUpdate getSessionClosedUpdate();
  /**
   * <code>.ro.tuc.chat.proto_gen.SessionClosedUpdate sessionClosedUpdate = 4;</code>
   */
  ro.tuc.chat.proto_gen.SessionClosedUpdateOrBuilder getSessionClosedUpdateOrBuilder();

  public ro.tuc.chat.proto_gen.ChatUpdate.UpdateCase getUpdateCase();
}