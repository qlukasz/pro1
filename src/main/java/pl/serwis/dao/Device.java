package pl.serwis.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.jdbc.core.RowMapper;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;


@Data
@AllArgsConstructor
@Entity
@Table(name="device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;
    String name;
    Integer type;
    boolean inUse;
    Integer department;
    public Device() {
        System.out.println("---------------------------Creating Device");
    }
}
