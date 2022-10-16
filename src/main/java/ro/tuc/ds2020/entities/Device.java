package ro.tuc.ds2020.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Device {
    @Id
    @GeneratedValue
//    @GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name = "uuid2", strategy = "uuid2")
//    @Type(type = "uuid-binary")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    @OrderBy("dateTime")
    private List<Measurement> measurements;

    public Device(String name, Client client) {
        this.name = name;
        this.client = client;
        this.measurements = new ArrayList<>();
    }

    public Device(Long id, String name, Client client) {
        this.id = id;
        this.name = name;
        this.client = client;
    }

    public List<Measurement> getMeasurements() {
        return Collections.unmodifiableList(measurements);
    }
}
