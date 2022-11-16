package ro.tuc.webapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.tuc.webapp.dtos.DeviceDTO;
import ro.tuc.webapp.dtos.DeviceEnergyConsumptionPerDayDTO;
import ro.tuc.webapp.services.client_device_monitoring.ClientDeviceMonitoringService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("device-monitoring")
@PreAuthorize("hasAuthority('CLIENT')")
public class ClientDeviceMonitoringController {

    @Autowired
    private ClientDeviceMonitoringService clientDeviceMonitoringService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientDeviceMonitoringController.class);

    @GetMapping("/get-my-devices")
    @ResponseStatus(HttpStatus.OK)
    List<DeviceDTO> getMyDevices() {
        LOGGER.info("REQUEST - /get-my-devices");
        return clientDeviceMonitoringService.getCurrentClientsDevices();
    }

    @GetMapping("/get-energy-consumption-for-day")
    @ResponseStatus(HttpStatus.OK)
    DeviceEnergyConsumptionPerDayDTO getEnergyConsumptionForDay(
                                                  @RequestParam String deviceId,
                                                  @RequestParam Integer year,
                                                  @RequestParam Integer month,
                                                  @RequestParam Integer day) {

        LocalDate date = LocalDate.of(year,
                month,
                day);

        LOGGER.info(String.format("REQUEST - /get-energy-consumption-for-day, for  device %s, " +
                        "date = %s",
                deviceId, date.toString()));

        return clientDeviceMonitoringService.getDeviceConsumptionStatisticsForDay(
                deviceId,
                date);
    }
}
