package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.DeviceDTO;
import ro.tuc.ds2020.dtos.NewDeviceDTO;
import ro.tuc.ds2020.dtos.NewUserDTO;
import ro.tuc.ds2020.entities.Client;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.User;

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
