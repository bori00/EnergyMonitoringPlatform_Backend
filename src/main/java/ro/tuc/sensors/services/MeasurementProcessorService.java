package ro.tuc.sensors.services;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rabbitmq.client.DeliverCallback;
import ro.tuc.sensors.config.MeasurementConsumerConfig;
import ro.tuc.sensors.config.RabbitMQConfigProperties;
import ro.tuc.sensors.dtos.DeviceMeasurementUpdateDTO;
import ro.tuc.sensors.dtos.MeasurementDTO;
import ro.tuc.webapp.controllers.AdminDeviceManagementController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
public class MeasurementProcessorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MeasurementProcessorService.class);


    @Autowired
    public MeasurementProcessorService(Channel measurementConsumerChannel,
                                       Gson gson,
                                       EnergyConsumptionAggregator energyConsumptionAggregator,
                                       EnergyConsumptionAnomalyNotifier energyConsumptionAnomalyNotifier,
                                        EnergyConsumptionNotifier energyConsumptionNotifier,
                                        RabbitMQConfigProperties rabbitMQConfig) throws IOException{
        String queueName = "persistent_queue";
        boolean durable = true;
        measurementConsumerChannel.queueDeclare(queueName, durable, false, false, null);
        measurementConsumerChannel.queueBind(queueName, rabbitMQConfig.getExchangeName(), "");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            MeasurementDTO measurementDTO = gson.fromJson(message, MeasurementDTO.class);
            LOGGER.info(" [x] Received '" + message + "=" + measurementDTO + "' for database " +
                    "update");

            try {
                DeviceMeasurementUpdateDTO deviceMeasurementUpdateDTO =
                        energyConsumptionAggregator.addEnergyConsumption(measurementDTO);

                energyConsumptionAnomalyNotifier.handleMeasurementUpdate(deviceMeasurementUpdateDTO);

                measurementConsumerChannel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
                energyConsumptionNotifier.handleMeasurementUpdate(deviceMeasurementUpdateDTO);
            } catch (Exception exception){
                measurementConsumerChannel.basicReject(delivery.getEnvelope().getDeliveryTag(), false);
            }
        };
        boolean autoAck = false;
        measurementConsumerChannel.basicConsume(queueName, autoAck, deliverCallback,
                consumerTag -> { });

        LOGGER.info(" [*] Waiting for messages on queue {}, for updating the database\n",
                queueName);
    }
}
