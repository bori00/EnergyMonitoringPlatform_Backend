package ro.tuc.webapp.dtos.builders;

import ro.tuc.webapp.dtos.NewUserDTO;
import ro.tuc.webapp.dtos.UserDTO;
import ro.tuc.webapp.entities.User;

public class UserBuilder {
    public static User toEntity(NewUserDTO newUserDTO) {
        return newUserDTO.getUserType().buildUser(newUserDTO);
    }

    public static void updateDataFrom(User user, UserDTO userDTO) {
        user.setPassword(userDTO.getPassword());
        user.setEmailAddress(userDTO.getEmailAddress());
        user.setUserName(userDTO.getUserName());
    }

    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getUserName(), user.getEmailAddress(),
                user.getPassword());
    }
}
