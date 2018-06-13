package pl.serwis.serwis;

import pl.serwis.dao.Device;

import java.util.List;

public interface Serwis {
    List<Device> getAllDevices();
    Device getDevice(Integer id);
}
