package ro.tuc.webapp.dtos.builders;

import ro.tuc.webapp.dtos.DeviceDTO;
import ro.tuc.webapp.dtos.NewDeviceDTO;
import ro.tuc.common.entities.Client;
import ro.tuc.common.entities.Device;

public class DeviceBuilder {

    public static Device toEntity(NewDeviceDTO newDeviceDTO, Client client) {
        return new Device(newDeviceDTO.getName(), client);
    }

    public static Device toEntity(DeviceDTO deviceDTO, Client client) {
        return new Device(deviceDTO.getId(), deviceDTO.getName(), client);
    }

    public static DeviceDTO toDTO(Device device) {
        return new DeviceDTO(device.getId(), device.getName(), device.getClient().getUserName());
    }
}
