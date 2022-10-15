package ro.tuc.ds2020.dtos;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
// TODO: validation
public class UserDTO {

    private String userName;

    private String password;
}