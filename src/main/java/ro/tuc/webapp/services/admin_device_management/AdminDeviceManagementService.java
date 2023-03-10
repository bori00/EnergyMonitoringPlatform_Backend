package ro.tuc.webapp.services.admin_device_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.webapp.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.webapp.controllers.handlers.exceptions.model.authentication.NoAccessToDataException;
import ro.tuc.webapp.dtos.DeviceDTO;
import ro.tuc.webapp.dtos.NewDeviceDTO;
import ro.tuc.webapp.dtos.builders.DeviceBuilder;
import ro.tuc.common.entities.Admin;
import ro.tuc.common.entities.Client;
import ro.tuc.common.entities.Device;
import ro.tuc.common.repositories.ClientRepository;
import ro.tuc.common.repositories.DeviceRepository;
import ro.tuc.webapp.services.authentication.AuthenticationService;
import ro.tuc.webapp.services.rightverifier.RightVerifierFactory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AdminDeviceManagementService {

    private final DeviceRepository deviceRepository;
    private final AuthenticationService authenticationService;
    private final ClientRepository clientRepository;

    @Autowired
    public AdminDeviceManagementService(DeviceRepository deviceRepository,
                                        AuthenticationService authenticationService,
                                        ClientRepository clientRepository) {
        this.deviceRepository = deviceRepository;
        this.authenticationService = authenticationService;
        this.clientRepository = clientRepository;
    }

    public DeviceDTO createNewDevice(NewDeviceDTO newDeviceDTO) {
        Admin admin = authenticationService.getCurrentAdmin("CreateNewDevice");

        Optional<Client> client = clientRepository.findByUserName(newDeviceDTO.getUserName());
        if (client.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Client with name %s",
                    newDeviceDTO.getUserName()));
        }

        Device device = DeviceBuilder.toEntity(newDeviceDTO, client.get());

        Device savedDevice = deviceRepository.save(device);

        return DeviceBuilder.toDTO(savedDevice);
    }

    public DeviceDTO updateDevice(DeviceDTO deviceDTO) {
        Admin admin = authenticationService.getCurrentAdmin("CreateNewDevice");

        Optional<Device> optPastDevice =
                deviceRepository.findById(deviceDTO.getId());

        if (optPastDevice.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Device with id %s",
                    deviceDTO.getId()));
        }

        Optional<Client> client = clientRepository.findByUserName(deviceDTO.getUserName());
        if (client.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Client with name %s",
                    deviceDTO.getUserName()));
        }

        Device newDevice = DeviceBuilder.toEntity(deviceDTO, client.get());

        Device savedDevice = deviceRepository.save(newDevice);

        return DeviceBuilder.toDTO(savedDevice);
    }

    public void deleteDevice(String deviceId) {
        Admin admin = authenticationService.getCurrentAdmin("CreateNewDevice");

        Optional<Device> optDevice = deviceRepository.findById(deviceId);

        if (optDevice.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Device with id %s",
                    deviceId));
        }

        Device device = optDevice.get();

        if (!RightVerifierFactory.getRightVerifier(admin).hasRightToModifyTheDataOf(admin, device)) {
            throw new NoAccessToDataException(String.format("Device %s", deviceId));
        }

        deviceRepository.delete(device);
    }

    public List<DeviceDTO> getAllDevices() {
        return deviceRepository.findAll().stream()
                .sorted()
                .map(DeviceBuilder::toDTO)
                .collect(Collectors.toList());
    }
}
