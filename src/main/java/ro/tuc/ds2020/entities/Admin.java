package ro.tuc.ds2020.entities;

import lombok.*;

import javax.persistence.*;

@Entity(name = "admin")
@ToString
@Setter
@NoArgsConstructor
@Getter
public class Admin extends User {

    public Admin(String userName, String emailAddress, String password) {
        super(userName, emailAddress, password);
    }
}
