package ro.tuc.webapp.services.authentication;

import org.springframework.security.crypto.password.PasswordEncoder;
import ro.tuc.webapp.dtos.NewUserDTO;
import ro.tuc.webapp.dtos.builders.UserBuilder;
import ro.tuc.common.entities.User;

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
