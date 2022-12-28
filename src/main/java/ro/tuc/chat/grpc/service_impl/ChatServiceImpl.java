package ro.tuc.chat.grpc.service_impl;

import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.tuc.chat.proto_gen.*;
import ro.tuc.webapp.controllers.AuthenticationController;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@GrpcService
public class ChatServiceImpl extends ChatServiceGrpc.ChatServiceImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatServiceImpl.class);

    private static final Map<String, ClientObserver> clientObservers = new HashMap<>();

    private static final AdminObserver adminObserver = new AdminObserver();

    private static final List<OpenSessionRequest> unhandledOpenSessionRequests = new ArrayList<>();

    @Override
    public void sendMessage(ChatMessage request, StreamObserver<Status> responseObserver) {
        super.sendMessage(request, responseObserver);
    }

    @Override
    public void receiveMessage(Empty request, StreamObserver<ChatMessage> responseObserver) {
        super.receiveMessage(request, responseObserver);
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
    }


    @Override
    public void receiveOpenSessionRequest(Empty request, StreamObserver<OpenSessionRequest> responseObserver) {
        LOGGER.info("Server received Receive OpenSessionRequest");
        adminObserver.setOpenSessionRequestStreamObserver(responseObserver);

        // handle previous requests
        while (!unhandledOpenSessionRequests.isEmpty()) {
            adminObserver.getOpenSessionRequestStreamObserver().onNext(unhandledOpenSessionRequests.remove(0));
        }
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
