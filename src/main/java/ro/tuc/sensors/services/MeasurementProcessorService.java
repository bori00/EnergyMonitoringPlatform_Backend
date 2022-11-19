package ro.tuc.sensors.services;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rabbitmq.client.DeliverCallback;
import ro.tuc.sensors.config.MeasurementConsumerConfig;
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
                                       EnergyConsumptionAnomalyNotifier energyConsumptionAnomalyNotifier) throws IOException{
        String queueName = measurementConsumerChannel.queueDeclare().getQueue();
        measurementConsumerChannel.queueBind(queueName, MeasurementConsumerConfig.EXCHANGE_NAME,
                "");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            MeasurementDTO measurementDTO = gson.fromJson(message, MeasurementDTO.class);
            LOGGER.info(" [x] Received '" + message + "=" + measurementDTO + "' for database " +
                    "update");

            DeviceMeasurementUpdateDTO deviceMeasurementUpdateDTO =
                    energyConsumptionAggregator.addEnergyConsumption(measurementDTO);

            energyConsumptionAnomalyNotifier.handleMeasurementUpdate(deviceMeasurementUpdateDTO);
        };
        measurementConsumerChannel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });

        LOGGER.info(" [*] Waiting for messages on queue {}, for updating the database\n",
                queueName);
    }
}
