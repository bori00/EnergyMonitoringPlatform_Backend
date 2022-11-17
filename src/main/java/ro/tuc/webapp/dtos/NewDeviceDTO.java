package ro.tuc.webapp.dtos;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class NewDeviceDTO {

    @NotBlank(message = "The device name cannot be blank.")
    @Size(min = 3, max = 30, message = "The device name should have a length between 3 and " +
            "30")
    private String name;

    @NotBlank(message = "The device owner's userName cannot be blank. Please choose to which user" +
            " this device belongs")
    private String userName;

    @NotNull(message = "The device must have an energy consumption limit.")
    @PositiveOrZero(message = "The energy consumption threshold must be >= 0")
    private Double maxEnergyConsumption;

    @Size(max = 1000, message = "The device description should have a length <= 1000")
    private String description;

    @Size(max = 200, message = "The device address should have a length <= 200")
    private String address;
}
