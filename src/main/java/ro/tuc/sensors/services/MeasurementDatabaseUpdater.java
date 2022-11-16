package ro.tuc.sensors.services;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rabbitmq.client.DeliverCallback;
import ro.tuc.sensors.config.MeasurementConsumerConfig;
import ro.tuc.sensors.dtos.MeasurementDTO;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
public class MeasurementDatabaseUpdater {

    @Autowired
    public MeasurementDatabaseUpdater(Channel measurementConsumerChannel, Gson gson) throws IOException,
            TimeoutException {
        String queueName = measurementConsumerChannel.queueDeclare().getQueue();
        measurementConsumerChannel.queueBind(queueName, MeasurementConsumerConfig.EXCHANGE_NAME,
                "");

        System.out.printf(" [*] Waiting for messages on queue %s, for updating the database\n",
                queueName);
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            MeasurementDTO measurementDTO = gson.fromJson(message, MeasurementDTO.class);
            System.out.println(" [x] Received '" + message + "=" + measurementDTO + "' for database " +
                    "update");
        };
        measurementConsumerChannel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
    }
}
