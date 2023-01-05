package ro.tuc.chat.config;

import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import lombok.*;
import net.devh.boot.grpc.server.security.authentication.BasicGrpcAuthenticationReader;
import net.devh.boot.grpc.server.security.authentication.GrpcAuthenticationReader;
import net.devh.boot.grpc.server.serverfactory.GrpcServerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

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

    @Bean
    public GrpcServerConfigurer keepAliveServerConfigurer() {
        return serverBuilder -> {
            if (serverBuilder instanceof NettyServerBuilder) {
                ((NettyServerBuilder) serverBuilder)
                        .keepAliveTime(30, TimeUnit.MINUTES)
                        .keepAliveTimeout(5, TimeUnit.SECONDS)
                        .maxConnectionIdle(30, TimeUnit.MINUTES)
                        .maxConnectionAge(30, TimeUnit.MINUTES)
                        .permitKeepAliveWithoutCalls(true);
            }
        };
    }
}
