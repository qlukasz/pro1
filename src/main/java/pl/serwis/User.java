package pl.serwis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class User {
    @Size(min = 5, message = "za malo imie")
    String name;
    @Size(min = 5, message = "za malo nazwisko")
    String lastName;
    @Min(value = 18, message = "za malo lat")
    @Max(value = 100, message = "za duzo lat")
    Integer age;
    String email;
    Float salary;
}


