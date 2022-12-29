package ro.tuc.chat.grpc.service_impl;

import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ro.tuc.chat.proto_gen.*;

import javax.validation.constraints.NotNull;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ChatReaderObserver {
    private String readerUserName;

    private String senderUserName;

    private StreamObserver<ChatMessage> incomingMessageStreamObserver;

    private StreamObserver<MessageReadingStatus> messageReadingStatusStreamObserver;

    private StreamObserver<MessageTypingStatus> messageTypingStatusStreamObserver;

    private BiConsumer<String, String> onClosureCallback;

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientObserver.class);

    public void setIncomingMessageStreamObserver(@NotNull StreamObserver<ChatMessage> incomingMessageStreamObserver) {
        this.incomingMessageStreamObserver = incomingMessageStreamObserver;

        ServerCallStreamObserver<ChatMessage> handledObserver =
                ((ServerCallStreamObserver<ChatMessage>) incomingMessageStreamObserver);
        handledObserver.setOnCancelHandler(this::removeObservers);
        handledObserver.setOnCloseHandler(this::removeObservers);
    }

    public void removeObservers() {
        incomingMessageStreamObserver = null;
        messageReadingStatusStreamObserver = null;
        messageTypingStatusStreamObserver = null;
        notifyServiceAboutClosure();
        LOGGER.info("Server received CANCEL/CLOSE Receive ChatMessages");
    }

    public void closeObservers() {
        if (incomingMessageStreamObserver != null) incomingMessageStreamObserver.onCompleted();
        if (messageTypingStatusStreamObserver != null) messageTypingStatusStreamObserver.onCompleted();
        if (messageReadingStatusStreamObserver != null) messageReadingStatusStreamObserver.onCompleted();
    }

    public void setOnClosureCallback(BiConsumer<String, String> onClosureCallback) {
        this.onClosureCallback = onClosureCallback;
    }

    public void setReaderUserName(String readerUserName) {
        this.readerUserName = readerUserName;
    }

    public void setSenderUserName(String senderUserName) {
        this.senderUserName = senderUserName;
    }

    private void notifyServiceAboutClosure() {
        onClosureCallback.accept(readerUserName, senderUserName);
    }
}
