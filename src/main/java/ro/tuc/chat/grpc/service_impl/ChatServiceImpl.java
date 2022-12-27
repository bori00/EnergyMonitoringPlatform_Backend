package ro.tuc.chat.grpc.service_impl;

import io.grpc.stub.StreamObserver;
import ro.tuc.chat.proto_gen.*;

public class ChatServiceImpl extends ChatServiceGrpc.ChatServiceImplBase {

    @Override
    public void sendMessage(ChatMessage request, StreamObserver<Status> responseObserver) {
        super.sendMessage(request, responseObserver);
    }

    @Override
    public void receiveMessage(Empty request, StreamObserver<ChatMessage> responseObserver) {
        super.receiveMessage(request, responseObserver);
    }

    @Override
    public void receiveOpenSessionRequest(Empty request, StreamObserver<OpenSessionRequest> responseObserver) {
        super.receiveOpenSessionRequest(request, responseObserver);
    }

    @Override
    public void acceptOpenSessionRequest(OpenSessionRequestResponse request, StreamObserver<Status> responseObserver) {
        super.acceptOpenSessionRequest(request, responseObserver);
    }

    @Override
    public void sendMessageReadingStatusUpdate(MessageReadingStatus request, StreamObserver<Status> responseObserver) {
        super.sendMessageReadingStatusUpdate(request, responseObserver);
    }

    @Override
    public void receiveMessageReadingStatusUpdates(Empty request, StreamObserver<MessageReadingStatus> responseObserver) {
        super.receiveMessageReadingStatusUpdates(request, responseObserver);
    }

    @Override
    public void sendMessageTypingStatusUpdate(MessageTypingStatus request, StreamObserver<Status> responseObserver) {
        super.sendMessageTypingStatusUpdate(request, responseObserver);
    }

    @Override
    public void receiveMessageTypingStatusUpdate(Empty request, StreamObserver<MessageTypingStatus> responseObserver) {
        super.receiveMessageTypingStatusUpdate(request, responseObserver);
    }
}
