package ro.tuc.chat.proto_gen;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.0)",
    comments = "Source: chat.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ChatServiceGrpc {

  private ChatServiceGrpc() {}

  public static final String SERVICE_NAME = "ro.tuc.chat.proto_gen.ChatService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.OpenSessionRequest,
      ro.tuc.chat.proto_gen.OpenSessionRequestResponse> getSendOpenSessionRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendOpenSessionRequest",
      requestType = ro.tuc.chat.proto_gen.OpenSessionRequest.class,
      responseType = ro.tuc.chat.proto_gen.OpenSessionRequestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.OpenSessionRequest,
      ro.tuc.chat.proto_gen.OpenSessionRequestResponse> getSendOpenSessionRequestMethod() {
    io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.OpenSessionRequest, ro.tuc.chat.proto_gen.OpenSessionRequestResponse> getSendOpenSessionRequestMethod;
    if ((getSendOpenSessionRequestMethod = ChatServiceGrpc.getSendOpenSessionRequestMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getSendOpenSessionRequestMethod = ChatServiceGrpc.getSendOpenSessionRequestMethod) == null) {
          ChatServiceGrpc.getSendOpenSessionRequestMethod = getSendOpenSessionRequestMethod =
              io.grpc.MethodDescriptor.<ro.tuc.chat.proto_gen.OpenSessionRequest, ro.tuc.chat.proto_gen.OpenSessionRequestResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendOpenSessionRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_gen.OpenSessionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_gen.OpenSessionRequestResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("sendOpenSessionRequest"))
              .build();
        }
      }
    }
    return getSendOpenSessionRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.Empty,
      ro.tuc.chat.proto_gen.OpenSessionRequest> getReceiveOpenSessionRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "receiveOpenSessionRequest",
      requestType = ro.tuc.chat.proto_gen.Empty.class,
      responseType = ro.tuc.chat.proto_gen.OpenSessionRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.Empty,
      ro.tuc.chat.proto_gen.OpenSessionRequest> getReceiveOpenSessionRequestMethod() {
    io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.Empty, ro.tuc.chat.proto_gen.OpenSessionRequest> getReceiveOpenSessionRequestMethod;
    if ((getReceiveOpenSessionRequestMethod = ChatServiceGrpc.getReceiveOpenSessionRequestMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getReceiveOpenSessionRequestMethod = ChatServiceGrpc.getReceiveOpenSessionRequestMethod) == null) {
          ChatServiceGrpc.getReceiveOpenSessionRequestMethod = getReceiveOpenSessionRequestMethod =
              io.grpc.MethodDescriptor.<ro.tuc.chat.proto_gen.Empty, ro.tuc.chat.proto_gen.OpenSessionRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "receiveOpenSessionRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_gen.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_gen.OpenSessionRequest.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("receiveOpenSessionRequest"))
              .build();
        }
      }
    }
    return getReceiveOpenSessionRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.OpenSessionRequestResponse,
      ro.tuc.chat.proto_gen.Status> getAcceptOpenSessionRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "acceptOpenSessionRequest",
      requestType = ro.tuc.chat.proto_gen.OpenSessionRequestResponse.class,
      responseType = ro.tuc.chat.proto_gen.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.OpenSessionRequestResponse,
      ro.tuc.chat.proto_gen.Status> getAcceptOpenSessionRequestMethod() {
    io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.OpenSessionRequestResponse, ro.tuc.chat.proto_gen.Status> getAcceptOpenSessionRequestMethod;
    if ((getAcceptOpenSessionRequestMethod = ChatServiceGrpc.getAcceptOpenSessionRequestMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getAcceptOpenSessionRequestMethod = ChatServiceGrpc.getAcceptOpenSessionRequestMethod) == null) {
          ChatServiceGrpc.getAcceptOpenSessionRequestMethod = getAcceptOpenSessionRequestMethod =
              io.grpc.MethodDescriptor.<ro.tuc.chat.proto_gen.OpenSessionRequestResponse, ro.tuc.chat.proto_gen.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "acceptOpenSessionRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_gen.OpenSessionRequestResponse.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_gen.Status.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("acceptOpenSessionRequest"))
              .build();
        }
      }
    }
    return getAcceptOpenSessionRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.ChatUpdateRequest,
      ro.tuc.chat.proto_gen.ChatUpdate> getReceiveChatUpdatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "receiveChatUpdates",
      requestType = ro.tuc.chat.proto_gen.ChatUpdateRequest.class,
      responseType = ro.tuc.chat.proto_gen.ChatUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.ChatUpdateRequest,
      ro.tuc.chat.proto_gen.ChatUpdate> getReceiveChatUpdatesMethod() {
    io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.ChatUpdateRequest, ro.tuc.chat.proto_gen.ChatUpdate> getReceiveChatUpdatesMethod;
    if ((getReceiveChatUpdatesMethod = ChatServiceGrpc.getReceiveChatUpdatesMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getReceiveChatUpdatesMethod = ChatServiceGrpc.getReceiveChatUpdatesMethod) == null) {
          ChatServiceGrpc.getReceiveChatUpdatesMethod = getReceiveChatUpdatesMethod =
              io.grpc.MethodDescriptor.<ro.tuc.chat.proto_gen.ChatUpdateRequest, ro.tuc.chat.proto_gen.ChatUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "receiveChatUpdates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_gen.ChatUpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_gen.ChatUpdate.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("receiveChatUpdates"))
              .build();
        }
      }
    }
    return getReceiveChatUpdatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.ChatMessage,
      ro.tuc.chat.proto_gen.SendMessageStatus> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendMessage",
      requestType = ro.tuc.chat.proto_gen.ChatMessage.class,
      responseType = ro.tuc.chat.proto_gen.SendMessageStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.ChatMessage,
      ro.tuc.chat.proto_gen.SendMessageStatus> getSendMessageMethod() {
    io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.ChatMessage, ro.tuc.chat.proto_gen.SendMessageStatus> getSendMessageMethod;
    if ((getSendMessageMethod = ChatServiceGrpc.getSendMessageMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getSendMessageMethod = ChatServiceGrpc.getSendMessageMethod) == null) {
          ChatServiceGrpc.getSendMessageMethod = getSendMessageMethod =
              io.grpc.MethodDescriptor.<ro.tuc.chat.proto_gen.ChatMessage, ro.tuc.chat.proto_gen.SendMessageStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_gen.ChatMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_gen.SendMessageStatus.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("sendMessage"))
              .build();
        }
      }
    }
    return getSendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.MessageReadingStatus,
      ro.tuc.chat.proto_gen.Status> getSendMessageReadingStatusUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendMessageReadingStatusUpdate",
      requestType = ro.tuc.chat.proto_gen.MessageReadingStatus.class,
      responseType = ro.tuc.chat.proto_gen.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.MessageReadingStatus,
      ro.tuc.chat.proto_gen.Status> getSendMessageReadingStatusUpdateMethod() {
    io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.MessageReadingStatus, ro.tuc.chat.proto_gen.Status> getSendMessageReadingStatusUpdateMethod;
    if ((getSendMessageReadingStatusUpdateMethod = ChatServiceGrpc.getSendMessageReadingStatusUpdateMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getSendMessageReadingStatusUpdateMethod = ChatServiceGrpc.getSendMessageReadingStatusUpdateMethod) == null) {
          ChatServiceGrpc.getSendMessageReadingStatusUpdateMethod = getSendMessageReadingStatusUpdateMethod =
              io.grpc.MethodDescriptor.<ro.tuc.chat.proto_gen.MessageReadingStatus, ro.tuc.chat.proto_gen.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendMessageReadingStatusUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_gen.MessageReadingStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_gen.Status.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("sendMessageReadingStatusUpdate"))
              .build();
        }
      }
    }
    return getSendMessageReadingStatusUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.MessageTypingStatus,
      ro.tuc.chat.proto_gen.Status> getSendMessageTypingStatusUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendMessageTypingStatusUpdate",
      requestType = ro.tuc.chat.proto_gen.MessageTypingStatus.class,
      responseType = ro.tuc.chat.proto_gen.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.MessageTypingStatus,
      ro.tuc.chat.proto_gen.Status> getSendMessageTypingStatusUpdateMethod() {
    io.grpc.MethodDescriptor<ro.tuc.chat.proto_gen.MessageTypingStatus, ro.tuc.chat.proto_gen.Status> getSendMessageTypingStatusUpdateMethod;
    if ((getSendMessageTypingStatusUpdateMethod = ChatServiceGrpc.getSendMessageTypingStatusUpdateMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getSendMessageTypingStatusUpdateMethod = ChatServiceGrpc.getSendMessageTypingStatusUpdateMethod) == null) {
          ChatServiceGrpc.getSendMessageTypingStatusUpdateMethod = getSendMessageTypingStatusUpdateMethod =
              io.grpc.MethodDescriptor.<ro.tuc.chat.proto_gen.MessageTypingStatus, ro.tuc.chat.proto_gen.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendMessageTypingStatusUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_gen.MessageTypingStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_gen.Status.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("sendMessageTypingStatusUpdate"))
              .build();
        }
      }
    }
    return getSendMessageTypingStatusUpdateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ChatServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatServiceStub>() {
        @java.lang.Override
        public ChatServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatServiceStub(channel, callOptions);
        }
      };
    return ChatServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatServiceBlockingStub>() {
        @java.lang.Override
        public ChatServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatServiceBlockingStub(channel, callOptions);
        }
      };
    return ChatServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ChatServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ChatServiceFutureStub>() {
        @java.lang.Override
        public ChatServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ChatServiceFutureStub(channel, callOptions);
        }
      };
    return ChatServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ChatServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * opening a session
     * </pre>
     */
    public void sendOpenSessionRequest(ro.tuc.chat.proto_gen.OpenSessionRequest request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.OpenSessionRequestResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendOpenSessionRequestMethod(), responseObserver);
    }

    /**
     */
    public void receiveOpenSessionRequest(ro.tuc.chat.proto_gen.Empty request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.OpenSessionRequest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReceiveOpenSessionRequestMethod(), responseObserver);
    }

    /**
     */
    public void acceptOpenSessionRequest(ro.tuc.chat.proto_gen.OpenSessionRequestResponse request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAcceptOpenSessionRequestMethod(), responseObserver);
    }

    /**
     * <pre>
     * receive messages, typing status updates and reading status updates - for the open chat sessions
     * </pre>
     */
    public void receiveChatUpdates(ro.tuc.chat.proto_gen.ChatUpdateRequest request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.ChatUpdate> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReceiveChatUpdatesMethod(), responseObserver);
    }

    /**
     * <pre>
     * message sending and receiving
     * </pre>
     */
    public void sendMessage(ro.tuc.chat.proto_gen.ChatMessage request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.SendMessageStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }

    /**
     * <pre>
     * marking messages that are read
     * </pre>
     */
    public void sendMessageReadingStatusUpdate(ro.tuc.chat.proto_gen.MessageReadingStatus request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMessageReadingStatusUpdateMethod(), responseObserver);
    }

    /**
     * <pre>
     * mark typing
     * </pre>
     */
    public void sendMessageTypingStatusUpdate(ro.tuc.chat.proto_gen.MessageTypingStatus request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMessageTypingStatusUpdateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendOpenSessionRequestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ro.tuc.chat.proto_gen.OpenSessionRequest,
                ro.tuc.chat.proto_gen.OpenSessionRequestResponse>(
                  this, METHODID_SEND_OPEN_SESSION_REQUEST)))
          .addMethod(
            getReceiveOpenSessionRequestMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                ro.tuc.chat.proto_gen.Empty,
                ro.tuc.chat.proto_gen.OpenSessionRequest>(
                  this, METHODID_RECEIVE_OPEN_SESSION_REQUEST)))
          .addMethod(
            getAcceptOpenSessionRequestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ro.tuc.chat.proto_gen.OpenSessionRequestResponse,
                ro.tuc.chat.proto_gen.Status>(
                  this, METHODID_ACCEPT_OPEN_SESSION_REQUEST)))
          .addMethod(
            getReceiveChatUpdatesMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                ro.tuc.chat.proto_gen.ChatUpdateRequest,
                ro.tuc.chat.proto_gen.ChatUpdate>(
                  this, METHODID_RECEIVE_CHAT_UPDATES)))
          .addMethod(
            getSendMessageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ro.tuc.chat.proto_gen.ChatMessage,
                ro.tuc.chat.proto_gen.SendMessageStatus>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            getSendMessageReadingStatusUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ro.tuc.chat.proto_gen.MessageReadingStatus,
                ro.tuc.chat.proto_gen.Status>(
                  this, METHODID_SEND_MESSAGE_READING_STATUS_UPDATE)))
          .addMethod(
            getSendMessageTypingStatusUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ro.tuc.chat.proto_gen.MessageTypingStatus,
                ro.tuc.chat.proto_gen.Status>(
                  this, METHODID_SEND_MESSAGE_TYPING_STATUS_UPDATE)))
          .build();
    }
  }

  /**
   */
  public static final class ChatServiceStub extends io.grpc.stub.AbstractAsyncStub<ChatServiceStub> {
    private ChatServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * opening a session
     * </pre>
     */
    public void sendOpenSessionRequest(ro.tuc.chat.proto_gen.OpenSessionRequest request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.OpenSessionRequestResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendOpenSessionRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void receiveOpenSessionRequest(ro.tuc.chat.proto_gen.Empty request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.OpenSessionRequest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getReceiveOpenSessionRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void acceptOpenSessionRequest(ro.tuc.chat.proto_gen.OpenSessionRequestResponse request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAcceptOpenSessionRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * receive messages, typing status updates and reading status updates - for the open chat sessions
     * </pre>
     */
    public void receiveChatUpdates(ro.tuc.chat.proto_gen.ChatUpdateRequest request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.ChatUpdate> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getReceiveChatUpdatesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * message sending and receiving
     * </pre>
     */
    public void sendMessage(ro.tuc.chat.proto_gen.ChatMessage request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.SendMessageStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * marking messages that are read
     * </pre>
     */
    public void sendMessageReadingStatusUpdate(ro.tuc.chat.proto_gen.MessageReadingStatus request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMessageReadingStatusUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * mark typing
     * </pre>
     */
    public void sendMessageTypingStatusUpdate(ro.tuc.chat.proto_gen.MessageTypingStatus request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMessageTypingStatusUpdateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ChatServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ChatServiceBlockingStub> {
    private ChatServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * opening a session
     * </pre>
     */
    public ro.tuc.chat.proto_gen.OpenSessionRequestResponse sendOpenSessionRequest(ro.tuc.chat.proto_gen.OpenSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendOpenSessionRequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ro.tuc.chat.proto_gen.OpenSessionRequest> receiveOpenSessionRequest(
        ro.tuc.chat.proto_gen.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getReceiveOpenSessionRequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public ro.tuc.chat.proto_gen.Status acceptOpenSessionRequest(ro.tuc.chat.proto_gen.OpenSessionRequestResponse request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcceptOpenSessionRequestMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * receive messages, typing status updates and reading status updates - for the open chat sessions
     * </pre>
     */
    public java.util.Iterator<ro.tuc.chat.proto_gen.ChatUpdate> receiveChatUpdates(
        ro.tuc.chat.proto_gen.ChatUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getReceiveChatUpdatesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * message sending and receiving
     * </pre>
     */
    public ro.tuc.chat.proto_gen.SendMessageStatus sendMessage(ro.tuc.chat.proto_gen.ChatMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * marking messages that are read
     * </pre>
     */
    public ro.tuc.chat.proto_gen.Status sendMessageReadingStatusUpdate(ro.tuc.chat.proto_gen.MessageReadingStatus request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMessageReadingStatusUpdateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * mark typing
     * </pre>
     */
    public ro.tuc.chat.proto_gen.Status sendMessageTypingStatusUpdate(ro.tuc.chat.proto_gen.MessageTypingStatus request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMessageTypingStatusUpdateMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ChatServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ChatServiceFutureStub> {
    private ChatServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * opening a session
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ro.tuc.chat.proto_gen.OpenSessionRequestResponse> sendOpenSessionRequest(
        ro.tuc.chat.proto_gen.OpenSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendOpenSessionRequestMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ro.tuc.chat.proto_gen.Status> acceptOpenSessionRequest(
        ro.tuc.chat.proto_gen.OpenSessionRequestResponse request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAcceptOpenSessionRequestMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * message sending and receiving
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ro.tuc.chat.proto_gen.SendMessageStatus> sendMessage(
        ro.tuc.chat.proto_gen.ChatMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * marking messages that are read
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ro.tuc.chat.proto_gen.Status> sendMessageReadingStatusUpdate(
        ro.tuc.chat.proto_gen.MessageReadingStatus request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMessageReadingStatusUpdateMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * mark typing
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ro.tuc.chat.proto_gen.Status> sendMessageTypingStatusUpdate(
        ro.tuc.chat.proto_gen.MessageTypingStatus request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMessageTypingStatusUpdateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_OPEN_SESSION_REQUEST = 0;
  private static final int METHODID_RECEIVE_OPEN_SESSION_REQUEST = 1;
  private static final int METHODID_ACCEPT_OPEN_SESSION_REQUEST = 2;
  private static final int METHODID_RECEIVE_CHAT_UPDATES = 3;
  private static final int METHODID_SEND_MESSAGE = 4;
  private static final int METHODID_SEND_MESSAGE_READING_STATUS_UPDATE = 5;
  private static final int METHODID_SEND_MESSAGE_TYPING_STATUS_UPDATE = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ChatServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ChatServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_OPEN_SESSION_REQUEST:
          serviceImpl.sendOpenSessionRequest((ro.tuc.chat.proto_gen.OpenSessionRequest) request,
              (io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.OpenSessionRequestResponse>) responseObserver);
          break;
        case METHODID_RECEIVE_OPEN_SESSION_REQUEST:
          serviceImpl.receiveOpenSessionRequest((ro.tuc.chat.proto_gen.Empty) request,
              (io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.OpenSessionRequest>) responseObserver);
          break;
        case METHODID_ACCEPT_OPEN_SESSION_REQUEST:
          serviceImpl.acceptOpenSessionRequest((ro.tuc.chat.proto_gen.OpenSessionRequestResponse) request,
              (io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.Status>) responseObserver);
          break;
        case METHODID_RECEIVE_CHAT_UPDATES:
          serviceImpl.receiveChatUpdates((ro.tuc.chat.proto_gen.ChatUpdateRequest) request,
              (io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.ChatUpdate>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((ro.tuc.chat.proto_gen.ChatMessage) request,
              (io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.SendMessageStatus>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE_READING_STATUS_UPDATE:
          serviceImpl.sendMessageReadingStatusUpdate((ro.tuc.chat.proto_gen.MessageReadingStatus) request,
              (io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.Status>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE_TYPING_STATUS_UPDATE:
          serviceImpl.sendMessageTypingStatusUpdate((ro.tuc.chat.proto_gen.MessageTypingStatus) request,
              (io.grpc.stub.StreamObserver<ro.tuc.chat.proto_gen.Status>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ro.tuc.chat.proto_gen.Chat.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChatService");
    }
  }

  private static final class ChatServiceFileDescriptorSupplier
      extends ChatServiceBaseDescriptorSupplier {
    ChatServiceFileDescriptorSupplier() {}
  }

  private static final class ChatServiceMethodDescriptorSupplier
      extends ChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ChatServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ChatServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ChatServiceFileDescriptorSupplier())
              .addMethod(getSendOpenSessionRequestMethod())
              .addMethod(getReceiveOpenSessionRequestMethod())
              .addMethod(getAcceptOpenSessionRequestMethod())
              .addMethod(getReceiveChatUpdatesMethod())
              .addMethod(getSendMessageMethod())
              .addMethod(getSendMessageReadingStatusUpdateMethod())
              .addMethod(getSendMessageTypingStatusUpdateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
