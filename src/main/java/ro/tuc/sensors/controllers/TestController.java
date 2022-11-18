package ro.tuc.sensors.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ro.tuc.sensors.dtos.MeasurementDTO;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Controller
public class TestController {

    @MessageMapping("/test")
    @SendTo("/queue/device-energy-consumption-over-limit")
    MeasurementDTO sendTo() {
        return new MeasurementDTO(Timestamp.valueOf(LocalDateTime.now()), UUID.randomUUID(),
                12.5);
    }
}
