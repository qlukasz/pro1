package pl.serwis.db;

import pl.serwis.dao.Device;

import java.util.List;

public interface Database {
    List<Device> getAllDevices();
    List<Device> getAllDevices2();
    Device getDevice(Integer id);
}
