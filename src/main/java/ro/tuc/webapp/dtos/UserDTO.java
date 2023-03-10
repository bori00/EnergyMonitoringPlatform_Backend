package ro.tuc.webapp.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class UserDTO {

    @NotNull(message = "The user id be blank.")
    private String id;

    @NotBlank(message = "The username cannot be blank.")
    @Size(min = 3, max = 30, message = "The username should have a length between 3 and " +
            "30")
    private String userName;

    @NotBlank(message = "The email address cannot be blank.")
    @Size(min = 3, max = 100, message = "The email address should have a length between 3 " +
            "and 100.")
    private String emailAddress;

    @NotBlank(message = "The password cannot be blank.")
    @Size(min = 3, max = 100, message = "The password should have a length between 3 " +
            "and 100.")
    private String password;
}