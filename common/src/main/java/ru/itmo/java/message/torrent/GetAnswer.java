// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: torrent.proto

package ru.itmo.java.message.torrent;

/**
 * Protobuf type {@code ru.itmo.java.message.torrent.GetAnswer}
 */
public final class GetAnswer extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ru.itmo.java.message.torrent.GetAnswer)
    GetAnswerOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetAnswer.newBuilder() to construct.
  private GetAnswer(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetAnswer() {
    content_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetAnswer();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetAnswer(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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

            content_ = input.readBytes();
            break;
          }
          case 18: {
            ru.itmo.java.message.torrent.FileContent.Builder subBuilder = null;
            if (fileContent_ != null) {
              subBuilder = fileContent_.toBuilder();
            }
            fileContent_ = input.readMessage(ru.itmo.java.message.torrent.FileContent.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(fileContent_);
              fileContent_ = subBuilder.buildPartial();
            }

            break;
          }
          case 24: {

            partOfFile_ = input.readInt64();
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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_GetAnswer_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_GetAnswer_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ru.itmo.java.message.torrent.GetAnswer.class, ru.itmo.java.message.torrent.GetAnswer.Builder.class);
  }

  public static final int CONTENT_FIELD_NUMBER = 1;
  private com.google.protobuf.ByteString content_;
  /**
   * <code>bytes content = 1;</code>
   * @return The content.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getContent() {
    return content_;
  }

  public static final int FILECONTENT_FIELD_NUMBER = 2;
  private ru.itmo.java.message.torrent.FileContent fileContent_;
  /**
   * <code>.ru.itmo.java.message.torrent.FileContent fileContent = 2;</code>
   * @return Whether the fileContent field is set.
   */
  @java.lang.Override
  public boolean hasFileContent() {
    return fileContent_ != null;
  }
  /**
   * <code>.ru.itmo.java.message.torrent.FileContent fileContent = 2;</code>
   * @return The fileContent.
   */
  @java.lang.Override
  public ru.itmo.java.message.torrent.FileContent getFileContent() {
    return fileContent_ == null ? ru.itmo.java.message.torrent.FileContent.getDefaultInstance() : fileContent_;
  }
  /**
   * <code>.ru.itmo.java.message.torrent.FileContent fileContent = 2;</code>
   */
  @java.lang.Override
  public ru.itmo.java.message.torrent.FileContentOrBuilder getFileContentOrBuilder() {
    return getFileContent();
  }

  public static final int PARTOFFILE_FIELD_NUMBER = 3;
  private long partOfFile_;
  /**
   * <code>int64 partOfFile = 3;</code>
   * @return The partOfFile.
   */
  @java.lang.Override
  public long getPartOfFile() {
    return partOfFile_;
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
    if (!content_.isEmpty()) {
      output.writeBytes(1, content_);
    }
    if (fileContent_ != null) {
      output.writeMessage(2, getFileContent());
    }
    if (partOfFile_ != 0L) {
      output.writeInt64(3, partOfFile_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!content_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(1, content_);
    }
    if (fileContent_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getFileContent());
    }
    if (partOfFile_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(3, partOfFile_);
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
    if (!(obj instanceof ru.itmo.java.message.torrent.GetAnswer)) {
      return super.equals(obj);
    }
    ru.itmo.java.message.torrent.GetAnswer other = (ru.itmo.java.message.torrent.GetAnswer) obj;

    if (!getContent()
        .equals(other.getContent())) return false;
    if (hasFileContent() != other.hasFileContent()) return false;
    if (hasFileContent()) {
      if (!getFileContent()
          .equals(other.getFileContent())) return false;
    }
    if (getPartOfFile()
        != other.getPartOfFile()) return false;
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
    hash = (37 * hash) + CONTENT_FIELD_NUMBER;
    hash = (53 * hash) + getContent().hashCode();
    if (hasFileContent()) {
      hash = (37 * hash) + FILECONTENT_FIELD_NUMBER;
      hash = (53 * hash) + getFileContent().hashCode();
    }
    hash = (37 * hash) + PARTOFFILE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getPartOfFile());
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ru.itmo.java.message.torrent.GetAnswer parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.torrent.GetAnswer parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.GetAnswer parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.torrent.GetAnswer parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.GetAnswer parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.torrent.GetAnswer parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.GetAnswer parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.torrent.GetAnswer parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.GetAnswer parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.torrent.GetAnswer parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.GetAnswer parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.torrent.GetAnswer parseFrom(
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
  public static Builder newBuilder(ru.itmo.java.message.torrent.GetAnswer prototype) {
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
   * Protobuf type {@code ru.itmo.java.message.torrent.GetAnswer}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ru.itmo.java.message.torrent.GetAnswer)
      ru.itmo.java.message.torrent.GetAnswerOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_GetAnswer_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_GetAnswer_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ru.itmo.java.message.torrent.GetAnswer.class, ru.itmo.java.message.torrent.GetAnswer.Builder.class);
    }

    // Construct using ru.itmo.java.message.torrent.GetAnswer.newBuilder()
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
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      content_ = com.google.protobuf.ByteString.EMPTY;

      if (fileContentBuilder_ == null) {
        fileContent_ = null;
      } else {
        fileContent_ = null;
        fileContentBuilder_ = null;
      }
      partOfFile_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_GetAnswer_descriptor;
    }

    @java.lang.Override
    public ru.itmo.java.message.torrent.GetAnswer getDefaultInstanceForType() {
      return ru.itmo.java.message.torrent.GetAnswer.getDefaultInstance();
    }

    @java.lang.Override
    public ru.itmo.java.message.torrent.GetAnswer build() {
      ru.itmo.java.message.torrent.GetAnswer result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ru.itmo.java.message.torrent.GetAnswer buildPartial() {
      ru.itmo.java.message.torrent.GetAnswer result = new ru.itmo.java.message.torrent.GetAnswer(this);
      result.content_ = content_;
      if (fileContentBuilder_ == null) {
        result.fileContent_ = fileContent_;
      } else {
        result.fileContent_ = fileContentBuilder_.build();
      }
      result.partOfFile_ = partOfFile_;
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
      if (other instanceof ru.itmo.java.message.torrent.GetAnswer) {
        return mergeFrom((ru.itmo.java.message.torrent.GetAnswer)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ru.itmo.java.message.torrent.GetAnswer other) {
      if (other == ru.itmo.java.message.torrent.GetAnswer.getDefaultInstance()) return this;
      if (other.getContent() != com.google.protobuf.ByteString.EMPTY) {
        setContent(other.getContent());
      }
      if (other.hasFileContent()) {
        mergeFileContent(other.getFileContent());
      }
      if (other.getPartOfFile() != 0L) {
        setPartOfFile(other.getPartOfFile());
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
      ru.itmo.java.message.torrent.GetAnswer parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ru.itmo.java.message.torrent.GetAnswer) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.google.protobuf.ByteString content_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <code>bytes content = 1;</code>
     * @return The content.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getContent() {
      return content_;
    }
    /**
     * <code>bytes content = 1;</code>
     * @param value The content to set.
     * @return This builder for chaining.
     */
    public Builder setContent(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      content_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bytes content = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearContent() {
      
      content_ = getDefaultInstance().getContent();
      onChanged();
      return this;
    }

    private ru.itmo.java.message.torrent.FileContent fileContent_;
    private com.google.protobuf.SingleFieldBuilderV3<
        ru.itmo.java.message.torrent.FileContent, ru.itmo.java.message.torrent.FileContent.Builder, ru.itmo.java.message.torrent.FileContentOrBuilder> fileContentBuilder_;
    /**
     * <code>.ru.itmo.java.message.torrent.FileContent fileContent = 2;</code>
     * @return Whether the fileContent field is set.
     */
    public boolean hasFileContent() {
      return fileContentBuilder_ != null || fileContent_ != null;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.FileContent fileContent = 2;</code>
     * @return The fileContent.
     */
    public ru.itmo.java.message.torrent.FileContent getFileContent() {
      if (fileContentBuilder_ == null) {
        return fileContent_ == null ? ru.itmo.java.message.torrent.FileContent.getDefaultInstance() : fileContent_;
      } else {
        return fileContentBuilder_.getMessage();
      }
    }
    /**
     * <code>.ru.itmo.java.message.torrent.FileContent fileContent = 2;</code>
     */
    public Builder setFileContent(ru.itmo.java.message.torrent.FileContent value) {
      if (fileContentBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        fileContent_ = value;
        onChanged();
      } else {
        fileContentBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.FileContent fileContent = 2;</code>
     */
    public Builder setFileContent(
        ru.itmo.java.message.torrent.FileContent.Builder builderForValue) {
      if (fileContentBuilder_ == null) {
        fileContent_ = builderForValue.build();
        onChanged();
      } else {
        fileContentBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.FileContent fileContent = 2;</code>
     */
    public Builder mergeFileContent(ru.itmo.java.message.torrent.FileContent value) {
      if (fileContentBuilder_ == null) {
        if (fileContent_ != null) {
          fileContent_ =
            ru.itmo.java.message.torrent.FileContent.newBuilder(fileContent_).mergeFrom(value).buildPartial();
        } else {
          fileContent_ = value;
        }
        onChanged();
      } else {
        fileContentBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.FileContent fileContent = 2;</code>
     */
    public Builder clearFileContent() {
      if (fileContentBuilder_ == null) {
        fileContent_ = null;
        onChanged();
      } else {
        fileContent_ = null;
        fileContentBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.FileContent fileContent = 2;</code>
     */
    public ru.itmo.java.message.torrent.FileContent.Builder getFileContentBuilder() {
      
      onChanged();
      return getFileContentFieldBuilder().getBuilder();
    }
    /**
     * <code>.ru.itmo.java.message.torrent.FileContent fileContent = 2;</code>
     */
    public ru.itmo.java.message.torrent.FileContentOrBuilder getFileContentOrBuilder() {
      if (fileContentBuilder_ != null) {
        return fileContentBuilder_.getMessageOrBuilder();
      } else {
        return fileContent_ == null ?
            ru.itmo.java.message.torrent.FileContent.getDefaultInstance() : fileContent_;
      }
    }
    /**
     * <code>.ru.itmo.java.message.torrent.FileContent fileContent = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        ru.itmo.java.message.torrent.FileContent, ru.itmo.java.message.torrent.FileContent.Builder, ru.itmo.java.message.torrent.FileContentOrBuilder> 
        getFileContentFieldBuilder() {
      if (fileContentBuilder_ == null) {
        fileContentBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            ru.itmo.java.message.torrent.FileContent, ru.itmo.java.message.torrent.FileContent.Builder, ru.itmo.java.message.torrent.FileContentOrBuilder>(
                getFileContent(),
                getParentForChildren(),
                isClean());
        fileContent_ = null;
      }
      return fileContentBuilder_;
    }

    private long partOfFile_ ;
    /**
     * <code>int64 partOfFile = 3;</code>
     * @return The partOfFile.
     */
    @java.lang.Override
    public long getPartOfFile() {
      return partOfFile_;
    }
    /**
     * <code>int64 partOfFile = 3;</code>
     * @param value The partOfFile to set.
     * @return This builder for chaining.
     */
    public Builder setPartOfFile(long value) {
      
      partOfFile_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 partOfFile = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearPartOfFile() {
      
      partOfFile_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:ru.itmo.java.message.torrent.GetAnswer)
  }

  // @@protoc_insertion_point(class_scope:ru.itmo.java.message.torrent.GetAnswer)
  private static final ru.itmo.java.message.torrent.GetAnswer DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ru.itmo.java.message.torrent.GetAnswer();
  }

  public static ru.itmo.java.message.torrent.GetAnswer getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetAnswer>
      PARSER = new com.google.protobuf.AbstractParser<GetAnswer>() {
    @java.lang.Override
    public GetAnswer parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetAnswer(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetAnswer> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetAnswer> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ru.itmo.java.message.torrent.GetAnswer getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

