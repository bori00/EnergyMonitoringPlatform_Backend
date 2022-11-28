package ro.tuc.common.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Measurement {

    @Id
    @Column(columnDefinition = "uniqueidentifier")
    @GenericGenerator(name = "generator", strategy = "guid")
    @GeneratedValue(generator = "generator")
    private String id;

    @Column(name = "datetime", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "energy_consumption", nullable = false)
    private Double energyConsumption;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    private Device device;

    public Measurement(LocalDateTime dateTime, Double energyConsumption, Device device) {
        this.dateTime = dateTime;
        this.energyConsumption = energyConsumption;
        this.device = device;
    }

    public void increaseEnergyConsumption(Double value) {
        energyConsumption += value;
    }
}
