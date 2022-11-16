package ro.tuc.webapp.services.client_device_monitoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.webapp.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.webapp.controllers.handlers.exceptions.model.authentication.NoAccessToDataException;
import ro.tuc.webapp.dtos.DeviceDTO;
import ro.tuc.webapp.dtos.DeviceEnergyConsumptionPerDayDTO;
import ro.tuc.webapp.dtos.builders.DeviceBuilder;
import ro.tuc.webapp.dtos.builders.MeasurementBuilder;
import ro.tuc.common.entities.Client;
import ro.tuc.common.entities.Device;
import ro.tuc.common.entities.Measurement;
import ro.tuc.common.repositories.ClientRepository;
import ro.tuc.common.repositories.DeviceRepository;
import ro.tuc.common.repositories.MeasurementRepository;
import ro.tuc.webapp.services.authentication.AuthenticationService;
import ro.tuc.webapp.services.rightverifier.RightVerifierFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
        getDeviceConsumptionStatisticsForDay(String deviceId, LocalDate date) {

        Client client = authenticationService.getCurrentClient("GetDeviceConsumptionStatistics");

        Optional<Device> optDevice = deviceRepository.findById(UUID.fromString(deviceId));

        if (optDevice.isEmpty()) {
            throw new ResourceNotFoundException(String.format("Device with id %s",
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
