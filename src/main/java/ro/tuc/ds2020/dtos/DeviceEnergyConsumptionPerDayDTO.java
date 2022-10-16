package ro.tuc.ds2020.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DeviceEnergyConsumptionPerDayDTO {
    @NotNull
    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private LocalDate date;

    // Energy consumption aggregated per hour. The list has 24 elements, as follows:
    // energyConsumptionPerHour.get(0)  = the consumption between 00:00 and 00:59
    // ...
    // energyConsumptionPerHour.get(23) = the consumption between 23:00 and 23:59
    @NotNull
    private List<Double> energyConsumptionPerHour;
}
