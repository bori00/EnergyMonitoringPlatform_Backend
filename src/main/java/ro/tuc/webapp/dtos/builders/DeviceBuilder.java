package ro.tuc.webapp.dtos.builders;

import ro.tuc.webapp.dtos.DeviceDTO;
import ro.tuc.webapp.dtos.NewDeviceDTO;
import ro.tuc.common.entities.Client;
import ro.tuc.common.entities.Device;

import java.util.UUID;

public class DeviceBuilder {

    public static Device toEntity(NewDeviceDTO newDeviceDTO, Client client) {
        return new Device(newDeviceDTO.getName(), client, newDeviceDTO.getMaxEnergyConsumption(),
                newDeviceDTO.getDescription(), newDeviceDTO.getAddress());
    }

    public static Device toEntity(DeviceDTO deviceDTO, Client client) {
        return new Device(UUID.fromString(deviceDTO.getId()), deviceDTO.getName(), client,
                deviceDTO.getMaxEnergyConsumption(), deviceDTO.getDescription(), deviceDTO.getAddress());
    }

    public static DeviceDTO toDTO(Device device) {
        return new DeviceDTO(device.getId().toString(), device.getName(),
                device.getClient().getUserName(), device.getMaxHourlyConsumption(),
                device.getDescription(), device.getAddress());
    }
}
