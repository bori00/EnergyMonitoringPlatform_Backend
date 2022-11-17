package ro.tuc.common.entities;

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
public class Device implements Comparable<Device>{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
//    @Type(type="uuid-binary")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "hourly_consumption_limit", nullable = false)
    private Double maxHourlyConsumption;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "address", nullable = true)
    private String address;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    @OrderBy("dateTime")
    private List<Measurement> measurements;

    public Device(String name, Client client, Double maxHourlyConsumption, String description,
                  String address) {
        this.name = name;
        this.client = client;
        this.maxHourlyConsumption = maxHourlyConsumption;
        this.description = description;
        this.address = address;
        this.measurements = new ArrayList<>();
    }

    public Device(UUID id, String name, Client client, Double maxHourlyConsumption,
                  String description, String address) {
        this(name, client, maxHourlyConsumption, description, address);
        this.id = id;
    }

    public List<Measurement> getMeasurements() {
        return Collections.unmodifiableList(measurements);
    }

    @Override
    public int compareTo(Device o) {
        return id.compareTo(o.id);
    }
}
