package ro.tuc.sensors.config;

import com.google.gson.*;
import com.rabbitmq.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.concurrent.TimeoutException;

@Configuration
public class MeasurementConsumerConfig {

    public static final String EXCHANGE_NAME = "device-measurements";
    public static final String HOST_NAME = "localhost";

    @Autowired
    private RabbitMQConfigProperties rabbitMQConfigProperties;

    @Bean
    Channel measurementConsumerChannel() throws IOException,
            TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(rabbitMQConfigProperties.getHostName());
        factory.setPort(rabbitMQConfigProperties.getHostPort());
        factory.setUsername(rabbitMQConfigProperties.getRabbitmqUsername());
        factory.setPassword(rabbitMQConfigProperties.getRabbitmqPassword());
        factory.setVirtualHost(rabbitMQConfigProperties.getRabbitmqUsername());
        
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(rabbitMQConfigProperties.getExchangeName(), "fanout");

        return channel;
    }

    @Bean
    Gson setupGson() {
        return new GsonBuilder()
                .registerTypeAdapter(Timestamp.class, (JsonDeserializer<Timestamp>) (jsonElement,
                                                                                     type, context) ->
                    new Timestamp(jsonElement.getAsLong())
                )
                .registerTypeAdapter(Timestamp.class, (JsonSerializer<Timestamp>) (value, type,
                                                                                   context) ->
                    new JsonPrimitive(value.getTime())
                )
                .create();
    }
}
