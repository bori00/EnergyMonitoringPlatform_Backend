package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.NewUserDTO;
import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.entities.Admin;
import ro.tuc.ds2020.entities.User;

public class UserBuilder {
    public static User toEntity(NewUserDTO newUserDTO) {
        return newUserDTO.getUserType().buildUser(newUserDTO);
    }

    public static void updateDataFrom(User user, UserDTO userDTO) {
        user.setPassword(userDTO.getPassword());
        user.setEmailAddress(userDTO.getEmailAddress());
        user.setUserName(userDTO.getUserName());
    }
}
