package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.DeviceEnergyConsumptionPerDayDTO;
import ro.tuc.ds2020.dtos.NewUserDTO;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.Measurement;
import ro.tuc.ds2020.entities.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeasurementBuilder {
    public static DeviceEnergyConsumptionPerDayDTO toDTO(List<Measurement> measurements,
                                                         Device device,
                                                         LocalDate localDate) {
        return new DeviceEnergyConsumptionPerDayDTO(
            device.getId(),
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
