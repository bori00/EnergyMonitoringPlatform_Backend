package ro.tuc.sensors.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.common.entities.Device;
import ro.tuc.sensors.dtos.DeviceEnergyConsumptionAnomalyDTO;
import ro.tuc.sensors.dtos.DeviceMeasurementUpdateDTO;

@Service
public class EnergyConsumptionAnomalyNotifier {

    private final NotificationService notificationService;

    @Autowired
    public EnergyConsumptionAnomalyNotifier(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void handleMeasurementUpdate(DeviceMeasurementUpdateDTO deviceMeasurementUpdateDTO) {
        if (deviceMeasurementUpdateDTO.getNewHourlyMeasurementValue() > deviceMeasurementUpdateDTO.getDevice().getMaxHourlyConsumption() &&
            deviceMeasurementUpdateDTO.getOldHourlyMeasurementValue() <= deviceMeasurementUpdateDTO.getDevice().getMaxHourlyConsumption()) {

            Device device = deviceMeasurementUpdateDTO.getDevice();
            notificationService.notifyUser(deviceMeasurementUpdateDTO.getDevice().getClient(),
                    new DeviceEnergyConsumptionAnomalyDTO(device.getId(), device.getName(),
                            deviceMeasurementUpdateDTO.getNewHourlyMeasurementValue(),
                            device.getMaxHourlyConsumption()),
                    NotificationService.DEVICE_ENERGY_CONSUMPTION_OVER_LIMIT_SOCKET_DEST);
        }
    }
}
