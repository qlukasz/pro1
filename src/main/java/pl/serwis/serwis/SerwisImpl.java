package pl.serwis.serwis;

import pl.serwis.dao.Device;
import pl.serwis.db.Database;

import java.util.List;

public class SerwisImpl implements Serwis{
    private Database database;
    public SerwisImpl(Database database){
        this.database = database;
    }

    public List<Device> getAllDevices() {
        return database.getAllDevices2();
    }

    public Device getDevice(Integer id) {
        return database.getDevice(id);
    }
}
