package pl.serwis.db;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.serwis.dao.Device;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class JpaDeviceRepository implements Database{
    @PersistenceUnit
    private EntityManagerFactory em;

    @Override
    public List<Device> getAllDevices() {
        return null;
    }

    @Override
    public List<Device> getAllDevices2() {
        List<Device> devices = new ArrayList<>();
        em.createEntityManager().persist(new Device(null,"nowe",3,false,33));

        return null;
    }

    @Override
    public Device getDevice(Integer id) {
        return null;
    }
}
