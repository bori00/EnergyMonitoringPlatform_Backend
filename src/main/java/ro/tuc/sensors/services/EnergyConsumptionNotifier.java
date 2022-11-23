package ro.tuc.sensors.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.common.entities.Device;
import ro.tuc.sensors.dtos.DeviceConsumptionUpdateDTO;
import ro.tuc.sensors.dtos.DeviceEnergyConsumptionAnomalyDTO;
import ro.tuc.sensors.dtos.DeviceMeasurementUpdateDTO;

@Service
public class EnergyConsumptionNotifier {

    private final NotificationService notificationService;

    @Autowired
    public EnergyConsumptionNotifier(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void handleMeasurementUpdate(DeviceMeasurementUpdateDTO deviceMeasurementUpdateDTO) {
        Device device = deviceMeasurementUpdateDTO.getDevice();
        notificationService.notifyUser(deviceMeasurementUpdateDTO.getDevice().getClient(),
                new DeviceConsumptionUpdateDTO(device.getName(),
                        deviceMeasurementUpdateDTO.getNewHourlyMeasurementValue(),
                        device.getMaxHourlyConsumption()),
                NotificationService.DEVICE_ENERGY_CONSUMPTION_INCREASED_SOCKET_DEST);
    }
}
