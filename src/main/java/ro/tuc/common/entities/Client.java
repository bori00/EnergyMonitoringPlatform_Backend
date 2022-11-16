package ro.tuc.common.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "client")
@ToString
@Setter
@NoArgsConstructor
@Getter
public class Client extends User {

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Device> devices;

    public Client(String userName, String emailAddress, String password) {
        super(userName, emailAddress, password);
    }
}
