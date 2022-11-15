package ro.tuc.sensors.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
public class MeasurementDTO {
    private final LocalDateTime timestamp;
    private final Long deviceId;
    private final Double measurementValue;
}
