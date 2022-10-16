package ro.tuc.ds2020.services.client_device_monitoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.authentication.NoAccessToDataException;
import ro.tuc.ds2020.dtos.DeviceDTO;
import ro.tuc.ds2020.dtos.DeviceEnergyConsumptionPerDayDTO;
import ro.tuc.ds2020.dtos.builders.DeviceBuilder;
import ro.tuc.ds2020.dtos.builders.MeasurementBuilder;
import ro.tuc.ds2020.entities.Client;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.Measurement;
import ro.tuc.ds2020.repositories.ClientRepository;
import ro.tuc.ds2020.repositories.DeviceRepository;
import ro.tuc.ds2020.repositories.MeasurementRepository;
import ro.tuc.ds2020.services.authentication.AuthenticationService;
import ro.tuc.ds2020.services.rightverifier.RightVerifierFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientDeviceMonitoringService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientDeviceMonitoringService.class);
    private final MeasurementRepository measurementRepository;
    private final DeviceRepository deviceRepository;
    private final ClientRepository clientRepository;
    private final AuthenticationService authenticationService;

    @Autowired
    public ClientDeviceMonitoringService(MeasurementRepository measurementRepository,
                                        DeviceRepository deviceRepository,
                                        ClientRepository clientRepository,
                                        AuthenticationService authenticationService) {
        this.measurementRepository = measurementRepository;
        this.deviceRepository = deviceRepository;
        this.clientRepository = clientRepository;
        this.authenticationService = authenticationService;
    }

    public List<DeviceDTO> getCurrentClientsDevices() {

        Client client = authenticationService.getCurrentClient("GetCurrentClientsDevices");

        return deviceRepository.findAllByClient(client)
                .stream()
                .map(DeviceBuilder::toDTO)
                .collect(Collectors.toList());
    }

    public DeviceEnergyConsumptionPerDayDTO
        getDeviceConsumptionStatisticsForDay(Long deviceId, LocalDate date) {

        Client client = authenticationService.getCurrentClient("GetDeviceConsumptionStatistics");

        Optional<Device> optDevice = deviceRepository.findById(deviceId);

        if (optDevice.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Device with id %d",
                    deviceId));
        }

        Device device = optDevice.get();

        if (!RightVerifierFactory.getRightVerifier(client).hasAccessToTheDataOf(client, device)) {
            throw new NoAccessToDataException("GetDeviceConsumptionStatistics");
        }

        List<Measurement> measurements =
                measurementRepository.findAllByDateAndDeviceOrderByDateTime(date, device);

        return MeasurementBuilder.toDTO(measurements, device, date);
    }
}
