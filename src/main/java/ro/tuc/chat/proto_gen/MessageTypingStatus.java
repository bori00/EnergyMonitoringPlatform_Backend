// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package ro.tuc.chat.proto_gen;

/**
 * Protobuf type {@code ro.tuc.chat.proto_gen.MessageTypingStatus}
 */
public final class MessageTypingStatus extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ro.tuc.chat.proto_gen.MessageTypingStatus)
    MessageTypingStatusOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MessageTypingStatus.newBuilder() to construct.
  private MessageTypingStatus(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MessageTypingStatus() {
    fromUserName_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new MessageTypingStatus();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ro.tuc.chat.proto_gen.Chat.internal_static_ro_tuc_chat_proto_gen_MessageTypingStatus_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ro.tuc.chat.proto_gen.Chat.internal_static_ro_tuc_chat_proto_gen_MessageTypingStatus_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ro.tuc.chat.proto_gen.MessageTypingStatus.class, ro.tuc.chat.proto_gen.MessageTypingStatus.Builder.class);
  }

  public static final int FROMUSERNAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object fromUserName_;
  /**
   * <code>string fromUserName = 1;</code>
   * @return The fromUserName.
   */
  @java.lang.Override
  public java.lang.String getFromUserName() {
    java.lang.Object ref = fromUserName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      fromUserName_ = s;
      return s;
    }
  }
  /**
   * <code>string fromUserName = 1;</code>
   * @return The bytes for fromUserName.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getFromUserNameBytes() {
    java.lang.Object ref = fromUserName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      fromUserName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TYPING_FIELD_NUMBER = 2;
  private boolean typing_;
  /**
   * <code>bool typing = 2;</code>
   * @return The typing.
   */
  @java.lang.Override
  public boolean getTyping() {
    return typing_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(fromUserName_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, fromUserName_);
    }
    if (typing_ != false) {
      output.writeBool(2, typing_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(fromUserName_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, fromUserName_);
    }
    if (typing_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, typing_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ro.tuc.chat.proto_gen.MessageTypingStatus)) {
      return super.equals(obj);
    }
    ro.tuc.chat.proto_gen.MessageTypingStatus other = (ro.tuc.chat.proto_gen.MessageTypingStatus) obj;

    if (!getFromUserName()
        .equals(other.getFromUserName())) return false;
    if (getTyping()
        != other.getTyping()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + FROMUSERNAME_FIELD_NUMBER;
    hash = (53 * hash) + getFromUserName().hashCode();
    hash = (37 * hash) + TYPING_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getTyping());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ro.tuc.chat.proto_gen.MessageTypingStatus parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ro.tuc.chat.proto_gen.MessageTypingStatus parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ro.tuc.chat.proto_gen.MessageTypingStatus parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ro.tuc.chat.proto_gen.MessageTypingStatus parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ro.tuc.chat.proto_gen.MessageTypingStatus parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ro.tuc.chat.proto_gen.MessageTypingStatus parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ro.tuc.chat.proto_gen.MessageTypingStatus parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ro.tuc.chat.proto_gen.MessageTypingStatus parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ro.tuc.chat.proto_gen.MessageTypingStatus parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ro.tuc.chat.proto_gen.MessageTypingStatus parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ro.tuc.chat.proto_gen.MessageTypingStatus parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ro.tuc.chat.proto_gen.MessageTypingStatus parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ro.tuc.chat.proto_gen.MessageTypingStatus prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ro.tuc.chat.proto_gen.MessageTypingStatus}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ro.tuc.chat.proto_gen.MessageTypingStatus)
      ro.tuc.chat.proto_gen.MessageTypingStatusOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ro.tuc.chat.proto_gen.Chat.internal_static_ro_tuc_chat_proto_gen_MessageTypingStatus_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ro.tuc.chat.proto_gen.Chat.internal_static_ro_tuc_chat_proto_gen_MessageTypingStatus_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ro.tuc.chat.proto_gen.MessageTypingStatus.class, ro.tuc.chat.proto_gen.MessageTypingStatus.Builder.class);
    }

    // Construct using ro.tuc.chat.proto_gen.MessageTypingStatus.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      fromUserName_ = "";

      typing_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ro.tuc.chat.proto_gen.Chat.internal_static_ro_tuc_chat_proto_gen_MessageTypingStatus_descriptor;
    }

    @java.lang.Override
    public ro.tuc.chat.proto_gen.MessageTypingStatus getDefaultInstanceForType() {
      return ro.tuc.chat.proto_gen.MessageTypingStatus.getDefaultInstance();
    }

    @java.lang.Override
    public ro.tuc.chat.proto_gen.MessageTypingStatus build() {
      ro.tuc.chat.proto_gen.MessageTypingStatus result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ro.tuc.chat.proto_gen.MessageTypingStatus buildPartial() {
      ro.tuc.chat.proto_gen.MessageTypingStatus result = new ro.tuc.chat.proto_gen.MessageTypingStatus(this);
      result.fromUserName_ = fromUserName_;
      result.typing_ = typing_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ro.tuc.chat.proto_gen.MessageTypingStatus) {
        return mergeFrom((ro.tuc.chat.proto_gen.MessageTypingStatus)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ro.tuc.chat.proto_gen.MessageTypingStatus other) {
      if (other == ro.tuc.chat.proto_gen.MessageTypingStatus.getDefaultInstance()) return this;
      if (!other.getFromUserName().isEmpty()) {
        fromUserName_ = other.fromUserName_;
        onChanged();
      }
      if (other.getTyping() != false) {
        setTyping(other.getTyping());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              fromUserName_ = input.readStringRequireUtf8();

              break;
            } // case 10
            case 16: {
              typing_ = input.readBool();

              break;
            } // case 16
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    private java.lang.Object fromUserName_ = "";
    /**
     * <code>string fromUserName = 1;</code>
     * @return The fromUserName.
     */
    public java.lang.String getFromUserName() {
      java.lang.Object ref = fromUserName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        fromUserName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string fromUserName = 1;</code>
     * @return The bytes for fromUserName.
     */
    public com.google.protobuf.ByteString
        getFromUserNameBytes() {
      java.lang.Object ref = fromUserName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        fromUserName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string fromUserName = 1;</code>
     * @param value The fromUserName to set.
     * @return This builder for chaining.
     */
    public Builder setFromUserName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      fromUserName_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string fromUserName = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearFromUserName() {
      
      fromUserName_ = getDefaultInstance().getFromUserName();
      onChanged();
      return this;
    }
    /**
     * <code>string fromUserName = 1;</code>
     * @param value The bytes for fromUserName to set.
     * @return This builder for chaining.
     */
    public Builder setFromUserNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      fromUserName_ = value;
      onChanged();
      return this;
    }

    private boolean typing_ ;
    /**
     * <code>bool typing = 2;</code>
     * @return The typing.
     */
    @java.lang.Override
    public boolean getTyping() {
      return typing_;
    }
    /**
     * <code>bool typing = 2;</code>
     * @param value The typing to set.
     * @return This builder for chaining.
     */
    public Builder setTyping(boolean value) {
      
      typing_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool typing = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTyping() {
      
      typing_ = false;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ro.tuc.chat.proto_gen.MessageTypingStatus)
  }

  // @@protoc_insertion_point(class_scope:ro.tuc.chat.proto_gen.MessageTypingStatus)
  private static final ro.tuc.chat.proto_gen.MessageTypingStatus DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ro.tuc.chat.proto_gen.MessageTypingStatus();
  }

  public static ro.tuc.chat.proto_gen.MessageTypingStatus getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MessageTypingStatus>
      PARSER = new com.google.protobuf.AbstractParser<MessageTypingStatus>() {
    @java.lang.Override
    public MessageTypingStatus parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<MessageTypingStatus> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MessageTypingStatus> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ro.tuc.chat.proto_gen.MessageTypingStatus getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
