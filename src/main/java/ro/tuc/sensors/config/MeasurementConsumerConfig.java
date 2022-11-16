package ro.tuc.sensors.config;

import com.google.gson.*;
import com.rabbitmq.client.*;
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
