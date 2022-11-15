package ro.tuc.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.tuc.webapp.entities.Device;
import ro.tuc.webapp.entities.Measurement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
