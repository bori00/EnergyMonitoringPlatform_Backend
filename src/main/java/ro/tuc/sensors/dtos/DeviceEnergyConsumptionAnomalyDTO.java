package ro.tuc.sensors.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@AllArgsConstructor
@Getter
@ToString
public class DeviceEnergyConsumptionAnomalyDTO {
    private final UUID deviceId;

    private final String deviceName;

    private final Double hourlyEnergyConsumption;

    private final Double hourlyEnergyConsumptionLimit;
}
