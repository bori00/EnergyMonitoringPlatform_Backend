package ro.tuc.chat.grpc.service_impl;

import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.aspectj.bridge.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.tuc.chat.proto_gen.OpenSessionRequest;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AdminObserver {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminObserver.class);

    private StreamObserver<OpenSessionRequest> openSessionRequestStreamObserver;

    public void setOpenSessionRequestStreamObserver(@NotNull StreamObserver<OpenSessionRequest> openSessionRequestStreamObserver) {
        this.openSessionRequestStreamObserver = openSessionRequestStreamObserver;

        ServerCallStreamObserver<OpenSessionRequest> handledObserver =
                ((ServerCallStreamObserver<OpenSessionRequest>) openSessionRequestStreamObserver);
        handledObserver.setOnCancelHandler(this::removeOpenSessionRequestStreamObserver);
        handledObserver.setOnCloseHandler(this::removeOpenSessionRequestStreamObserver);
    }

    public void removeOpenSessionRequestStreamObserver() {
        openSessionRequestStreamObserver = null;
        LOGGER.info("Server received CANCEL/CLOSE Receive OpenSessionRequest");
    }
}
