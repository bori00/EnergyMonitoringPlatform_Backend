package ro.tuc.ds2020.services.admin_device_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.authentication.NoAccessToDataException;
import ro.tuc.ds2020.dtos.DeviceDTO;
import ro.tuc.ds2020.dtos.NewDeviceDTO;
import ro.tuc.ds2020.dtos.builders.DeviceBuilder;
import ro.tuc.ds2020.dtos.builders.MeasurementBuilder;
import ro.tuc.ds2020.entities.Admin;
import ro.tuc.ds2020.entities.Client;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.Measurement;
import ro.tuc.ds2020.repositories.ClientRepository;
import ro.tuc.ds2020.repositories.DeviceRepository;
import ro.tuc.ds2020.services.authentication.AuthenticationService;
import ro.tuc.ds2020.services.rightverifier.RightVerifierFactory;

import java.util.List;
import java.util.Optional;

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

        Optional<Device> optPastDevice = deviceRepository.findById(deviceDTO.getId());

        if (optPastDevice.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Device with id %d",
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

    public void deleteDevice(Long deviceId) {
        Admin admin = authenticationService.getCurrentAdmin("CreateNewDevice");

        Optional<Device> optDevice = deviceRepository.findById(deviceId);

        if (optDevice.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Device with id %d",
                    deviceId));
        }

        Device device = optDevice.get();

        if (!RightVerifierFactory.getRightVerifier(admin).hasRightToModifyTheDataOf(admin, device)) {
            throw new NoAccessToDataException(String.format("Device %d", deviceId));
        }

        deviceRepository.delete(device);
    }
}
