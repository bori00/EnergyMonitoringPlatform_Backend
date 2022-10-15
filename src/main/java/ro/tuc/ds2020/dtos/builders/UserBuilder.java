package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.NewUserDTO;
import ro.tuc.ds2020.entities.User;

public class UserBuilder {
    public static User toEntity(NewUserDTO newUserDTO) {
        return newUserDTO.getUserType().buildUser(newUserDTO);
    }
}
