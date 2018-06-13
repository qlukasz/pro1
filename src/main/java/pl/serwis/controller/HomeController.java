package pl.serwis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.serwis.dao.Device;
import pl.serwis.serwis.Serwis;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {

    @Autowired
    Serwis serwis;

    @RequestMapping("/")
    public String pusty(Model model) {
        return index(model);
    }

    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(Model model) {
        return "index";
    }

    @RequestMapping("/devices")
    public String devices(Model model) {
        List<Device> devices = serwis.getAllDevices();
        model.addAttribute("devices", devices);
        return "devices";
    }

    @RequestMapping("/db")
    public String db(Model model) {
//        ArrayList<String> users = new ArrayList<String>();
//        try {
//            Connection conn = ds.getConnection();
//            PreparedStatement ps = conn.prepareStatement("SELECT id, first_name, last_name FROM cwm.users");
//            ResultSet rs = ps.executeQuery();
//            String date1;
//            while (rs.next()) {
//                date1 = rs.getString(2) + " " + rs.getString(3);
//                System.out.println(date1);
//                users.add(date1);
//            }
//            conn.close();
//            ps.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        model.addAttribute("users", users);
        return "smieci/users";
    }
}
