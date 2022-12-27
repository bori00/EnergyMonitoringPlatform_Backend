package ro.tuc.chat.config;

import lombok.*;
import net.devh.boot.grpc.server.security.authentication.BasicGrpcAuthenticationReader;
import net.devh.boot.grpc.server.security.authentication.GrpcAuthenticationReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:chat_config.txt")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ChatServerConfigProperties {
    @Value("${CHAT_SERVER_PORT}")
    private Integer chatServerPort;

    @Bean
    public GrpcAuthenticationReader grpcAuthenticationReader() {
        return new BasicGrpcAuthenticationReader();
    }
}
