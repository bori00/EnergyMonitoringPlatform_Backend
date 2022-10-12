package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Measurement {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "datetime", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "energy_consumption", nullable = false)
    private Double energyConsumption;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    private Device device;
}
