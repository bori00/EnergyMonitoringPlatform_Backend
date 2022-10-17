package ro.tuc.ds2020.services.authentication;

import org.springframework.security.crypto.password.PasswordEncoder;
import ro.tuc.ds2020.dtos.NewUserDTO;
import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.dtos.builders.UserBuilder;
import ro.tuc.ds2020.entities.User;

/**
 * Factory class that builds a user from a given NewUserDTO.
 */
public class UserFactory {

    public static User buildUser(NewUserDTO userDTO,
                                 PasswordEncoder passwordEncoder) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return UserBuilder.toEntity(userDTO);
    }
}
