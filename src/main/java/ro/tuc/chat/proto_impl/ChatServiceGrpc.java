package ro.tuc.chat.proto_impl;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.0)",
    comments = "Source: chat.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ChatServiceGrpc {

  private ChatServiceGrpc() {}

  public static final String SERVICE_NAME = "ro.tuc.chat.proto_impl.ChatService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.ChatMessage,
      ro.tuc.chat.proto_impl.Status> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendMessage",
      requestType = ro.tuc.chat.proto_impl.ChatMessage.class,
      responseType = ro.tuc.chat.proto_impl.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.ChatMessage,
      ro.tuc.chat.proto_impl.Status> getSendMessageMethod() {
    io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.ChatMessage, ro.tuc.chat.proto_impl.Status> getSendMessageMethod;
    if ((getSendMessageMethod = ChatServiceGrpc.getSendMessageMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getSendMessageMethod = ChatServiceGrpc.getSendMessageMethod) == null) {
          ChatServiceGrpc.getSendMessageMethod = getSendMessageMethod =
              io.grpc.MethodDescriptor.<ro.tuc.chat.proto_impl.ChatMessage, ro.tuc.chat.proto_impl.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_impl.ChatMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_impl.Status.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("sendMessage"))
              .build();
        }
      }
    }
    return getSendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.Empty,
      ro.tuc.chat.proto_impl.ChatMessage> getReceiveMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "receiveMessage",
      requestType = ro.tuc.chat.proto_impl.Empty.class,
      responseType = ro.tuc.chat.proto_impl.ChatMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.Empty,
      ro.tuc.chat.proto_impl.ChatMessage> getReceiveMessageMethod() {
    io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.Empty, ro.tuc.chat.proto_impl.ChatMessage> getReceiveMessageMethod;
    if ((getReceiveMessageMethod = ChatServiceGrpc.getReceiveMessageMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getReceiveMessageMethod = ChatServiceGrpc.getReceiveMessageMethod) == null) {
          ChatServiceGrpc.getReceiveMessageMethod = getReceiveMessageMethod =
              io.grpc.MethodDescriptor.<ro.tuc.chat.proto_impl.Empty, ro.tuc.chat.proto_impl.ChatMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "receiveMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_impl.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_impl.ChatMessage.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("receiveMessage"))
              .build();
        }
      }
    }
    return getReceiveMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.Empty,
      ro.tuc.chat.proto_impl.OpenSessionRequest> getReceiveOpenSessionRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "receiveOpenSessionRequest",
      requestType = ro.tuc.chat.proto_impl.Empty.class,
      responseType = ro.tuc.chat.proto_impl.OpenSessionRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.Empty,
      ro.tuc.chat.proto_impl.OpenSessionRequest> getReceiveOpenSessionRequestMethod() {
    io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.Empty, ro.tuc.chat.proto_impl.OpenSessionRequest> getReceiveOpenSessionRequestMethod;
    if ((getReceiveOpenSessionRequestMethod = ChatServiceGrpc.getReceiveOpenSessionRequestMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getReceiveOpenSessionRequestMethod = ChatServiceGrpc.getReceiveOpenSessionRequestMethod) == null) {
          ChatServiceGrpc.getReceiveOpenSessionRequestMethod = getReceiveOpenSessionRequestMethod =
              io.grpc.MethodDescriptor.<ro.tuc.chat.proto_impl.Empty, ro.tuc.chat.proto_impl.OpenSessionRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "receiveOpenSessionRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_impl.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_impl.OpenSessionRequest.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("receiveOpenSessionRequest"))
              .build();
        }
      }
    }
    return getReceiveOpenSessionRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.OpenSessionRequestResponse,
      ro.tuc.chat.proto_impl.Status> getAcceptOpenSessionRequestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "acceptOpenSessionRequest",
      requestType = ro.tuc.chat.proto_impl.OpenSessionRequestResponse.class,
      responseType = ro.tuc.chat.proto_impl.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.OpenSessionRequestResponse,
      ro.tuc.chat.proto_impl.Status> getAcceptOpenSessionRequestMethod() {
    io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.OpenSessionRequestResponse, ro.tuc.chat.proto_impl.Status> getAcceptOpenSessionRequestMethod;
    if ((getAcceptOpenSessionRequestMethod = ChatServiceGrpc.getAcceptOpenSessionRequestMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getAcceptOpenSessionRequestMethod = ChatServiceGrpc.getAcceptOpenSessionRequestMethod) == null) {
          ChatServiceGrpc.getAcceptOpenSessionRequestMethod = getAcceptOpenSessionRequestMethod =
              io.grpc.MethodDescriptor.<ro.tuc.chat.proto_impl.OpenSessionRequestResponse, ro.tuc.chat.proto_impl.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "acceptOpenSessionRequest"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_impl.OpenSessionRequestResponse.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_impl.Status.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("acceptOpenSessionRequest"))
              .build();
        }
      }
    }
    return getAcceptOpenSessionRequestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.MessageReadingStatus,
      ro.tuc.chat.proto_impl.Status> getSendMessageReadingStatusUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendMessageReadingStatusUpdate",
      requestType = ro.tuc.chat.proto_impl.MessageReadingStatus.class,
      responseType = ro.tuc.chat.proto_impl.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.MessageReadingStatus,
      ro.tuc.chat.proto_impl.Status> getSendMessageReadingStatusUpdateMethod() {
    io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.MessageReadingStatus, ro.tuc.chat.proto_impl.Status> getSendMessageReadingStatusUpdateMethod;
    if ((getSendMessageReadingStatusUpdateMethod = ChatServiceGrpc.getSendMessageReadingStatusUpdateMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getSendMessageReadingStatusUpdateMethod = ChatServiceGrpc.getSendMessageReadingStatusUpdateMethod) == null) {
          ChatServiceGrpc.getSendMessageReadingStatusUpdateMethod = getSendMessageReadingStatusUpdateMethod =
              io.grpc.MethodDescriptor.<ro.tuc.chat.proto_impl.MessageReadingStatus, ro.tuc.chat.proto_impl.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendMessageReadingStatusUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_impl.MessageReadingStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_impl.Status.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("sendMessageReadingStatusUpdate"))
              .build();
        }
      }
    }
    return getSendMessageReadingStatusUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.Empty,
      ro.tuc.chat.proto_impl.MessageReadingStatus> getReceiveMessageReadingStatusUpdatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "receiveMessageReadingStatusUpdates",
      requestType = ro.tuc.chat.proto_impl.Empty.class,
      responseType = ro.tuc.chat.proto_impl.MessageReadingStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.Empty,
      ro.tuc.chat.proto_impl.MessageReadingStatus> getReceiveMessageReadingStatusUpdatesMethod() {
    io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.Empty, ro.tuc.chat.proto_impl.MessageReadingStatus> getReceiveMessageReadingStatusUpdatesMethod;
    if ((getReceiveMessageReadingStatusUpdatesMethod = ChatServiceGrpc.getReceiveMessageReadingStatusUpdatesMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getReceiveMessageReadingStatusUpdatesMethod = ChatServiceGrpc.getReceiveMessageReadingStatusUpdatesMethod) == null) {
          ChatServiceGrpc.getReceiveMessageReadingStatusUpdatesMethod = getReceiveMessageReadingStatusUpdatesMethod =
              io.grpc.MethodDescriptor.<ro.tuc.chat.proto_impl.Empty, ro.tuc.chat.proto_impl.MessageReadingStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "receiveMessageReadingStatusUpdates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_impl.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_impl.MessageReadingStatus.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("receiveMessageReadingStatusUpdates"))
              .build();
        }
      }
    }
    return getReceiveMessageReadingStatusUpdatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.MessageTypingStatus,
      ro.tuc.chat.proto_impl.Status> getSendMessageTypingStatusUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendMessageTypingStatusUpdate",
      requestType = ro.tuc.chat.proto_impl.MessageTypingStatus.class,
      responseType = ro.tuc.chat.proto_impl.Status.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.MessageTypingStatus,
      ro.tuc.chat.proto_impl.Status> getSendMessageTypingStatusUpdateMethod() {
    io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.MessageTypingStatus, ro.tuc.chat.proto_impl.Status> getSendMessageTypingStatusUpdateMethod;
    if ((getSendMessageTypingStatusUpdateMethod = ChatServiceGrpc.getSendMessageTypingStatusUpdateMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getSendMessageTypingStatusUpdateMethod = ChatServiceGrpc.getSendMessageTypingStatusUpdateMethod) == null) {
          ChatServiceGrpc.getSendMessageTypingStatusUpdateMethod = getSendMessageTypingStatusUpdateMethod =
              io.grpc.MethodDescriptor.<ro.tuc.chat.proto_impl.MessageTypingStatus, ro.tuc.chat.proto_impl.Status>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendMessageTypingStatusUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_impl.MessageTypingStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_impl.Status.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("sendMessageTypingStatusUpdate"))
              .build();
        }
      }
    }
    return getSendMessageTypingStatusUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.Empty,
      ro.tuc.chat.proto_impl.MessageTypingStatus> getReceiveMessageTypingStatusUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "receiveMessageTypingStatusUpdate",
      requestType = ro.tuc.chat.proto_impl.Empty.class,
      responseType = ro.tuc.chat.proto_impl.MessageTypingStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.Empty,
      ro.tuc.chat.proto_impl.MessageTypingStatus> getReceiveMessageTypingStatusUpdateMethod() {
    io.grpc.MethodDescriptor<ro.tuc.chat.proto_impl.Empty, ro.tuc.chat.proto_impl.MessageTypingStatus> getReceiveMessageTypingStatusUpdateMethod;
    if ((getReceiveMessageTypingStatusUpdateMethod = ChatServiceGrpc.getReceiveMessageTypingStatusUpdateMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getReceiveMessageTypingStatusUpdateMethod = ChatServiceGrpc.getReceiveMessageTypingStatusUpdateMethod) == null) {
          ChatServiceGrpc.getReceiveMessageTypingStatusUpdateMethod = getReceiveMessageTypingStatusUpdateMethod =
              io.grpc.MethodDescriptor.<ro.tuc.chat.proto_impl.Empty, ro.tuc.chat.proto_impl.MessageTypingStatus>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "receiveMessageTypingStatusUpdate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_impl.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ro.tuc.chat.proto_impl.MessageTypingStatus.getDefaultInstance()))
              .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("receiveMessageTypingStatusUpdate"))
              .build();
        }
      }
    }
    return getReceiveMessageTypingStatusUpdateMethod;
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
     */
    public void sendMessage(ro.tuc.chat.proto_impl.ChatMessage request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }

    /**
     */
    public void receiveMessage(ro.tuc.chat.proto_impl.Empty request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.ChatMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReceiveMessageMethod(), responseObserver);
    }

    /**
     */
    public void receiveOpenSessionRequest(ro.tuc.chat.proto_impl.Empty request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.OpenSessionRequest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReceiveOpenSessionRequestMethod(), responseObserver);
    }

    /**
     */
    public void acceptOpenSessionRequest(ro.tuc.chat.proto_impl.OpenSessionRequestResponse request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAcceptOpenSessionRequestMethod(), responseObserver);
    }

    /**
     */
    public void sendMessageReadingStatusUpdate(ro.tuc.chat.proto_impl.MessageReadingStatus request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMessageReadingStatusUpdateMethod(), responseObserver);
    }

    /**
     */
    public void receiveMessageReadingStatusUpdates(ro.tuc.chat.proto_impl.Empty request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.MessageReadingStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReceiveMessageReadingStatusUpdatesMethod(), responseObserver);
    }

    /**
     */
    public void sendMessageTypingStatusUpdate(ro.tuc.chat.proto_impl.MessageTypingStatus request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.Status> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMessageTypingStatusUpdateMethod(), responseObserver);
    }

    /**
     */
    public void receiveMessageTypingStatusUpdate(ro.tuc.chat.proto_impl.Empty request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.MessageTypingStatus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReceiveMessageTypingStatusUpdateMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMessageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ro.tuc.chat.proto_impl.ChatMessage,
                ro.tuc.chat.proto_impl.Status>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            getReceiveMessageMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                ro.tuc.chat.proto_impl.Empty,
                ro.tuc.chat.proto_impl.ChatMessage>(
                  this, METHODID_RECEIVE_MESSAGE)))
          .addMethod(
            getReceiveOpenSessionRequestMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                ro.tuc.chat.proto_impl.Empty,
                ro.tuc.chat.proto_impl.OpenSessionRequest>(
                  this, METHODID_RECEIVE_OPEN_SESSION_REQUEST)))
          .addMethod(
            getAcceptOpenSessionRequestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ro.tuc.chat.proto_impl.OpenSessionRequestResponse,
                ro.tuc.chat.proto_impl.Status>(
                  this, METHODID_ACCEPT_OPEN_SESSION_REQUEST)))
          .addMethod(
            getSendMessageReadingStatusUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ro.tuc.chat.proto_impl.MessageReadingStatus,
                ro.tuc.chat.proto_impl.Status>(
                  this, METHODID_SEND_MESSAGE_READING_STATUS_UPDATE)))
          .addMethod(
            getReceiveMessageReadingStatusUpdatesMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                ro.tuc.chat.proto_impl.Empty,
                ro.tuc.chat.proto_impl.MessageReadingStatus>(
                  this, METHODID_RECEIVE_MESSAGE_READING_STATUS_UPDATES)))
          .addMethod(
            getSendMessageTypingStatusUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ro.tuc.chat.proto_impl.MessageTypingStatus,
                ro.tuc.chat.proto_impl.Status>(
                  this, METHODID_SEND_MESSAGE_TYPING_STATUS_UPDATE)))
          .addMethod(
            getReceiveMessageTypingStatusUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                ro.tuc.chat.proto_impl.Empty,
                ro.tuc.chat.proto_impl.MessageTypingStatus>(
                  this, METHODID_RECEIVE_MESSAGE_TYPING_STATUS_UPDATE)))
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
     */
    public void sendMessage(ro.tuc.chat.proto_impl.ChatMessage request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void receiveMessage(ro.tuc.chat.proto_impl.Empty request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.ChatMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getReceiveMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void receiveOpenSessionRequest(ro.tuc.chat.proto_impl.Empty request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.OpenSessionRequest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getReceiveOpenSessionRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void acceptOpenSessionRequest(ro.tuc.chat.proto_impl.OpenSessionRequestResponse request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAcceptOpenSessionRequestMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMessageReadingStatusUpdate(ro.tuc.chat.proto_impl.MessageReadingStatus request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMessageReadingStatusUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void receiveMessageReadingStatusUpdates(ro.tuc.chat.proto_impl.Empty request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.MessageReadingStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getReceiveMessageReadingStatusUpdatesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMessageTypingStatusUpdate(ro.tuc.chat.proto_impl.MessageTypingStatus request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.Status> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMessageTypingStatusUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void receiveMessageTypingStatusUpdate(ro.tuc.chat.proto_impl.Empty request,
        io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.MessageTypingStatus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getReceiveMessageTypingStatusUpdateMethod(), getCallOptions()), request, responseObserver);
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
     */
    public ro.tuc.chat.proto_impl.Status sendMessage(ro.tuc.chat.proto_impl.ChatMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ro.tuc.chat.proto_impl.ChatMessage> receiveMessage(
        ro.tuc.chat.proto_impl.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getReceiveMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ro.tuc.chat.proto_impl.OpenSessionRequest> receiveOpenSessionRequest(
        ro.tuc.chat.proto_impl.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getReceiveOpenSessionRequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public ro.tuc.chat.proto_impl.Status acceptOpenSessionRequest(ro.tuc.chat.proto_impl.OpenSessionRequestResponse request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcceptOpenSessionRequestMethod(), getCallOptions(), request);
    }

    /**
     */
    public ro.tuc.chat.proto_impl.Status sendMessageReadingStatusUpdate(ro.tuc.chat.proto_impl.MessageReadingStatus request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMessageReadingStatusUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ro.tuc.chat.proto_impl.MessageReadingStatus> receiveMessageReadingStatusUpdates(
        ro.tuc.chat.proto_impl.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getReceiveMessageReadingStatusUpdatesMethod(), getCallOptions(), request);
    }

    /**
     */
    public ro.tuc.chat.proto_impl.Status sendMessageTypingStatusUpdate(ro.tuc.chat.proto_impl.MessageTypingStatus request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMessageTypingStatusUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ro.tuc.chat.proto_impl.MessageTypingStatus> receiveMessageTypingStatusUpdate(
        ro.tuc.chat.proto_impl.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getReceiveMessageTypingStatusUpdateMethod(), getCallOptions(), request);
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
     */
    public com.google.common.util.concurrent.ListenableFuture<ro.tuc.chat.proto_impl.Status> sendMessage(
        ro.tuc.chat.proto_impl.ChatMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ro.tuc.chat.proto_impl.Status> acceptOpenSessionRequest(
        ro.tuc.chat.proto_impl.OpenSessionRequestResponse request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAcceptOpenSessionRequestMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ro.tuc.chat.proto_impl.Status> sendMessageReadingStatusUpdate(
        ro.tuc.chat.proto_impl.MessageReadingStatus request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMessageReadingStatusUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ro.tuc.chat.proto_impl.Status> sendMessageTypingStatusUpdate(
        ro.tuc.chat.proto_impl.MessageTypingStatus request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMessageTypingStatusUpdateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_MESSAGE = 0;
  private static final int METHODID_RECEIVE_MESSAGE = 1;
  private static final int METHODID_RECEIVE_OPEN_SESSION_REQUEST = 2;
  private static final int METHODID_ACCEPT_OPEN_SESSION_REQUEST = 3;
  private static final int METHODID_SEND_MESSAGE_READING_STATUS_UPDATE = 4;
  private static final int METHODID_RECEIVE_MESSAGE_READING_STATUS_UPDATES = 5;
  private static final int METHODID_SEND_MESSAGE_TYPING_STATUS_UPDATE = 6;
  private static final int METHODID_RECEIVE_MESSAGE_TYPING_STATUS_UPDATE = 7;

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
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((ro.tuc.chat.proto_impl.ChatMessage) request,
              (io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.Status>) responseObserver);
          break;
        case METHODID_RECEIVE_MESSAGE:
          serviceImpl.receiveMessage((ro.tuc.chat.proto_impl.Empty) request,
              (io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.ChatMessage>) responseObserver);
          break;
        case METHODID_RECEIVE_OPEN_SESSION_REQUEST:
          serviceImpl.receiveOpenSessionRequest((ro.tuc.chat.proto_impl.Empty) request,
              (io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.OpenSessionRequest>) responseObserver);
          break;
        case METHODID_ACCEPT_OPEN_SESSION_REQUEST:
          serviceImpl.acceptOpenSessionRequest((ro.tuc.chat.proto_impl.OpenSessionRequestResponse) request,
              (io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.Status>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE_READING_STATUS_UPDATE:
          serviceImpl.sendMessageReadingStatusUpdate((ro.tuc.chat.proto_impl.MessageReadingStatus) request,
              (io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.Status>) responseObserver);
          break;
        case METHODID_RECEIVE_MESSAGE_READING_STATUS_UPDATES:
          serviceImpl.receiveMessageReadingStatusUpdates((ro.tuc.chat.proto_impl.Empty) request,
              (io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.MessageReadingStatus>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE_TYPING_STATUS_UPDATE:
          serviceImpl.sendMessageTypingStatusUpdate((ro.tuc.chat.proto_impl.MessageTypingStatus) request,
              (io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.Status>) responseObserver);
          break;
        case METHODID_RECEIVE_MESSAGE_TYPING_STATUS_UPDATE:
          serviceImpl.receiveMessageTypingStatusUpdate((ro.tuc.chat.proto_impl.Empty) request,
              (io.grpc.stub.StreamObserver<ro.tuc.chat.proto_impl.MessageTypingStatus>) responseObserver);
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
      return ro.tuc.chat.proto_impl.Chat.getDescriptor();
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
              .addMethod(getSendMessageMethod())
              .addMethod(getReceiveMessageMethod())
              .addMethod(getReceiveOpenSessionRequestMethod())
              .addMethod(getAcceptOpenSessionRequestMethod())
              .addMethod(getSendMessageReadingStatusUpdateMethod())
              .addMethod(getReceiveMessageReadingStatusUpdatesMethod())
              .addMethod(getSendMessageTypingStatusUpdateMethod())
              .addMethod(getReceiveMessageTypingStatusUpdateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
