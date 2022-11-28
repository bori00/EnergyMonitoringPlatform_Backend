package ro.tuc.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.tuc.common.entities.Device;
import ro.tuc.common.entities.Measurement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, String> {

    List<Measurement> findAllByDateTimeBetweenAndDeviceOrderByDateTime(LocalDateTime startDate,
                                                        LocalDateTime endDate,
                                                        Device device);

    List<Measurement> findAllByDateTimeBetweenAndDevice(LocalDateTime startDate,
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
