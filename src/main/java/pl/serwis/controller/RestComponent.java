package pl.serwis.controller;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.serwis.dao.Device;
import pl.serwis.dao.Simple;


@RestController
public class RestComponent {
//    @RequestMapping(value="/devices2", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value="/devices2")
    @ResponseBody
    public String df(){
//        Device device = new Device();
//        System.out.println("---name:");
//        System.out.println(device.getName());
//
//        JSONObject a = new JSONObject();
//        a.put("name", "Jan" );
//        a.put("lastName", "Kowalski");
//        HttpHeaders httpHeaders = new HttpHeaders();
////        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//        ResponseEntity<JSONObject> er = new ResponseEntity<>(a, HttpStatus.OK);
        return "abn";
    }
}
