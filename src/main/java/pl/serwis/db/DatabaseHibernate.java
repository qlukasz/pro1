package pl.serwis.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.serwis.dao.Device;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHibernate implements Database{
    SessionFactory factory;
    public DatabaseHibernate(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Device> getAllDevices() {
        return null;
    }

    @Override
    public List<Device> getAllDevices2() {
        ArrayList<Device> devices = new ArrayList<>();
        System.out.println("---------------------------Executing getAllDevices2()");
        Session session = factory.openSession();
//        session.beginTransaction();
//        session.saveOrUpdate(new Device(null, "jeden", 2, false,3));
//        session.getTransaction().commit();
        devices.addAll(session.createCriteria(Device.class).list());
        session.close();
        return devices;
    }

    @Override
    public Device getDevice(Integer id) {
        return null;
    }


}
