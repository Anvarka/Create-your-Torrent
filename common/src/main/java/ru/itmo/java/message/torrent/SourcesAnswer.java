// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: torrent.proto

package ru.itmo.java.message.torrent;

/**
 * Protobuf type {@code ru.itmo.java.message.torrent.SourcesAnswer}
 */
public final class SourcesAnswer extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ru.itmo.java.message.torrent.SourcesAnswer)
    SourcesAnswerOrBuilder {
private static final long serialVersionUID = 0L;
  // Use SourcesAnswer.newBuilder() to construct.
  private SourcesAnswer(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private SourcesAnswer() {
    clientWithFile_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new SourcesAnswer();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private SourcesAnswer(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              clientWithFile_ = new java.util.ArrayList<ru.itmo.java.message.torrent.UserInfo>();
              mutable_bitField0_ |= 0x00000001;
            }
            clientWithFile_.add(
                input.readMessage(ru.itmo.java.message.torrent.UserInfo.parser(), extensionRegistry));
            break;
          }
          case 16: {

            idFile_ = input.readInt64();
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        clientWithFile_ = java.util.Collections.unmodifiableList(clientWithFile_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_SourcesAnswer_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_SourcesAnswer_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ru.itmo.java.message.torrent.SourcesAnswer.class, ru.itmo.java.message.torrent.SourcesAnswer.Builder.class);
  }

  public static final int CLIENTWITHFILE_FIELD_NUMBER = 1;
  private java.util.List<ru.itmo.java.message.torrent.UserInfo> clientWithFile_;
  /**
   * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
   */
  @java.lang.Override
  public java.util.List<ru.itmo.java.message.torrent.UserInfo> getClientWithFileList() {
    return clientWithFile_;
  }
  /**
   * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends ru.itmo.java.message.torrent.UserInfoOrBuilder> 
      getClientWithFileOrBuilderList() {
    return clientWithFile_;
  }
  /**
   * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
   */
  @java.lang.Override
  public int getClientWithFileCount() {
    return clientWithFile_.size();
  }
  /**
   * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
   */
  @java.lang.Override
  public ru.itmo.java.message.torrent.UserInfo getClientWithFile(int index) {
    return clientWithFile_.get(index);
  }
  /**
   * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
   */
  @java.lang.Override
  public ru.itmo.java.message.torrent.UserInfoOrBuilder getClientWithFileOrBuilder(
      int index) {
    return clientWithFile_.get(index);
  }

  public static final int IDFILE_FIELD_NUMBER = 2;
  private long idFile_;
  /**
   * <code>int64 idFile = 2;</code>
   * @return The idFile.
   */
  @java.lang.Override
  public long getIdFile() {
    return idFile_;
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
    for (int i = 0; i < clientWithFile_.size(); i++) {
      output.writeMessage(1, clientWithFile_.get(i));
    }
    if (idFile_ != 0L) {
      output.writeInt64(2, idFile_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < clientWithFile_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, clientWithFile_.get(i));
    }
    if (idFile_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(2, idFile_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ru.itmo.java.message.torrent.SourcesAnswer)) {
      return super.equals(obj);
    }
    ru.itmo.java.message.torrent.SourcesAnswer other = (ru.itmo.java.message.torrent.SourcesAnswer) obj;

    if (!getClientWithFileList()
        .equals(other.getClientWithFileList())) return false;
    if (getIdFile()
        != other.getIdFile()) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getClientWithFileCount() > 0) {
      hash = (37 * hash) + CLIENTWITHFILE_FIELD_NUMBER;
      hash = (53 * hash) + getClientWithFileList().hashCode();
    }
    hash = (37 * hash) + IDFILE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getIdFile());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ru.itmo.java.message.torrent.SourcesAnswer parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.torrent.SourcesAnswer parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.SourcesAnswer parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.torrent.SourcesAnswer parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.SourcesAnswer parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.torrent.SourcesAnswer parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.SourcesAnswer parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.torrent.SourcesAnswer parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.SourcesAnswer parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.torrent.SourcesAnswer parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.SourcesAnswer parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.torrent.SourcesAnswer parseFrom(
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
  public static Builder newBuilder(ru.itmo.java.message.torrent.SourcesAnswer prototype) {
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
   * Protobuf type {@code ru.itmo.java.message.torrent.SourcesAnswer}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ru.itmo.java.message.torrent.SourcesAnswer)
      ru.itmo.java.message.torrent.SourcesAnswerOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_SourcesAnswer_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_SourcesAnswer_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ru.itmo.java.message.torrent.SourcesAnswer.class, ru.itmo.java.message.torrent.SourcesAnswer.Builder.class);
    }

    // Construct using ru.itmo.java.message.torrent.SourcesAnswer.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getClientWithFileFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (clientWithFileBuilder_ == null) {
        clientWithFile_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        clientWithFileBuilder_.clear();
      }
      idFile_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_SourcesAnswer_descriptor;
    }

    @java.lang.Override
    public ru.itmo.java.message.torrent.SourcesAnswer getDefaultInstanceForType() {
      return ru.itmo.java.message.torrent.SourcesAnswer.getDefaultInstance();
    }

    @java.lang.Override
    public ru.itmo.java.message.torrent.SourcesAnswer build() {
      ru.itmo.java.message.torrent.SourcesAnswer result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ru.itmo.java.message.torrent.SourcesAnswer buildPartial() {
      ru.itmo.java.message.torrent.SourcesAnswer result = new ru.itmo.java.message.torrent.SourcesAnswer(this);
      int from_bitField0_ = bitField0_;
      if (clientWithFileBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          clientWithFile_ = java.util.Collections.unmodifiableList(clientWithFile_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.clientWithFile_ = clientWithFile_;
      } else {
        result.clientWithFile_ = clientWithFileBuilder_.build();
      }
      result.idFile_ = idFile_;
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
      if (other instanceof ru.itmo.java.message.torrent.SourcesAnswer) {
        return mergeFrom((ru.itmo.java.message.torrent.SourcesAnswer)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ru.itmo.java.message.torrent.SourcesAnswer other) {
      if (other == ru.itmo.java.message.torrent.SourcesAnswer.getDefaultInstance()) return this;
      if (clientWithFileBuilder_ == null) {
        if (!other.clientWithFile_.isEmpty()) {
          if (clientWithFile_.isEmpty()) {
            clientWithFile_ = other.clientWithFile_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureClientWithFileIsMutable();
            clientWithFile_.addAll(other.clientWithFile_);
          }
          onChanged();
        }
      } else {
        if (!other.clientWithFile_.isEmpty()) {
          if (clientWithFileBuilder_.isEmpty()) {
            clientWithFileBuilder_.dispose();
            clientWithFileBuilder_ = null;
            clientWithFile_ = other.clientWithFile_;
            bitField0_ = (bitField0_ & ~0x00000001);
            clientWithFileBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getClientWithFileFieldBuilder() : null;
          } else {
            clientWithFileBuilder_.addAllMessages(other.clientWithFile_);
          }
        }
      }
      if (other.getIdFile() != 0L) {
        setIdFile(other.getIdFile());
      }
      this.mergeUnknownFields(other.unknownFields);
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
      ru.itmo.java.message.torrent.SourcesAnswer parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ru.itmo.java.message.torrent.SourcesAnswer) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<ru.itmo.java.message.torrent.UserInfo> clientWithFile_ =
      java.util.Collections.emptyList();
    private void ensureClientWithFileIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        clientWithFile_ = new java.util.ArrayList<ru.itmo.java.message.torrent.UserInfo>(clientWithFile_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        ru.itmo.java.message.torrent.UserInfo, ru.itmo.java.message.torrent.UserInfo.Builder, ru.itmo.java.message.torrent.UserInfoOrBuilder> clientWithFileBuilder_;

    /**
     * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
     */
    public java.util.List<ru.itmo.java.message.torrent.UserInfo> getClientWithFileList() {
      if (clientWithFileBuilder_ == null) {
        return java.util.Collections.unmodifiableList(clientWithFile_);
      } else {
        return clientWithFileBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
     */
    public int getClientWithFileCount() {
      if (clientWithFileBuilder_ == null) {
        return clientWithFile_.size();
      } else {
        return clientWithFileBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
     */
    public ru.itmo.java.message.torrent.UserInfo getClientWithFile(int index) {
      if (clientWithFileBuilder_ == null) {
        return clientWithFile_.get(index);
      } else {
        return clientWithFileBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
     */
    public Builder setClientWithFile(
        int index, ru.itmo.java.message.torrent.UserInfo value) {
      if (clientWithFileBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureClientWithFileIsMutable();
        clientWithFile_.set(index, value);
        onChanged();
      } else {
        clientWithFileBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
     */
    public Builder setClientWithFile(
        int index, ru.itmo.java.message.torrent.UserInfo.Builder builderForValue) {
      if (clientWithFileBuilder_ == null) {
        ensureClientWithFileIsMutable();
        clientWithFile_.set(index, builderForValue.build());
        onChanged();
      } else {
        clientWithFileBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
     */
    public Builder addClientWithFile(ru.itmo.java.message.torrent.UserInfo value) {
      if (clientWithFileBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureClientWithFileIsMutable();
        clientWithFile_.add(value);
        onChanged();
      } else {
        clientWithFileBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
     */
    public Builder addClientWithFile(
        int index, ru.itmo.java.message.torrent.UserInfo value) {
      if (clientWithFileBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureClientWithFileIsMutable();
        clientWithFile_.add(index, value);
        onChanged();
      } else {
        clientWithFileBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
     */
    public Builder addClientWithFile(
        ru.itmo.java.message.torrent.UserInfo.Builder builderForValue) {
      if (clientWithFileBuilder_ == null) {
        ensureClientWithFileIsMutable();
        clientWithFile_.add(builderForValue.build());
        onChanged();
      } else {
        clientWithFileBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
     */
    public Builder addClientWithFile(
        int index, ru.itmo.java.message.torrent.UserInfo.Builder builderForValue) {
      if (clientWithFileBuilder_ == null) {
        ensureClientWithFileIsMutable();
        clientWithFile_.add(index, builderForValue.build());
        onChanged();
      } else {
        clientWithFileBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
     */
    public Builder addAllClientWithFile(
        java.lang.Iterable<? extends ru.itmo.java.message.torrent.UserInfo> values) {
      if (clientWithFileBuilder_ == null) {
        ensureClientWithFileIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, clientWithFile_);
        onChanged();
      } else {
        clientWithFileBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
     */
    public Builder clearClientWithFile() {
      if (clientWithFileBuilder_ == null) {
        clientWithFile_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        clientWithFileBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
     */
    public Builder removeClientWithFile(int index) {
      if (clientWithFileBuilder_ == null) {
        ensureClientWithFileIsMutable();
        clientWithFile_.remove(index);
        onChanged();
      } else {
        clientWithFileBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
     */
    public ru.itmo.java.message.torrent.UserInfo.Builder getClientWithFileBuilder(
        int index) {
      return getClientWithFileFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
     */
    public ru.itmo.java.message.torrent.UserInfoOrBuilder getClientWithFileOrBuilder(
        int index) {
      if (clientWithFileBuilder_ == null) {
        return clientWithFile_.get(index);  } else {
        return clientWithFileBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
     */
    public java.util.List<? extends ru.itmo.java.message.torrent.UserInfoOrBuilder> 
         getClientWithFileOrBuilderList() {
      if (clientWithFileBuilder_ != null) {
        return clientWithFileBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(clientWithFile_);
      }
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
     */
    public ru.itmo.java.message.torrent.UserInfo.Builder addClientWithFileBuilder() {
      return getClientWithFileFieldBuilder().addBuilder(
          ru.itmo.java.message.torrent.UserInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
     */
    public ru.itmo.java.message.torrent.UserInfo.Builder addClientWithFileBuilder(
        int index) {
      return getClientWithFileFieldBuilder().addBuilder(
          index, ru.itmo.java.message.torrent.UserInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UserInfo clientWithFile = 1;</code>
     */
    public java.util.List<ru.itmo.java.message.torrent.UserInfo.Builder> 
         getClientWithFileBuilderList() {
      return getClientWithFileFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        ru.itmo.java.message.torrent.UserInfo, ru.itmo.java.message.torrent.UserInfo.Builder, ru.itmo.java.message.torrent.UserInfoOrBuilder> 
        getClientWithFileFieldBuilder() {
      if (clientWithFileBuilder_ == null) {
        clientWithFileBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            ru.itmo.java.message.torrent.UserInfo, ru.itmo.java.message.torrent.UserInfo.Builder, ru.itmo.java.message.torrent.UserInfoOrBuilder>(
                clientWithFile_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        clientWithFile_ = null;
      }
      return clientWithFileBuilder_;
    }

    private long idFile_ ;
    /**
     * <code>int64 idFile = 2;</code>
     * @return The idFile.
     */
    @java.lang.Override
    public long getIdFile() {
      return idFile_;
    }
    /**
     * <code>int64 idFile = 2;</code>
     * @param value The idFile to set.
     * @return This builder for chaining.
     */
    public Builder setIdFile(long value) {
      
      idFile_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 idFile = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearIdFile() {
      
      idFile_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:ru.itmo.java.message.torrent.SourcesAnswer)
  }

  // @@protoc_insertion_point(class_scope:ru.itmo.java.message.torrent.SourcesAnswer)
  private static final ru.itmo.java.message.torrent.SourcesAnswer DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ru.itmo.java.message.torrent.SourcesAnswer();
  }

  public static ru.itmo.java.message.torrent.SourcesAnswer getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<SourcesAnswer>
      PARSER = new com.google.protobuf.AbstractParser<SourcesAnswer>() {
    @java.lang.Override
    public SourcesAnswer parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new SourcesAnswer(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<SourcesAnswer> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<SourcesAnswer> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ru.itmo.java.message.torrent.SourcesAnswer getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

