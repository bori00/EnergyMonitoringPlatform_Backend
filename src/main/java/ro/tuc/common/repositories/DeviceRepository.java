package ro.tuc.common.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.tuc.common.entities.Client;
import ro.tuc.common.entities.Device;

import java.util.ArrayList;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    ArrayList<Device> findAllByClient(Client client);
}
