package ro.tuc.sensors.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import ro.tuc.common.entities.Device;

@AllArgsConstructor
@Getter
@ToString
public class DeviceMeasurementUpdateDTO {
    private final Device device;

    private final Double oldHourlyMeasurementValue;

    private final Double newHourlyMeasurementValue;
}
