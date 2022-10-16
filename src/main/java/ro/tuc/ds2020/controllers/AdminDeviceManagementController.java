package ro.tuc.ds2020.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.authentication.DuplicateUsernameException;
import ro.tuc.ds2020.dtos.DeviceDTO;
import ro.tuc.ds2020.dtos.NewDeviceDTO;
import ro.tuc.ds2020.dtos.NewUserDTO;
import ro.tuc.ds2020.services.admin_device_management.AdminDeviceManagementService;

import javax.validation.Valid;

@RestController
@RequestMapping("device-management")
public class AdminDeviceManagementController {

    @Autowired
    private AdminDeviceManagementService adminDeviceManagementService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminDeviceManagementController.class);

    @PostMapping("/create-device")
    @ResponseStatus(HttpStatus.OK)
    void createDevice(@Valid @RequestBody NewDeviceDTO newDeviceDTO) {
        LOGGER.info(String.format("REQUEST - /create-device, for device %s",
                newDeviceDTO.toString()));
        adminDeviceManagementService.createNewDevice(newDeviceDTO);
    }

    @PutMapping("/update-device")
    @ResponseStatus(HttpStatus.OK)
    void createDevice(@Valid @RequestBody DeviceDTO deviceDTO) {
        LOGGER.info(String.format("REQUEST - /update-device, for device %s",
                deviceDTO.toString()));
        adminDeviceManagementService.updateDevice(deviceDTO);
    }

    @DeleteMapping("/delete-device")
    @ResponseStatus(HttpStatus.OK)
    void deleteDevice(@Valid @RequestBody Long deviceId) {
        LOGGER.info(String.format("REQUEST - /device-device, for device with id %d",
                deviceId));
        adminDeviceManagementService.deleteDevice(deviceId);
    }
}
