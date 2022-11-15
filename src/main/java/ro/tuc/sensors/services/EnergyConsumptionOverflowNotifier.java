package ro.tuc.sensors.services;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.sensors.config.MeasurementConsumerConfig;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
public class EnergyConsumptionOverflowNotifier {
    @Autowired
    public EnergyConsumptionOverflowNotifier(Channel measurementConsumerChannel) throws IOException,
            TimeoutException {
        String queueName = measurementConsumerChannel.queueDeclare().getQueue();
        measurementConsumerChannel.queueBind(queueName, MeasurementConsumerConfig.EXCHANGE_NAME,
                "");

        System.out.printf(" [*] Waiting for messages on queue %s, for threshold verification and " +
                "user notification\n", queueName);
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "' for threshold verification");
        };
        measurementConsumerChannel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
    }
}
