package ro.tuc.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.tuc.webapp.entities.Client;
import ro.tuc.webapp.entities.Device;

import java.util.ArrayList;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    ArrayList<Device> findAllByClient(Client client);
}
