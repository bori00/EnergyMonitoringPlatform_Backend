package ro.tuc.ds2020.controllers;

import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.DeviceDTO;
import ro.tuc.ds2020.dtos.DeviceEnergyConsumptionPerDayDTO;
import ro.tuc.ds2020.dtos.DeviceStatisticsRequestDTO;
import ro.tuc.ds2020.dtos.NewDeviceDTO;
import ro.tuc.ds2020.services.client_device_monitoring.ClientDeviceMonitoringService;

import javax.validation.Valid;
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
    DeviceEnergyConsumptionPerDayDTO updateDevice(@Valid @RequestBody DeviceStatisticsRequestDTO statisticsRequestDTO) {
        LOGGER.info(String.format("REQUEST - /Please provide a valid day of the month, for %s",
                statisticsRequestDTO.toString()));

        LocalDate date = LocalDate.of(statisticsRequestDTO.getYear(),
                statisticsRequestDTO.getMonth(),
                statisticsRequestDTO.getDay());

        return clientDeviceMonitoringService.getDeviceConsumptionStatisticsForDay(
                statisticsRequestDTO.getDeviceId(),
                date);
    }
}
