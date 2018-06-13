package pl.serwis.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    Integer id;
    String name;
    Integer type;
    boolean inUse;
    Integer department;
    public Device() {
        this.name = "Figa";
        System.out.println("---------------------------Creating Device");
    }
}