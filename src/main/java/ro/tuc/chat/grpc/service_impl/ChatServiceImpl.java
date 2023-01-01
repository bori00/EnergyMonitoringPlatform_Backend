package ro.tuc.chat.grpc.service_impl;

import io.grpc.stub.StreamObserver;
import lombok.Synchronized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.tuc.chat.proto_gen.*;
import ro.tuc.webapp.controllers.AuthenticationController;
import net.devh.boot.grpc.server.service.GrpcService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@GrpcService
public class ChatServiceImpl extends ChatServiceGrpc.ChatServiceImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatServiceImpl.class);

    private static final Map<String, ClientObserver> clientObservers = new HashMap<>();

    private static final AdminObserver adminObserver = new AdminObserver();

    private static final List<OpenSessionRequest> unhandledOpenSessionRequests = new ArrayList<>();

    private static final Map<UpdateRequest, ChatReaderObserver> chatReaderObservers =
            new HashMap<>();

//    Lock chatReaderObserversLock = new ReentrantLock();

    public void notifyAboutClosure(String recipientName, String senderName) {
        UpdateRequest partnerRequest =
                UpdateRequest.newBuilder()
                        .setRequestSenderName(senderName)
                        .setPartnerName(recipientName)
                        .build();

        if (chatReaderObservers.containsKey(partnerRequest)) {
            chatReaderObservers.get(partnerRequest).closeObservers();
        }
    }

    private void printChatReaderObservers() {
        StringBuilder status = new StringBuilder("Available Readers: ");
        for (UpdateRequest request : chatReaderObservers.keySet()) {
            status.append("Available Reader: ").append(chatReaderObservers.get(request)).append("\n");
        }
        LOGGER.info(status.toString());
    }

    @Override
    public void sendMessage(ChatMessage request, StreamObserver<SendMessageStatus> responseObserver) {
        LOGGER.info("Server received NEW MESSAGE: " + request);
        UpdateRequest recipientRequest =
                UpdateRequest.newBuilder()
                        .setRequestSenderName(request.getToUserName())
                        .setPartnerName(request.getFromUserName())
                        .build();
        if (chatReaderObservers.containsKey(recipientRequest) &&
            chatReaderObservers.get(recipientRequest).getIncomingMessageStreamObserver() != null) {
            ChatMessage newMessage =
                    ChatMessage.newBuilder()
                            .setFromUserName(request.getFromUserName())
                            .setToUserName(request.getToUserName())
                            .setMessage(request.getMessage())
                            .setTimeStamp(LocalDateTime.now().toString())
                            .build();
            chatReaderObservers.get(recipientRequest).getIncomingMessageStreamObserver().onNext(newMessage);

            responseObserver.onNext(SendMessageStatus.newBuilder().setSentMessage(newMessage).build());
            responseObserver.onCompleted();
            LOGGER.info("Server forwarded NEW MESSAGE: " + request);
        } else {
            LOGGER.info("Server couldn't forward NEW MESSAGE: " + request);
            Status status =
                    Status.newBuilder()
                            .setSuccessful(false)
                            .setErrorMessage("The recipient is not available anymore.")
                            .build();
            responseObserver.onNext(SendMessageStatus.newBuilder().setStatus(status).build());
            responseObserver.onCompleted();
        }
        printChatReaderObservers();
    }

    @Override
    public void receiveMessage(UpdateRequest request, StreamObserver<ChatMessage> responseObserver) {
        if (chatReaderObservers.containsKey(request)) {
            chatReaderObservers.get(request).setIncomingMessageStreamObserver(responseObserver);
        } else {
            LOGGER.info("Added new ChatReaderObserver for key: " + request);
            ChatReaderObserver observer = new ChatReaderObserver();
            observer.setIncomingMessageStreamObserver(responseObserver);
            observer.setOnClosureCallback(this::notifyAboutClosure);
            observer.setReaderUserName(request.getRequestSenderName());
            observer.setSenderUserName(request.getPartnerName());
            chatReaderObservers.put(request, observer);
        }
        printChatReaderObservers();
    }

    @Override
    public void sendOpenSessionRequest(OpenSessionRequest request, StreamObserver<OpenSessionRequestResponse> responseObserver) {
        LOGGER.info("Server received Send OpenSessionRequest: " + request.toString());

        String fromUserName = request.getFromUserName();

        // save client observer
        if (clientObservers.containsKey(fromUserName)) {
            clientObservers.get(fromUserName).setOpenSessionRequestResponseStreamObserver(responseObserver);
        } else {
            ClientObserver observer = new ClientObserver();
            observer.setUserName(fromUserName);
            observer.setOpenSessionRequestResponseStreamObserver(responseObserver);
            clientObservers.put(fromUserName, observer);
        }

        // send notification to admin, if available. Otherwise, save request for later, when an
        // admin joins
        if (adminObserver.getOpenSessionRequestStreamObserver() != null) {
            adminObserver.getOpenSessionRequestStreamObserver().onNext(request);

            LOGGER.info("Server responded to Send OpenSessionRequest: " + request.toString());
        } else {
            unhandledOpenSessionRequests.add(request);
        }
        printChatReaderObservers();
    }


    @Override
    public void receiveOpenSessionRequest(Empty request, StreamObserver<OpenSessionRequest> responseObserver) {
        LOGGER.info("Server received Receive OpenSessionRequest");
        adminObserver.setOpenSessionRequestStreamObserver(responseObserver);

        // handle previous requests
        while (!unhandledOpenSessionRequests.isEmpty()) {
            adminObserver.getOpenSessionRequestStreamObserver().onNext(unhandledOpenSessionRequests.remove(0));
        }
        printChatReaderObservers();
    }

    @Override
    public void acceptOpenSessionRequest(OpenSessionRequestResponse request, StreamObserver<Status> responseObserver) {
        LOGGER.info("Server received Accept OpenSessionRequest: " + request.toString());

        String requestSenderUserName = request.getFromUserName();

        if (clientObservers.containsKey(requestSenderUserName) &&
            clientObservers.get(requestSenderUserName).getOpenSessionRequestResponseStreamObserver() != null) {
            OpenSessionRequestResponse response = OpenSessionRequestResponse.newBuilder()
                    .setAccepted(true)
                    .setFromUserName(requestSenderUserName)
                    .build();

            clientObservers.get(requestSenderUserName).sendOpenSessionRequestResponse(response);

            LOGGER.info("Server responded to Accept OpenSessionRequest: " + request.toString());

            Status status = Status.newBuilder().setSuccessful(true).build();
            responseObserver.onNext(status);
            responseObserver.onCompleted();
        } else {
            Status status =
                    Status.newBuilder()
                            .setSuccessful(false)
                            .setErrorMessage("The client is not available anymore.")
                            .build();
            responseObserver.onNext(status);
            responseObserver.onCompleted();
        }
        printChatReaderObservers();
    }

    @Override
    public void sendMessageReadingStatusUpdate(MessageReadingStatus request, StreamObserver<Status> responseObserver) {
        UpdateRequest recipientRequest =
                UpdateRequest.newBuilder()
                        .setRequestSenderName(request.getSenderUserName())
                        .setPartnerName(request.getReaderUserName())
                        .build();

        LOGGER.info("Server received ReadingStatusUpdate " + request);

        if (chatReaderObservers.containsKey(recipientRequest) &&
                chatReaderObservers.get(recipientRequest).getMessageReadingStatusStreamObserver() != null) {
            chatReaderObservers.get(recipientRequest).getMessageReadingStatusStreamObserver().onNext(request);

            responseObserver.onNext(Status.newBuilder().setSuccessful(true).build());
            responseObserver.onCompleted();
        } else {
            Status status =
                    Status.newBuilder()
                            .setSuccessful(false)
                            .setErrorMessage("The recipient is not available anymore.")
                            .build();
            responseObserver.onNext(status);
            responseObserver.onCompleted();
        }
        printChatReaderObservers();
    }

    @Override
    public void receiveMessageReadingStatusUpdates(UpdateRequest request,
                                                   StreamObserver<MessageReadingStatus> responseObserver) {
//        chatReaderObserversLock.lock();
        if (chatReaderObservers.containsKey(request)) {
            chatReaderObservers.get(request).setMessageReadingStatusStreamObserver(responseObserver);
        } else {
            LOGGER.info("Added new ChatReaderObserver for key: " + request);
            ChatReaderObserver observer = new ChatReaderObserver();
            observer.setMessageReadingStatusStreamObserver(responseObserver);
            observer.setOnClosureCallback(this::notifyAboutClosure);
            observer.setReaderUserName(request.getRequestSenderName());
            observer.setSenderUserName(request.getPartnerName());
            chatReaderObservers.put(request, observer);
        }
//        chatReaderObserversLock.unlock();
//        printChatReaderObservers();
    }

    @Override
    public void sendMessageTypingStatusUpdate(MessageTypingStatus request, StreamObserver<Status> responseObserver) {
        UpdateRequest recipientRequest =
                UpdateRequest.newBuilder()
                        .setRequestSenderName(request.getRecipientUserName())
                        .setPartnerName(request.getTyperUserName())
                        .build();

        LOGGER.info("Server received TypingStatusUpdate " + request);

        if (chatReaderObservers.containsKey(recipientRequest) &&
                chatReaderObservers.get(recipientRequest).getMessageTypingStatusStreamObserver() != null) {
            chatReaderObservers.get(recipientRequest).getMessageTypingStatusStreamObserver().onNext(request);

            responseObserver.onNext(Status.newBuilder().setSuccessful(true).build());
            responseObserver.onCompleted();
        } else {
            Status status =
                    Status.newBuilder()
                            .setSuccessful(false)
                            .setErrorMessage("The recipient is not available anymore.")
                            .build();
            responseObserver.onNext(status);
            responseObserver.onCompleted();
        }
//        printChatReaderObservers();
    }

    @Override
    public void receiveMessageTypingStatusUpdate(UpdateRequest request,
                                                 StreamObserver<MessageTypingStatus> responseObserver) {
        if (chatReaderObservers.containsKey(request)) {
            chatReaderObservers.get(request).setMessageTypingStatusStreamObserver(responseObserver);
        } else {
            LOGGER.info("Added new ChatReaderObserver for key: " + request);
            ChatReaderObserver observer = new ChatReaderObserver();
            observer.setMessageTypingStatusStreamObserver(responseObserver);
            observer.setOnClosureCallback(this::notifyAboutClosure);
            observer.setReaderUserName(request.getRequestSenderName());
            observer.setSenderUserName(request.getPartnerName());
            chatReaderObservers.put(request, observer);
        }
    }
}
