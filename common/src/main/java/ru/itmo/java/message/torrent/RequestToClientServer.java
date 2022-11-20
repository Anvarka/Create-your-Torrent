// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: torrent.proto

package ru.itmo.java.message.torrent;

/**
 * Protobuf type {@code ru.itmo.java.message.torrent.RequestToClientServer}
 */
public final class RequestToClientServer extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ru.itmo.java.message.torrent.RequestToClientServer)
    RequestToClientServerOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RequestToClientServer.newBuilder() to construct.
  private RequestToClientServer(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RequestToClientServer() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new RequestToClientServer();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RequestToClientServer(
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
            ru.itmo.java.message.torrent.StatRequest.Builder subBuilder = null;
            if (requestCase_ == 1) {
              subBuilder = ((ru.itmo.java.message.torrent.StatRequest) request_).toBuilder();
            }
            request_ =
                input.readMessage(ru.itmo.java.message.torrent.StatRequest.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((ru.itmo.java.message.torrent.StatRequest) request_);
              request_ = subBuilder.buildPartial();
            }
            requestCase_ = 1;
            break;
          }
          case 18: {
            ru.itmo.java.message.torrent.GetRequest.Builder subBuilder = null;
            if (requestCase_ == 2) {
              subBuilder = ((ru.itmo.java.message.torrent.GetRequest) request_).toBuilder();
            }
            request_ =
                input.readMessage(ru.itmo.java.message.torrent.GetRequest.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom((ru.itmo.java.message.torrent.GetRequest) request_);
              request_ = subBuilder.buildPartial();
            }
            requestCase_ = 2;
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
    return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_RequestToClientServer_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_RequestToClientServer_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ru.itmo.java.message.torrent.RequestToClientServer.class, ru.itmo.java.message.torrent.RequestToClientServer.Builder.class);
  }

  private int requestCase_ = 0;
  private java.lang.Object request_;
  public enum RequestCase
      implements com.google.protobuf.Internal.EnumLite,
          com.google.protobuf.AbstractMessage.InternalOneOfEnum {
    STATREQUEST(1),
    GETREQUEST(2),
    REQUEST_NOT_SET(0);
    private final int value;
    private RequestCase(int value) {
      this.value = value;
    }
    /**
     * @param value The number of the enum to look for.
     * @return The enum associated with the given number.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static RequestCase valueOf(int value) {
      return forNumber(value);
    }

    public static RequestCase forNumber(int value) {
      switch (value) {
        case 1: return STATREQUEST;
        case 2: return GETREQUEST;
        case 0: return REQUEST_NOT_SET;
        default: return null;
      }
    }
    public int getNumber() {
      return this.value;
    }
  };

  public RequestCase
  getRequestCase() {
    return RequestCase.forNumber(
        requestCase_);
  }

  public static final int STATREQUEST_FIELD_NUMBER = 1;
  /**
   * <code>.ru.itmo.java.message.torrent.StatRequest statRequest = 1;</code>
   * @return Whether the statRequest field is set.
   */
  @java.lang.Override
  public boolean hasStatRequest() {
    return requestCase_ == 1;
  }
  /**
   * <code>.ru.itmo.java.message.torrent.StatRequest statRequest = 1;</code>
   * @return The statRequest.
   */
  @java.lang.Override
  public ru.itmo.java.message.torrent.StatRequest getStatRequest() {
    if (requestCase_ == 1) {
       return (ru.itmo.java.message.torrent.StatRequest) request_;
    }
    return ru.itmo.java.message.torrent.StatRequest.getDefaultInstance();
  }
  /**
   * <code>.ru.itmo.java.message.torrent.StatRequest statRequest = 1;</code>
   */
  @java.lang.Override
  public ru.itmo.java.message.torrent.StatRequestOrBuilder getStatRequestOrBuilder() {
    if (requestCase_ == 1) {
       return (ru.itmo.java.message.torrent.StatRequest) request_;
    }
    return ru.itmo.java.message.torrent.StatRequest.getDefaultInstance();
  }

  public static final int GETREQUEST_FIELD_NUMBER = 2;
  /**
   * <code>.ru.itmo.java.message.torrent.GetRequest getRequest = 2;</code>
   * @return Whether the getRequest field is set.
   */
  @java.lang.Override
  public boolean hasGetRequest() {
    return requestCase_ == 2;
  }
  /**
   * <code>.ru.itmo.java.message.torrent.GetRequest getRequest = 2;</code>
   * @return The getRequest.
   */
  @java.lang.Override
  public ru.itmo.java.message.torrent.GetRequest getGetRequest() {
    if (requestCase_ == 2) {
       return (ru.itmo.java.message.torrent.GetRequest) request_;
    }
    return ru.itmo.java.message.torrent.GetRequest.getDefaultInstance();
  }
  /**
   * <code>.ru.itmo.java.message.torrent.GetRequest getRequest = 2;</code>
   */
  @java.lang.Override
  public ru.itmo.java.message.torrent.GetRequestOrBuilder getGetRequestOrBuilder() {
    if (requestCase_ == 2) {
       return (ru.itmo.java.message.torrent.GetRequest) request_;
    }
    return ru.itmo.java.message.torrent.GetRequest.getDefaultInstance();
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
    if (requestCase_ == 1) {
      output.writeMessage(1, (ru.itmo.java.message.torrent.StatRequest) request_);
    }
    if (requestCase_ == 2) {
      output.writeMessage(2, (ru.itmo.java.message.torrent.GetRequest) request_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (requestCase_ == 1) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, (ru.itmo.java.message.torrent.StatRequest) request_);
    }
    if (requestCase_ == 2) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, (ru.itmo.java.message.torrent.GetRequest) request_);
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
    if (!(obj instanceof ru.itmo.java.message.torrent.RequestToClientServer)) {
      return super.equals(obj);
    }
    ru.itmo.java.message.torrent.RequestToClientServer other = (ru.itmo.java.message.torrent.RequestToClientServer) obj;

    if (!getRequestCase().equals(other.getRequestCase())) return false;
    switch (requestCase_) {
      case 1:
        if (!getStatRequest()
            .equals(other.getStatRequest())) return false;
        break;
      case 2:
        if (!getGetRequest()
            .equals(other.getGetRequest())) return false;
        break;
      case 0:
      default:
    }
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
    switch (requestCase_) {
      case 1:
        hash = (37 * hash) + STATREQUEST_FIELD_NUMBER;
        hash = (53 * hash) + getStatRequest().hashCode();
        break;
      case 2:
        hash = (37 * hash) + GETREQUEST_FIELD_NUMBER;
        hash = (53 * hash) + getGetRequest().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ru.itmo.java.message.torrent.RequestToClientServer parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.torrent.RequestToClientServer parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.RequestToClientServer parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.torrent.RequestToClientServer parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.RequestToClientServer parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ru.itmo.java.message.torrent.RequestToClientServer parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.RequestToClientServer parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.torrent.RequestToClientServer parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.RequestToClientServer parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.torrent.RequestToClientServer parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ru.itmo.java.message.torrent.RequestToClientServer parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ru.itmo.java.message.torrent.RequestToClientServer parseFrom(
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
  public static Builder newBuilder(ru.itmo.java.message.torrent.RequestToClientServer prototype) {
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
   * Protobuf type {@code ru.itmo.java.message.torrent.RequestToClientServer}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ru.itmo.java.message.torrent.RequestToClientServer)
      ru.itmo.java.message.torrent.RequestToClientServerOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_RequestToClientServer_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_RequestToClientServer_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ru.itmo.java.message.torrent.RequestToClientServer.class, ru.itmo.java.message.torrent.RequestToClientServer.Builder.class);
    }

    // Construct using ru.itmo.java.message.torrent.RequestToClientServer.newBuilder()
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
      requestCase_ = 0;
      request_ = null;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ru.itmo.java.message.torrent.Torrent.internal_static_ru_itmo_java_message_torrent_RequestToClientServer_descriptor;
    }

    @java.lang.Override
    public ru.itmo.java.message.torrent.RequestToClientServer getDefaultInstanceForType() {
      return ru.itmo.java.message.torrent.RequestToClientServer.getDefaultInstance();
    }

    @java.lang.Override
    public ru.itmo.java.message.torrent.RequestToClientServer build() {
      ru.itmo.java.message.torrent.RequestToClientServer result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ru.itmo.java.message.torrent.RequestToClientServer buildPartial() {
      ru.itmo.java.message.torrent.RequestToClientServer result = new ru.itmo.java.message.torrent.RequestToClientServer(this);
      if (requestCase_ == 1) {
        if (statRequestBuilder_ == null) {
          result.request_ = request_;
        } else {
          result.request_ = statRequestBuilder_.build();
        }
      }
      if (requestCase_ == 2) {
        if (getRequestBuilder_ == null) {
          result.request_ = request_;
        } else {
          result.request_ = getRequestBuilder_.build();
        }
      }
      result.requestCase_ = requestCase_;
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
      if (other instanceof ru.itmo.java.message.torrent.RequestToClientServer) {
        return mergeFrom((ru.itmo.java.message.torrent.RequestToClientServer)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ru.itmo.java.message.torrent.RequestToClientServer other) {
      if (other == ru.itmo.java.message.torrent.RequestToClientServer.getDefaultInstance()) return this;
      switch (other.getRequestCase()) {
        case STATREQUEST: {
          mergeStatRequest(other.getStatRequest());
          break;
        }
        case GETREQUEST: {
          mergeGetRequest(other.getGetRequest());
          break;
        }
        case REQUEST_NOT_SET: {
          break;
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
      ru.itmo.java.message.torrent.RequestToClientServer parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ru.itmo.java.message.torrent.RequestToClientServer) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int requestCase_ = 0;
    private java.lang.Object request_;
    public RequestCase
        getRequestCase() {
      return RequestCase.forNumber(
          requestCase_);
    }

    public Builder clearRequest() {
      requestCase_ = 0;
      request_ = null;
      onChanged();
      return this;
    }


    private com.google.protobuf.SingleFieldBuilderV3<
        ru.itmo.java.message.torrent.StatRequest, ru.itmo.java.message.torrent.StatRequest.Builder, ru.itmo.java.message.torrent.StatRequestOrBuilder> statRequestBuilder_;
    /**
     * <code>.ru.itmo.java.message.torrent.StatRequest statRequest = 1;</code>
     * @return Whether the statRequest field is set.
     */
    @java.lang.Override
    public boolean hasStatRequest() {
      return requestCase_ == 1;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.StatRequest statRequest = 1;</code>
     * @return The statRequest.
     */
    @java.lang.Override
    public ru.itmo.java.message.torrent.StatRequest getStatRequest() {
      if (statRequestBuilder_ == null) {
        if (requestCase_ == 1) {
          return (ru.itmo.java.message.torrent.StatRequest) request_;
        }
        return ru.itmo.java.message.torrent.StatRequest.getDefaultInstance();
      } else {
        if (requestCase_ == 1) {
          return statRequestBuilder_.getMessage();
        }
        return ru.itmo.java.message.torrent.StatRequest.getDefaultInstance();
      }
    }
    /**
     * <code>.ru.itmo.java.message.torrent.StatRequest statRequest = 1;</code>
     */
    public Builder setStatRequest(ru.itmo.java.message.torrent.StatRequest value) {
      if (statRequestBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        request_ = value;
        onChanged();
      } else {
        statRequestBuilder_.setMessage(value);
      }
      requestCase_ = 1;
      return this;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.StatRequest statRequest = 1;</code>
     */
    public Builder setStatRequest(
        ru.itmo.java.message.torrent.StatRequest.Builder builderForValue) {
      if (statRequestBuilder_ == null) {
        request_ = builderForValue.build();
        onChanged();
      } else {
        statRequestBuilder_.setMessage(builderForValue.build());
      }
      requestCase_ = 1;
      return this;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.StatRequest statRequest = 1;</code>
     */
    public Builder mergeStatRequest(ru.itmo.java.message.torrent.StatRequest value) {
      if (statRequestBuilder_ == null) {
        if (requestCase_ == 1 &&
            request_ != ru.itmo.java.message.torrent.StatRequest.getDefaultInstance()) {
          request_ = ru.itmo.java.message.torrent.StatRequest.newBuilder((ru.itmo.java.message.torrent.StatRequest) request_)
              .mergeFrom(value).buildPartial();
        } else {
          request_ = value;
        }
        onChanged();
      } else {
        if (requestCase_ == 1) {
          statRequestBuilder_.mergeFrom(value);
        }
        statRequestBuilder_.setMessage(value);
      }
      requestCase_ = 1;
      return this;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.StatRequest statRequest = 1;</code>
     */
    public Builder clearStatRequest() {
      if (statRequestBuilder_ == null) {
        if (requestCase_ == 1) {
          requestCase_ = 0;
          request_ = null;
          onChanged();
        }
      } else {
        if (requestCase_ == 1) {
          requestCase_ = 0;
          request_ = null;
        }
        statRequestBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.StatRequest statRequest = 1;</code>
     */
    public ru.itmo.java.message.torrent.StatRequest.Builder getStatRequestBuilder() {
      return getStatRequestFieldBuilder().getBuilder();
    }
    /**
     * <code>.ru.itmo.java.message.torrent.StatRequest statRequest = 1;</code>
     */
    @java.lang.Override
    public ru.itmo.java.message.torrent.StatRequestOrBuilder getStatRequestOrBuilder() {
      if ((requestCase_ == 1) && (statRequestBuilder_ != null)) {
        return statRequestBuilder_.getMessageOrBuilder();
      } else {
        if (requestCase_ == 1) {
          return (ru.itmo.java.message.torrent.StatRequest) request_;
        }
        return ru.itmo.java.message.torrent.StatRequest.getDefaultInstance();
      }
    }
    /**
     * <code>.ru.itmo.java.message.torrent.StatRequest statRequest = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        ru.itmo.java.message.torrent.StatRequest, ru.itmo.java.message.torrent.StatRequest.Builder, ru.itmo.java.message.torrent.StatRequestOrBuilder> 
        getStatRequestFieldBuilder() {
      if (statRequestBuilder_ == null) {
        if (!(requestCase_ == 1)) {
          request_ = ru.itmo.java.message.torrent.StatRequest.getDefaultInstance();
        }
        statRequestBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            ru.itmo.java.message.torrent.StatRequest, ru.itmo.java.message.torrent.StatRequest.Builder, ru.itmo.java.message.torrent.StatRequestOrBuilder>(
                (ru.itmo.java.message.torrent.StatRequest) request_,
                getParentForChildren(),
                isClean());
        request_ = null;
      }
      requestCase_ = 1;
      onChanged();;
      return statRequestBuilder_;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
        ru.itmo.java.message.torrent.GetRequest, ru.itmo.java.message.torrent.GetRequest.Builder, ru.itmo.java.message.torrent.GetRequestOrBuilder> getRequestBuilder_;
    /**
     * <code>.ru.itmo.java.message.torrent.GetRequest getRequest = 2;</code>
     * @return Whether the getRequest field is set.
     */
    @java.lang.Override
    public boolean hasGetRequest() {
      return requestCase_ == 2;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.GetRequest getRequest = 2;</code>
     * @return The getRequest.
     */
    @java.lang.Override
    public ru.itmo.java.message.torrent.GetRequest getGetRequest() {
      if (getRequestBuilder_ == null) {
        if (requestCase_ == 2) {
          return (ru.itmo.java.message.torrent.GetRequest) request_;
        }
        return ru.itmo.java.message.torrent.GetRequest.getDefaultInstance();
      } else {
        if (requestCase_ == 2) {
          return getRequestBuilder_.getMessage();
        }
        return ru.itmo.java.message.torrent.GetRequest.getDefaultInstance();
      }
    }
    /**
     * <code>.ru.itmo.java.message.torrent.GetRequest getRequest = 2;</code>
     */
    public Builder setGetRequest(ru.itmo.java.message.torrent.GetRequest value) {
      if (getRequestBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        request_ = value;
        onChanged();
      } else {
        getRequestBuilder_.setMessage(value);
      }
      requestCase_ = 2;
      return this;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.GetRequest getRequest = 2;</code>
     */
    public Builder setGetRequest(
        ru.itmo.java.message.torrent.GetRequest.Builder builderForValue) {
      if (getRequestBuilder_ == null) {
        request_ = builderForValue.build();
        onChanged();
      } else {
        getRequestBuilder_.setMessage(builderForValue.build());
      }
      requestCase_ = 2;
      return this;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.GetRequest getRequest = 2;</code>
     */
    public Builder mergeGetRequest(ru.itmo.java.message.torrent.GetRequest value) {
      if (getRequestBuilder_ == null) {
        if (requestCase_ == 2 &&
            request_ != ru.itmo.java.message.torrent.GetRequest.getDefaultInstance()) {
          request_ = ru.itmo.java.message.torrent.GetRequest.newBuilder((ru.itmo.java.message.torrent.GetRequest) request_)
              .mergeFrom(value).buildPartial();
        } else {
          request_ = value;
        }
        onChanged();
      } else {
        if (requestCase_ == 2) {
          getRequestBuilder_.mergeFrom(value);
        }
        getRequestBuilder_.setMessage(value);
      }
      requestCase_ = 2;
      return this;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.GetRequest getRequest = 2;</code>
     */
    public Builder clearGetRequest() {
      if (getRequestBuilder_ == null) {
        if (requestCase_ == 2) {
          requestCase_ = 0;
          request_ = null;
          onChanged();
        }
      } else {
        if (requestCase_ == 2) {
          requestCase_ = 0;
          request_ = null;
        }
        getRequestBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>.ru.itmo.java.message.torrent.GetRequest getRequest = 2;</code>
     */
    public ru.itmo.java.message.torrent.GetRequest.Builder getGetRequestBuilder() {
      return getGetRequestFieldBuilder().getBuilder();
    }
    /**
     * <code>.ru.itmo.java.message.torrent.GetRequest getRequest = 2;</code>
     */
    @java.lang.Override
    public ru.itmo.java.message.torrent.GetRequestOrBuilder getGetRequestOrBuilder() {
      if ((requestCase_ == 2) && (getRequestBuilder_ != null)) {
        return getRequestBuilder_.getMessageOrBuilder();
      } else {
        if (requestCase_ == 2) {
          return (ru.itmo.java.message.torrent.GetRequest) request_;
        }
        return ru.itmo.java.message.torrent.GetRequest.getDefaultInstance();
      }
    }
    /**
     * <code>.ru.itmo.java.message.torrent.GetRequest getRequest = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        ru.itmo.java.message.torrent.GetRequest, ru.itmo.java.message.torrent.GetRequest.Builder, ru.itmo.java.message.torrent.GetRequestOrBuilder> 
        getGetRequestFieldBuilder() {
      if (getRequestBuilder_ == null) {
        if (!(requestCase_ == 2)) {
          request_ = ru.itmo.java.message.torrent.GetRequest.getDefaultInstance();
        }
        getRequestBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            ru.itmo.java.message.torrent.GetRequest, ru.itmo.java.message.torrent.GetRequest.Builder, ru.itmo.java.message.torrent.GetRequestOrBuilder>(
                (ru.itmo.java.message.torrent.GetRequest) request_,
                getParentForChildren(),
                isClean());
        request_ = null;
      }
      requestCase_ = 2;
      onChanged();;
      return getRequestBuilder_;
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


    // @@protoc_insertion_point(builder_scope:ru.itmo.java.message.torrent.RequestToClientServer)
  }

  // @@protoc_insertion_point(class_scope:ru.itmo.java.message.torrent.RequestToClientServer)
  private static final ru.itmo.java.message.torrent.RequestToClientServer DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ru.itmo.java.message.torrent.RequestToClientServer();
  }

  public static ru.itmo.java.message.torrent.RequestToClientServer getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RequestToClientServer>
      PARSER = new com.google.protobuf.AbstractParser<RequestToClientServer>() {
    @java.lang.Override
    public RequestToClientServer parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RequestToClientServer(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RequestToClientServer> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RequestToClientServer> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ru.itmo.java.message.torrent.RequestToClientServer getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

