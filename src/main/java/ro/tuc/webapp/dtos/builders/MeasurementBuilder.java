package ro.tuc.webapp.dtos.builders;

import ro.tuc.webapp.dtos.DeviceEnergyConsumptionPerDayDTO;
import ro.tuc.common.entities.Device;
import ro.tuc.common.entities.Measurement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MeasurementBuilder {
    public static DeviceEnergyConsumptionPerDayDTO toDTO(List<Measurement> measurements,
                                                         Device device,
                                                         LocalDate localDate) {
        return new DeviceEnergyConsumptionPerDayDTO(
            device.getId().toString(),
            device.getName(),
            localDate,
            getMeasurementsPerHour(measurements)
        );
    }

    private static List<Double> getMeasurementsPerHour(List<Measurement> measurements) {
        List<Double> measurementsPerHour = Arrays.asList(new Double[24]);

        for (Measurement measurement : measurements) {
            measurementsPerHour.set(measurement.getDateTime().getHour(),
                    measurement.getEnergyConsumption());
        }

        return measurementsPerHour;
    }
}
