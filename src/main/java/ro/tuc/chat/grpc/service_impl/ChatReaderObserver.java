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

    private StreamObserver<ChatUpdate> observer;

    private Consumer<String> onClosureCallback;

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientObserver.class);

    public void setObserver(@NotNull StreamObserver<ChatUpdate> observer) {
        this.observer = observer;

        ServerCallStreamObserver<ChatUpdate> handledObserver =
                ((ServerCallStreamObserver<ChatUpdate>) observer);
        handledObserver.setOnCancelHandler(this::removeObserver);
        handledObserver.setOnCloseHandler(this::removeObserver);
    }

    public void removeObserver() {
        observer = null;
        notifyServiceAboutClosure();
        LOGGER.info("Server received CANCEL/CLOSE Receive ChatMessages");
    }

    public void setOnClosureCallback(Consumer<String> onClosureCallback) {
        this.onClosureCallback = onClosureCallback;
    }

    public void setReaderUserName(String readerUserName) {
        this.readerUserName = readerUserName;
    }

    private void notifyServiceAboutClosure() {
        onClosureCallback.accept(readerUserName);
    }

    @Override
    public String toString() {
        return "ChatReaderObserver{" +
                "readerUserName='" + readerUserName + '\'' +
                ", observer=" + observer +
                '}';
    }
}
