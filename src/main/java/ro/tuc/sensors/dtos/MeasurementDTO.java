package ro.tuc.sensors.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
public class MeasurementDTO {
    private final Timestamp timestamp;
    private final Long deviceId;
    private final Double measurementValue;
}
