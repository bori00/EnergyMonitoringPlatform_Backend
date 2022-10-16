package ro.tuc.ds2020.dtos;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class DeviceStatisticsRequestDTO {

    @NotNull(message = "The device id must not be blank")
    private Long deviceId;

    @NotNull(message = "The year must not be blank")
    @Min(value = 1990, message = "Please provide a valid year, for which measurements exist")
    @Max(value = 2025, message = "Please provide a valid year, for which measurements exist")
    private Integer year;

    @NotNull(message = "The month must not be blank")
    @Min(value = 1, message = "Please provide a valid month of the year")
    @Max(value = 12, message = "Please provide a valid month of the year")
    private Integer month;

    @NotNull(message = "The day must not be blank")
    @Min(value = 1, message = "Please provide a valid day of the month")
    @Max(value = 31, message = "Please provide a valid day of the month")
    private Integer day;
}
