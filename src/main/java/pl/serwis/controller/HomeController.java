package pl.serwis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.serwis.User;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@Controller
public class HomeController {
    @Autowired
    DataSource ds;
    @Autowired
    JdbcTemplate jt;

    @RequestMapping("/db")
    public String db(Model model) {
        ArrayList<String> users = new ArrayList<String>();
        try {
            Connection conn = ds.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT id, first_name, last_name FROM cwm.users");
            ResultSet rs = ps.executeQuery();
            String date1;
            while (rs.next()) {
                date1 = rs.getString(2) + " " + rs.getString(3);
                System.out.println(date1);
                users.add(date1);
            }
            conn.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        model.addAttribute("users", users);
        return "users";
    }


    @RequestMapping("/")
    public String asdasd(Model model) {
        return user(model);
    }

    @RequestMapping("/user2")
    public String home22() {
        return "home";
    }

    @RequestMapping("/user")
    public String user(Model model) {
        User user = new User("a", "v", 10, "adam@gmail.com", 15558.3F);
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping("/user_save")
    public String user33(Model model, @Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("save: ERROR");
            model.addAttribute("siema", "chujowo : " + user.getEmail());
        } else {
            System.out.println("save:");
            model.addAttribute("siema", "zapisane: " + user.getEmail());
        }
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping("/test1")
    public String test1() {
        return "test1";
    }

    @RequestMapping("/test1/a")
    public String test33() {
        return "test1";
    }

    @RequestMapping("/test2")
    public String test2() {
        return "test2";
    }

    @RequestMapping("/login2")
    public String login() {
        return "login2";
    }

    @RequestMapping("/devices")
    public String devices(Model model) {
        return "devices";
    }
}
