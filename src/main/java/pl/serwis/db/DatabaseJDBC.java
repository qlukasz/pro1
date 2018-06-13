package pl.serwis.db;

import pl.serwis.dao.Device;

import javax.sql.DataSource;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseJDBC implements Database {
    @Override
    public List<Device> getAllDevices2() {
        return null;
    }

    private DataSource ds;


    public DatabaseJDBC(DataSource ds) {
        this.ds = ds;
    }

    public List<Device> getAllDevices() {
        final String SQL_GET_ALL_DEVICES = "Select id, name, type, inuse, department FROM rent.devices";
        List<Device> devices = new ArrayList<Device>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ds.getConnection();
            stmt = conn.prepareStatement(SQL_GET_ALL_DEVICES);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Device device = new Device();
                device.setId(rs.getInt(1));
                device.setName(rs.getString(2));
                device.setType(rs.getInt(3));
                device.setInUse(rs.getBoolean(4));
                device.setDepartment(rs.getInt(5));
                devices.add(device);
            }
            return devices;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {}
            }
            if (stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {}
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
        return null;
    }

    public Device getDevice(Integer id) {

        return null;
    }
}
