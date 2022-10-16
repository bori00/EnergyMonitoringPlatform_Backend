package ro.tuc.ds2020.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ro.tuc.ds2020.entities.Device;
import ro.tuc.ds2020.entities.Measurement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

    List<Measurement> findAllByDateTimeBetweenAndDeviceOrderByDateTime(LocalDateTime startDate,
                                                        LocalDateTime endDate,
                                                        Device device);

    default List<Measurement> findAllByDateAndDeviceOrderByDateTime(LocalDate date, Device device) {
        return findAllByDateTimeBetweenAndDeviceOrderByDateTime(
                date.atStartOfDay(),
                date.atTime(23, 59, 59),
                device
        );
    }
}
