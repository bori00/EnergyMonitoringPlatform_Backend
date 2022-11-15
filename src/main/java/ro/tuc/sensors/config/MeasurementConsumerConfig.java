package ro.tuc.sensors.config;

import com.google.gson.*;
import com.rabbitmq.client.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
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
                .registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (jsonElement, type, context) ->
                        LocalDateTime.parse(jsonElement.getAsJsonPrimitive().getAsString(), DateTimeFormatter.ISO_DATE_TIME)
                )
                .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>) (value, type, context) ->
                        new JsonPrimitive(value.format(DateTimeFormatter.ISO_DATE_TIME))
                )
                .create();
    }
}
