package ro.tuc.sensors.config;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:rabbitmq_config.txt")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RabbitMQConfigProperties {
    @Value("${EXCHANGE_NAME}")
    private String exchangeName;

    @Value("${HOST_NAME}")
    private String hostName;

    @Value("${HOST_PORT}")
    private Integer hostPort;

    @Value("${RABBITMQ_USERNAME}")
    private String rabbitmqUsername;

    @Value("${RABBITMQ_PASSWORD}")
    private String rabbitmqPassword;
}
