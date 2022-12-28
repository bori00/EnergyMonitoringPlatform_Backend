package ro.tuc.chat.grpc.service_impl;

import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tuc.chat.proto_gen.ChatMessage;
import ro.tuc.chat.proto_gen.MessageReadingStatus;
import ro.tuc.chat.proto_gen.MessageTypingStatus;
import ro.tuc.chat.proto_gen.OpenSessionRequestResponse;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientObserver {
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
}
