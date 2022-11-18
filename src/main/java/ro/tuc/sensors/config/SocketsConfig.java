package ro.tuc.sensors.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class SocketsConfig implements WebSocketMessageBrokerConfigurer {

    public static final String MESSAGE_PREFIX = "/queue";

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // todo: frontend domain dependency
        registry.addEndpoint("/secured/energy-utility")
                .setAllowedOrigins("http://localhost:3000")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker(MESSAGE_PREFIX, "/user");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
