package ro.tuc.sensors.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import ro.tuc.common.config.ClientConfigProperties;

@Configuration
@EnableWebSocketMessageBroker
public class SocketsConfig implements WebSocketMessageBrokerConfigurer {

    public static final String MESSAGE_PREFIX = "/queue";

    private final ClientConfigProperties configProperties;

    @Autowired
    public SocketsConfig(ClientConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/secured/energy-utility")
                .setAllowedOrigins(configProperties.getClientUrl())
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker(MESSAGE_PREFIX, "/user");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
