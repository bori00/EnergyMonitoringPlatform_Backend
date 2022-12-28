package ro.tuc.chat.grpc.service_impl;

import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.tuc.chat.proto_gen.OpenSessionRequest;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminObserver {
    private StreamObserver<OpenSessionRequest> openSessionRequestStreamObserver;

}
