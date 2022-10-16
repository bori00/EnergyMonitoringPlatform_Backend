package ro.tuc.ds2020.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class DeviceDTO {

    @NotNull(message = "The device id cannot be blank")
    private Long id;

    @NotBlank(message = "The device name cannot be blank.")
    @Size(min = 3, max = 30, message = "The device name should have a length between 3 and " +
            "30")
    private String name;

    @NotBlank(message = "The device owner's userName cannot be blank. Please choose to which user" +
            " this device belongs")
    private String userName;
}
