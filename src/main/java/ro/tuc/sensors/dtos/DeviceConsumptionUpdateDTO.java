package ro.tuc.sensors.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class DeviceConsumptionUpdateDTO {
    private final String deviceName;

    private final Double hourlyEnergyConsumption;

    private final Double hourlyEnergyConsumptionThreshold;
}
