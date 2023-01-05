package ro.tuc.chat.grpc.service_impl;

import io.grpc.stub.StreamObserver;
import lombok.Synchronized;
import lombok.extern.java.Log;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@GrpcService
public class ChatServiceImpl extends ChatServiceGrpc.ChatServiceImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatServiceImpl.class);

    private static final Map<String, ClientObserver> clientObservers = new ConcurrentHashMap<>();

    private static final AdminObserver adminObserver = new AdminObserver();

    private static final List<OpenSessionRequest> unhandledOpenSessionRequests = new ArrayList<>();

    private static final Map<String, ChatReaderObserver> chatReaderObservers =
            new ConcurrentHashMap<>(); //chat reader name to observers

    public void notifyAboutClosure(String readerName) {
        ChatUpdate update = ChatUpdate.newBuilder()
                .setSessionClosedUpdate(SessionClosedUpdate.newBuilder().setPartnerName(readerName)
                        .getDefaultInstanceForType())
                .build();

        if (readerName.equals("admin")) {
            // notify all clients
            LOGGER.info("Notifying clients that ADMIN left the session");
            for (ChatReaderObserver chatObserver : chatReaderObservers.values()) {
                if (chatObserver.getObserver() != null) {
                    chatObserver.getObserver()
                            .onNext(update);
                }
            }
        } else {
            // notify admin
            LOGGER.info("Notifying admin that " + readerName + " left the session");
            ChatReaderObserver adminObserver = chatReaderObservers.get("admin");
            if (adminObserver != null && adminObserver.getObserver() != null) {
                adminObserver.getObserver().onNext(update);
            }
        }
    }

    private void printChatReaderObservers() {
        StringBuilder status = new StringBuilder("Available Readers: ");
        for (String readerName : chatReaderObservers.keySet()) {
            status.append("Available Reader: ").append(chatReaderObservers.get(readerName)).append("\n");
        }
        LOGGER.info(status.toString());
    }

    @Override
    public void receiveChatUpdates(ChatUpdateRequest request,
                                   StreamObserver<ChatUpdate> responseObserver) {
        if (chatReaderObservers.containsKey(request.getRequestSenderName())) {
            chatReaderObservers.get(request.getRequestSenderName()).setObserver(responseObserver);
        } else {
            LOGGER.info("Added new ChatReaderObserver for key: " + request);
            ChatReaderObserver observer = new ChatReaderObserver();
            observer.setObserver(responseObserver);
            observer.setOnClosureCallback(this::notifyAboutClosure);
            observer.setReaderUserName(request.getRequestSenderName());
            chatReaderObservers.put(request.getRequestSenderName(), observer);
        }
        printChatReaderObservers();
    }

    @Override
    public void sendMessage(ChatMessage request, StreamObserver<SendMessageStatus> responseObserver) {
        LOGGER.info("Server received NEW MESSAGE: " + request);
        String recipientName = request.getToUserName();

        if (chatReaderObservers.containsKey(recipientName) &&
            chatReaderObservers.get(recipientName).getObserver() != null) {
            ChatMessage newMessage =
                    ChatMessage.newBuilder()
                            .setFromUserName(request.getFromUserName())
                            .setToUserName(request.getToUserName())
                            .setMessage(request.getMessage())
                            .setTimeStamp(LocalDateTime.now().toString())
                            .build();
            chatReaderObservers.get(recipientName).getObserver().onNext(ChatUpdate.newBuilder().setMessage(newMessage).build());

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
    public void sendMessageReadingStatusUpdate(MessageReadingStatus request, StreamObserver<Status> responseObserver) {

        LOGGER.info("Server received ReadingStatusUpdate " + request);

        if (chatReaderObservers.containsKey(request.getSenderUserName()) &&
                chatReaderObservers.get(request.getSenderUserName()).getObserver() != null) {
            chatReaderObservers.get(request.getSenderUserName()).getObserver().onNext(
                    ChatUpdate.newBuilder().setReadingStatus(request).build()
            );

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
    public void sendMessageTypingStatusUpdate(MessageTypingStatus request, StreamObserver<Status> responseObserver) {
        LOGGER.info("Server received TypingStatusUpdate " + request);

        if (chatReaderObservers.containsKey(request.getRecipientUserName()) &&
                chatReaderObservers.get(request.getRecipientUserName()).getObserver() != null) {
            chatReaderObservers.get(request.getRecipientUserName()).getObserver().onNext(
                    ChatUpdate.newBuilder().setTypingStatus(request).build()
            );

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
}
