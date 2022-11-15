package ro.tuc.webapp.dtos;

import lombok.*;
import ro.tuc.webapp.entities.Admin;
import ro.tuc.webapp.entities.Client;
import ro.tuc.webapp.entities.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class NewUserDTO {

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

    @NotNull(message = "The user must have ADMIN or CLIENT type.")
    private UserType userType;

    public enum UserType {
        ADMIN {
            @Override
            public User buildUser(NewUserDTO userDTO) {
                return new Admin(userDTO.getUserName(), userDTO.getEmailAddress(),
                        userDTO.getPassword());
            }

        },
        CLIENT {
            @Override
            public User buildUser(NewUserDTO userDTO) {
                return new Client(userDTO.getUserName(), userDTO.getEmailAddress(),
                        userDTO.getPassword());
            }
        };

        public abstract User buildUser(NewUserDTO newUserDTO);
    }
}
