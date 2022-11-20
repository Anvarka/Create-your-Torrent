// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: torrent.proto

package ru.itmo.java.message.torrent;

/**
 * Protobuf type {@code ru.itmo.java.message.torrent.UpdateRequest}
 */
public final class UpdateRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ru.itmo.java.message.torrent.UpdateRequest)
    UpdateRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UpdateRequest.newBuilder() to construct.
  private UpdateRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UpdateRequest() {
    uploadAnswer_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new UpdateRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private UpdateRequest(
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
            ru.itmo.java.message.torrent.UserInfo.Builder subBuilder = null;
            if (userInfo_ != null) {
              subBuilder = userInfo_.toBuilder();
            }
            userInfo_ = input.readMessage(ru.itmo.java.message.torrent.UserInfo.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(userInfo_);
              userInfo_ = subBuilder.buildPartial();
            }

            break;
          }
          case 16: {

            portOfClientServer_ = input.readInt32();
            break;
          }
          case 24: {

            countSharedFiles_ = input.readInt64();
            break;
          }
          case 34: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              uploadAnswer_ = new java.util.ArrayList<ru.itmo.java.message.torrent.UploadAnswer>();
              mutable_bitField0_ |= 0x00000001;
            }
            uploadAnswer_.add(
                input.readMessage(ru.itmo.java.message.torrent.UploadAnswer.parser(), extensionRegistry));
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
        uploadAnswer_ = java.util.Collections.unmodifiableList(uploadAnswer_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_UpdateRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_UpdateRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ru.itmo.java.message.torrent.UpdateRequest.class, ru.itmo.java.message.torrent.UpdateRequest.Builder.class);
  }

  public static final int USERINFO_FIELD_NUMBER = 1;
  private ru.itmo.java.message.torrent.UserInfo userInfo_;
  /**
   * <code>.ru.itmo.java.message.torrent.UserInfo userInfo = 1;</code>
   * @return Whether the userInfo field is set.
   */
  @java.lang.Override
  public boolean hasUserInfo() {
    return userInfo_ != null;
  }
  /**
   * <code>.ru.itmo.java.message.torrent.UserInfo userInfo = 1;</code>
   * @return The userInfo.
   */
  @java.lang.Override
  public ru.itmo.java.message.torrent.UserInfo getUserInfo() {
    return userInfo_ == null ? ru.itmo.java.message.torrent.UserInfo.getDefaultInstance() : userInfo_;
  }
  /**
   * <code>.ru.itmo.java.message.torrent.UserInfo userInfo = 1;</code>
   */
  @java.lang.Override
  public ru.itmo.java.message.torrent.UserInfoOrBuilder getUserInfoOrBuilder() {
    return getUserInfo();
  }

  public static final int PORTOFCLIENTSERVER_FIELD_NUMBER = 2;
  private int portOfClientServer_;
  /**
   * <code>int32 portOfClientServer = 2;</code>
   * @return The portOfClientServer.
   */
  @java.lang.Override
  public int getPortOfClientServer() {
    return portOfClientServer_;
  }

  public static final int COUNTSHAREDFILES_FIELD_NUMBER = 3;
  private long countSharedFiles_;
  /**
   * <code>int64 countSharedFiles = 3;</code>
   * @return The countSharedFiles.
   */
  @java.lang.Override
  public long getCountSharedFiles() {
    return countSharedFiles_;
  }

  public static final int UPLOADANSWER_FIELD_NUMBER = 4;
  private java.util.List<ru.itmo.java.message.torrent.UploadAnswer> uploadAnswer_;
  /**
   * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
   */
  @java.lang.Override
  public java.util.List<ru.itmo.java.message.torrent.UploadAnswer> getUploadAnswerList() {
    return uploadAnswer_;
  }
  /**
   * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
   */
  @java.lang.Override
  public java.util.List<? extends ru.itmo.java.message.torrent.UploadAnswerOrBuilder> 
      getUploadAnswerOrBuilderList() {
    return uploadAnswer_;
  }
  /**
   * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
   */
  @java.lang.Override
  public int getUploadAnswerCount() {
    return uploadAnswer_.size();
  }
  /**
   * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
   */
  @java.lang.Override
  public ru.itmo.java.message.torrent.UploadAnswer getUploadAnswer(int index) {
    return uploadAnswer_.get(index);
  }
  /**
   * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
   */
  @java.lang.Override
  public ru.itmo.java.message.torrent.UploadAnswerOrBuilder getUploadAnswerOrBuilder(
      int index) {
    return uploadAnswer_.get(index);
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
    if (userInfo_ != null) {
      output.writeMessage(1, getUserInfo());
    }
    if (portOfClientServer_ != 0) {
      output.writeInt32(2, portOfClientServer_);
    }
    if (countSharedFiles_ != 0L) {
      output.writeInt64(3, countSharedFiles_);
    }
    for (int i = 0; i < uploadAnswer_.size(); i++) {
      output.writeMessage(4, uploadAnswer_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (userInfo_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getUserInfo());
    }
    if (portOfClientServer_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, portOfClientServer_);
    }
    if (countSharedFiles_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, countSharedFiles_);
    }
    for (int i = 0; i < uploadAnswer_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, uploadAnswer_.get(i));
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
    if (!(obj instanceof ru.itmo.java.message.torrent.UpdateRequest)) {
      return super.equals(obj);
    }
    ru.itmo.java.message.torrent.UpdateRequest other = (ru.itmo.java.message.torrent.UpdateRequest) obj;

    if (hasUserInfo() != other.hasUserInfo()) return false;
    if (hasUserInfo()) {
      if (!getUserInfo()
          .equals(other.getUserInfo())) return false;
    }
    if (getPortOfClientServer()
        != other.getPortOfClientServer()) return false;
    if (getCountSharedFiles()
        != other.getCountSharedFiles()) return false;
    if (!getUploadAnswerList()
        .equals(other.getUploadAnswerList())) return false;
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
    if (hasUserInfo()) {
      hash = (37 * hash) + USERINFO_FIELD_NUMBER;
      hash = (53 * hash) + getUserInfo().hashCode();
    }
    hash = (37 * hash) + PORTOFCLIENTSERVER_FIELD_NUMBER;
    hash = (53 * hash) + getPortOfClientServer();
    hash = (37 * hash) + COUNTSHAREDFILES_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getCountSharedFiles());
    if (getUploadAnswerCount() > 0) {
      hash = (37 * hash) + UPLOADANSWER_FIELD_NUMBER;
      hash = (53 * hash) + getUploadAnswerList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ru.itmo.java.message.torrent.UpdateRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.torrent.UpdateRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.UpdateRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.torrent.UpdateRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.UpdateRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.torrent.UpdateRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.UpdateRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.torrent.UpdateRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.UpdateRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.torrent.UpdateRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.UpdateRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.torrent.UpdateRequest parseFrom(
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
  public static Builder newBuilder(ru.itmo.java.message.torrent.UpdateRequest prototype) {
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
   * Protobuf type {@code ru.itmo.java.message.torrent.UpdateRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ru.itmo.java.message.torrent.UpdateRequest)
      ru.itmo.java.message.torrent.UpdateRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_UpdateRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_UpdateRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ru.itmo.java.message.torrent.UpdateRequest.class, ru.itmo.java.message.torrent.UpdateRequest.Builder.class);
    }

    // Construct using ru.itmo.java.message.torrent.UpdateRequest.newBuilder()
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
        getUploadAnswerFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (userInfoBuilder_ == null) {
        userInfo_ = null;
      } else {
        userInfo_ = null;
        userInfoBuilder_ = null;
      }
      portOfClientServer_ = 0;

      countSharedFiles_ = 0L;

      if (uploadAnswerBuilder_ == null) {
        uploadAnswer_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        uploadAnswerBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_UpdateRequest_descriptor;
    }

    @java.lang.Override
    public ru.itmo.java.message.torrent.UpdateRequest getDefaultInstanceForType() {
      return ru.itmo.java.message.torrent.UpdateRequest.getDefaultInstance();
    }

    @java.lang.Override
    public ru.itmo.java.message.torrent.UpdateRequest build() {
      ru.itmo.java.message.torrent.UpdateRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ru.itmo.java.message.torrent.UpdateRequest buildPartial() {
      ru.itmo.java.message.torrent.UpdateRequest result = new ru.itmo.java.message.torrent.UpdateRequest(this);
      int from_bitField0_ = bitField0_;
      if (userInfoBuilder_ == null) {
        result.userInfo_ = userInfo_;
      } else {
        result.userInfo_ = userInfoBuilder_.build();
      }
      result.portOfClientServer_ = portOfClientServer_;
      result.countSharedFiles_ = countSharedFiles_;
      if (uploadAnswerBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          uploadAnswer_ = java.util.Collections.unmodifiableList(uploadAnswer_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.uploadAnswer_ = uploadAnswer_;
      } else {
        result.uploadAnswer_ = uploadAnswerBuilder_.build();
      }
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
      if (other instanceof ru.itmo.java.message.torrent.UpdateRequest) {
        return mergeFrom((ru.itmo.java.message.torrent.UpdateRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ru.itmo.java.message.torrent.UpdateRequest other) {
      if (other == ru.itmo.java.message.torrent.UpdateRequest.getDefaultInstance()) return this;
      if (other.hasUserInfo()) {
        mergeUserInfo(other.getUserInfo());
      }
      if (other.getPortOfClientServer() != 0) {
        setPortOfClientServer(other.getPortOfClientServer());
      }
      if (other.getCountSharedFiles() != 0L) {
        setCountSharedFiles(other.getCountSharedFiles());
      }
      if (uploadAnswerBuilder_ == null) {
        if (!other.uploadAnswer_.isEmpty()) {
          if (uploadAnswer_.isEmpty()) {
            uploadAnswer_ = other.uploadAnswer_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureUploadAnswerIsMutable();
            uploadAnswer_.addAll(other.uploadAnswer_);
          }
          onChanged();
        }
      } else {
        if (!other.uploadAnswer_.isEmpty()) {
          if (uploadAnswerBuilder_.isEmpty()) {
            uploadAnswerBuilder_.dispose();
            uploadAnswerBuilder_ = null;
            uploadAnswer_ = other.uploadAnswer_;
            bitField0_ = (bitField0_ & ~0x00000001);
            uploadAnswerBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getUploadAnswerFieldBuilder() : null;
          } else {
            uploadAnswerBuilder_.addAllMessages(other.uploadAnswer_);
          }
        }
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
      ru.itmo.java.message.torrent.UpdateRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ru.itmo.java.message.torrent.UpdateRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private ru.itmo.java.message.torrent.UserInfo userInfo_;
    private com.google.protobuf.SingleFieldBuilderV3<
        ru.itmo.java.message.torrent.UserInfo, ru.itmo.java.message.torrent.UserInfo.Builder, ru.itmo.java.message.torrent.UserInfoOrBuilder> userInfoBuilder_;
    /**
     * <code>.ru.itmo.java.message.torrent.UserInfo userInfo = 1;</code>
     * @return Whether the userInfo field is set.
     */
    public boolean hasUserInfo() {
      return userInfoBuilder_ != null || userInfo_ != null;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.UserInfo userInfo = 1;</code>
     * @return The userInfo.
     */
    public ru.itmo.java.message.torrent.UserInfo getUserInfo() {
      if (userInfoBuilder_ == null) {
        return userInfo_ == null ? ru.itmo.java.message.torrent.UserInfo.getDefaultInstance() : userInfo_;
      } else {
        return userInfoBuilder_.getMessage();
      }
    }
    /**
     * <code>.ru.itmo.java.message.torrent.UserInfo userInfo = 1;</code>
     */
    public Builder setUserInfo(ru.itmo.java.message.torrent.UserInfo value) {
      if (userInfoBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        userInfo_ = value;
        onChanged();
      } else {
        userInfoBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.UserInfo userInfo = 1;</code>
     */
    public Builder setUserInfo(
        ru.itmo.java.message.torrent.UserInfo.Builder builderForValue) {
      if (userInfoBuilder_ == null) {
        userInfo_ = builderForValue.build();
        onChanged();
      } else {
        userInfoBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.UserInfo userInfo = 1;</code>
     */
    public Builder mergeUserInfo(ru.itmo.java.message.torrent.UserInfo value) {
      if (userInfoBuilder_ == null) {
        if (userInfo_ != null) {
          userInfo_ =
            ru.itmo.java.message.torrent.UserInfo.newBuilder(userInfo_).mergeFrom(value).buildPartial();
        } else {
          userInfo_ = value;
        }
        onChanged();
      } else {
        userInfoBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.UserInfo userInfo = 1;</code>
     */
    public Builder clearUserInfo() {
      if (userInfoBuilder_ == null) {
        userInfo_ = null;
        onChanged();
      } else {
        userInfo_ = null;
        userInfoBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.UserInfo userInfo = 1;</code>
     */
    public ru.itmo.java.message.torrent.UserInfo.Builder getUserInfoBuilder() {
      
      onChanged();
      return getUserInfoFieldBuilder().getBuilder();
    }
    /**
     * <code>.ru.itmo.java.message.torrent.UserInfo userInfo = 1;</code>
     */
    public ru.itmo.java.message.torrent.UserInfoOrBuilder getUserInfoOrBuilder() {
      if (userInfoBuilder_ != null) {
        return userInfoBuilder_.getMessageOrBuilder();
      } else {
        return userInfo_ == null ?
            ru.itmo.java.message.torrent.UserInfo.getDefaultInstance() : userInfo_;
      }
    }
    /**
     * <code>.ru.itmo.java.message.torrent.UserInfo userInfo = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        ru.itmo.java.message.torrent.UserInfo, ru.itmo.java.message.torrent.UserInfo.Builder, ru.itmo.java.message.torrent.UserInfoOrBuilder> 
        getUserInfoFieldBuilder() {
      if (userInfoBuilder_ == null) {
        userInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            ru.itmo.java.message.torrent.UserInfo, ru.itmo.java.message.torrent.UserInfo.Builder, ru.itmo.java.message.torrent.UserInfoOrBuilder>(
                getUserInfo(),
                getParentForChildren(),
                isClean());
        userInfo_ = null;
      }
      return userInfoBuilder_;
    }

    private int portOfClientServer_ ;
    /**
     * <code>int32 portOfClientServer = 2;</code>
     * @return The portOfClientServer.
     */
    @java.lang.Override
    public int getPortOfClientServer() {
      return portOfClientServer_;
    }
    /**
     * <code>int32 portOfClientServer = 2;</code>
     * @param value The portOfClientServer to set.
     * @return This builder for chaining.
     */
    public Builder setPortOfClientServer(int value) {
      
      portOfClientServer_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 portOfClientServer = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearPortOfClientServer() {
      
      portOfClientServer_ = 0;
      onChanged();
      return this;
    }

    private long countSharedFiles_ ;
    /**
     * <code>int64 countSharedFiles = 3;</code>
     * @return The countSharedFiles.
     */
    @java.lang.Override
    public long getCountSharedFiles() {
      return countSharedFiles_;
    }
    /**
     * <code>int64 countSharedFiles = 3;</code>
     * @param value The countSharedFiles to set.
     * @return This builder for chaining.
     */
    public Builder setCountSharedFiles(long value) {
      
      countSharedFiles_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 countSharedFiles = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearCountSharedFiles() {
      
      countSharedFiles_ = 0L;
      onChanged();
      return this;
    }

    private java.util.List<ru.itmo.java.message.torrent.UploadAnswer> uploadAnswer_ =
      java.util.Collections.emptyList();
    private void ensureUploadAnswerIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        uploadAnswer_ = new java.util.ArrayList<ru.itmo.java.message.torrent.UploadAnswer>(uploadAnswer_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        ru.itmo.java.message.torrent.UploadAnswer, ru.itmo.java.message.torrent.UploadAnswer.Builder, ru.itmo.java.message.torrent.UploadAnswerOrBuilder> uploadAnswerBuilder_;

    /**
     * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
     */
    public java.util.List<ru.itmo.java.message.torrent.UploadAnswer> getUploadAnswerList() {
      if (uploadAnswerBuilder_ == null) {
        return java.util.Collections.unmodifiableList(uploadAnswer_);
      } else {
        return uploadAnswerBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
     */
    public int getUploadAnswerCount() {
      if (uploadAnswerBuilder_ == null) {
        return uploadAnswer_.size();
      } else {
        return uploadAnswerBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
     */
    public ru.itmo.java.message.torrent.UploadAnswer getUploadAnswer(int index) {
      if (uploadAnswerBuilder_ == null) {
        return uploadAnswer_.get(index);
      } else {
        return uploadAnswerBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
     */
    public Builder setUploadAnswer(
        int index, ru.itmo.java.message.torrent.UploadAnswer value) {
      if (uploadAnswerBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUploadAnswerIsMutable();
        uploadAnswer_.set(index, value);
        onChanged();
      } else {
        uploadAnswerBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
     */
    public Builder setUploadAnswer(
        int index, ru.itmo.java.message.torrent.UploadAnswer.Builder builderForValue) {
      if (uploadAnswerBuilder_ == null) {
        ensureUploadAnswerIsMutable();
        uploadAnswer_.set(index, builderForValue.build());
        onChanged();
      } else {
        uploadAnswerBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
     */
    public Builder addUploadAnswer(ru.itmo.java.message.torrent.UploadAnswer value) {
      if (uploadAnswerBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUploadAnswerIsMutable();
        uploadAnswer_.add(value);
        onChanged();
      } else {
        uploadAnswerBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
     */
    public Builder addUploadAnswer(
        int index, ru.itmo.java.message.torrent.UploadAnswer value) {
      if (uploadAnswerBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUploadAnswerIsMutable();
        uploadAnswer_.add(index, value);
        onChanged();
      } else {
        uploadAnswerBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
     */
    public Builder addUploadAnswer(
        ru.itmo.java.message.torrent.UploadAnswer.Builder builderForValue) {
      if (uploadAnswerBuilder_ == null) {
        ensureUploadAnswerIsMutable();
        uploadAnswer_.add(builderForValue.build());
        onChanged();
      } else {
        uploadAnswerBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
     */
    public Builder addUploadAnswer(
        int index, ru.itmo.java.message.torrent.UploadAnswer.Builder builderForValue) {
      if (uploadAnswerBuilder_ == null) {
        ensureUploadAnswerIsMutable();
        uploadAnswer_.add(index, builderForValue.build());
        onChanged();
      } else {
        uploadAnswerBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
     */
    public Builder addAllUploadAnswer(
        java.lang.Iterable<? extends ru.itmo.java.message.torrent.UploadAnswer> values) {
      if (uploadAnswerBuilder_ == null) {
        ensureUploadAnswerIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, uploadAnswer_);
        onChanged();
      } else {
        uploadAnswerBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
     */
    public Builder clearUploadAnswer() {
      if (uploadAnswerBuilder_ == null) {
        uploadAnswer_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        uploadAnswerBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
     */
    public Builder removeUploadAnswer(int index) {
      if (uploadAnswerBuilder_ == null) {
        ensureUploadAnswerIsMutable();
        uploadAnswer_.remove(index);
        onChanged();
      } else {
        uploadAnswerBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
     */
    public ru.itmo.java.message.torrent.UploadAnswer.Builder getUploadAnswerBuilder(
        int index) {
      return getUploadAnswerFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
     */
    public ru.itmo.java.message.torrent.UploadAnswerOrBuilder getUploadAnswerOrBuilder(
        int index) {
      if (uploadAnswerBuilder_ == null) {
        return uploadAnswer_.get(index);  } else {
        return uploadAnswerBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
     */
    public java.util.List<? extends ru.itmo.java.message.torrent.UploadAnswerOrBuilder> 
         getUploadAnswerOrBuilderList() {
      if (uploadAnswerBuilder_ != null) {
        return uploadAnswerBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(uploadAnswer_);
      }
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
     */
    public ru.itmo.java.message.torrent.UploadAnswer.Builder addUploadAnswerBuilder() {
      return getUploadAnswerFieldBuilder().addBuilder(
          ru.itmo.java.message.torrent.UploadAnswer.getDefaultInstance());
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
     */
    public ru.itmo.java.message.torrent.UploadAnswer.Builder addUploadAnswerBuilder(
        int index) {
      return getUploadAnswerFieldBuilder().addBuilder(
          index, ru.itmo.java.message.torrent.UploadAnswer.getDefaultInstance());
    }
    /**
     * <code>repeated .ru.itmo.java.message.torrent.UploadAnswer uploadAnswer = 4;</code>
     */
    public java.util.List<ru.itmo.java.message.torrent.UploadAnswer.Builder> 
         getUploadAnswerBuilderList() {
      return getUploadAnswerFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        ru.itmo.java.message.torrent.UploadAnswer, ru.itmo.java.message.torrent.UploadAnswer.Builder, ru.itmo.java.message.torrent.UploadAnswerOrBuilder> 
        getUploadAnswerFieldBuilder() {
      if (uploadAnswerBuilder_ == null) {
        uploadAnswerBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            ru.itmo.java.message.torrent.UploadAnswer, ru.itmo.java.message.torrent.UploadAnswer.Builder, ru.itmo.java.message.torrent.UploadAnswerOrBuilder>(
                uploadAnswer_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        uploadAnswer_ = null;
      }
      return uploadAnswerBuilder_;
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


    // @@protoc_insertion_point(builder_scope:ru.itmo.java.message.torrent.UpdateRequest)
  }

  // @@protoc_insertion_point(class_scope:ru.itmo.java.message.torrent.UpdateRequest)
  private static final ru.itmo.java.message.torrent.UpdateRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ru.itmo.java.message.torrent.UpdateRequest();
  }

  public static ru.itmo.java.message.torrent.UpdateRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpdateRequest>
      PARSER = new com.google.protobuf.AbstractParser<UpdateRequest>() {
    @java.lang.Override
    public UpdateRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UpdateRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UpdateRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpdateRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ru.itmo.java.message.torrent.UpdateRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

