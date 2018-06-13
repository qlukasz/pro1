package pl.serwis.db;

import org.springframework.jdbc.core.JdbcOperations;
import pl.serwis.dao.Device;
import pl.serwis.dao.DeviceRowMapper;

import java.util.List;

public class DatabaseJDBCTemplate implements Database{
    private JdbcOperations jdbcOperations;
    public DatabaseJDBCTemplate(JdbcOperations jdbcOperations){
        this.jdbcOperations = jdbcOperations;
    }

    public List<Device> getAllDevices() {
        final String SQL_GET_ALL_DEVICES = "Select * FROM rent.devices";
        List<Device> devices = jdbcOperations.query(SQL_GET_ALL_DEVICES, new DeviceRowMapper());
        return devices;
    }

    public List<Device> getAllDevices2() {
        final String SQL_GET_ALL_DEVICES = "Select * FROM rent.devices";
        List<Device> devices = jdbcOperations.query(SQL_GET_ALL_DEVICES, (rs, rowNum) -> {
            return new Device(rs.getInt("id"), rs.getString("name"), rs.getInt("type"), rs.getBoolean("inuse"), rs.getInt("department"));
        });
        return devices;
    }
    public Device getDevice(Integer id) {
        return null;
    }
}
