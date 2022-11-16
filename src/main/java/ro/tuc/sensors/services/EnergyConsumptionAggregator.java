package ro.tuc.sensors.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.common.entities.Device;
import ro.tuc.common.entities.Measurement;
import ro.tuc.common.repositories.DeviceRepository;
import ro.tuc.common.repositories.MeasurementRepository;
import ro.tuc.sensors.dtos.MeasurementDTO;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnergyConsumptionAggregator {

    private final MeasurementRepository measurementRepository;

    private final DeviceRepository deviceRepository;

    @Autowired
    public EnergyConsumptionAggregator(MeasurementRepository measurementRepository,
                                       DeviceRepository deviceRepository) {
        this.measurementRepository = measurementRepository;
        this.deviceRepository = deviceRepository;
    }

    public void addEnergyConsumption(MeasurementDTO measurementDTO) {

        LocalDateTime dateTime = measurementDTO.getTimestamp().toLocalDateTime();
        LocalDateTime hourStart = dateTime
                .minusMinutes(dateTime.getMinute())
                .minusSeconds(dateTime.getSecond())
                .minusNanos(dateTime.getNano());
        LocalDateTime hourEnd = hourStart.plusMinutes(59).plusSeconds(59).plusNanos(999999999);

        Device device = deviceRepository.getOne(measurementDTO.getDeviceId());
        List<Measurement> existingMeasurement =
                measurementRepository.findAllByDateTimeBetweenAndDevice(hourStart, hourEnd, device);

        if (existingMeasurement.isEmpty()) {
            Measurement newHourlyMeasurement = new Measurement(hourStart,
                    measurementDTO.getMeasurementValue(), device);

            measurementRepository.save(newHourlyMeasurement);
        } else if (existingMeasurement.size() == 1) {
            existingMeasurement.get(0).increaseEnergyConsumption(measurementDTO.getMeasurementValue());

            measurementRepository.save(existingMeasurement.get(0));
        } else {
            throw new IllegalStateException(String.format("Multiple measurements saved for device" +
                            " %s, hour %s",
                    device.getId().toString(), hourStart.toString()));
        }
    }
}
