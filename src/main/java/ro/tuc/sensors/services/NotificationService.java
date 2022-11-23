package ro.tuc.sensors.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import ro.tuc.common.entities.User;
import ro.tuc.sensors.config.SocketsConfig;
import ro.tuc.sensors.dtos.MeasurementDTO;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class NotificationService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public static final String DEVICE_ENERGY_CONSUMPTION_OVER_LIMIT_SOCKET_DEST =
            SocketsConfig.MESSAGE_PREFIX + "/device-energy-consumption-threshold-passed";

    public static final String DEVICE_ENERGY_CONSUMPTION_INCREASED_SOCKET_DEST =
            SocketsConfig.MESSAGE_PREFIX + "/device-energy-consumption-update";

    @Autowired
    public NotificationService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void notifyUser(
            User user,
            Object message,
            String socketDest) {

        System.out.printf("Sending to: client: %s, queue: %s, message %s\n", user.getUserName(),
                socketDest,
                message);
        simpMessagingTemplate.convertAndSendToUser(
                user.getUserName(),
                socketDest,
                message);
    }
}
