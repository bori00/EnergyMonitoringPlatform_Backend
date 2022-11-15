package ro.tuc.sensors.config;

import com.rabbitmq.client.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Configuration
public class MeasurementConsumerConfig {

    public static final String EXCHANGE_NAME = "device-measurements";
    public static final String HOST_NAME = "localhost";

    @Bean
    Channel measurementConsumerChannel() throws IOException,
            TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST_NAME);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        return channel;
    }
}
