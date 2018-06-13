package pl.serwis.dao;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviceRowMapper implements RowMapper {
    public Device mapRow(ResultSet rs, int i) throws SQLException {
        return new Device(rs.getInt("id"), rs.getString("name"), rs.getInt("type"), rs.getBoolean("inuse"), rs.getInt("department"));
    }
}