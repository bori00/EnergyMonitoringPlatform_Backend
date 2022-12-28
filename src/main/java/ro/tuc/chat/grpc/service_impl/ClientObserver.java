package ro.tuc.chat.grpc.service_impl;

import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.tuc.chat.proto_gen.*;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ClientObserver {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientObserver.class);

    private String userName;

    private StreamObserver<OpenSessionRequestResponse> openSessionRequestResponseStreamObserver;

    private StreamObserver<ChatMessage> incomingMessageStreamObserver;

    private StreamObserver<MessageReadingStatus> messageReadingStatusStreamObserver;

    private StreamObserver<MessageTypingStatus> messageTypingStatusStreamObserver;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientObserver that = (ClientObserver) o;

        return userName != null ? userName.equals(that.userName) : that.userName == null;
    }

    @Override
    public int hashCode() {
        return userName != null ? userName.hashCode() : 0;
    }

    public void sendOpenSessionRequestResponse(OpenSessionRequestResponse response) {
        getOpenSessionRequestResponseStreamObserver().onNext(response);
        getOpenSessionRequestResponseStreamObserver().onCompleted();
        openSessionRequestResponseStreamObserver = null;
    }

    public void setOpenSessionRequestResponseStreamObserver(@NotNull StreamObserver<OpenSessionRequestResponse> openSessionRequestResponseStreamObserver) {
        this.openSessionRequestResponseStreamObserver = openSessionRequestResponseStreamObserver;

        ServerCallStreamObserver<OpenSessionRequestResponse> handledObserver =
                ((ServerCallStreamObserver<OpenSessionRequestResponse>) openSessionRequestResponseStreamObserver);
        handledObserver.setOnCancelHandler(this::removeOpenSessionRequestResponseStreamObserver);
        handledObserver.setOnCloseHandler(this::removeOpenSessionRequestResponseStreamObserver);
    }

    public void removeOpenSessionRequestResponseStreamObserver() {
        openSessionRequestResponseStreamObserver = null;
        LOGGER.info("Server received CANCEL/CLOSE Receive OpenSessionRequestResponse");
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
