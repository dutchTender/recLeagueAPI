package li.zhang.app.persistence.dto.base;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({ "id", "userName", "passWord", "role", "firstName", "lastName", "gender","height","weight","age","email" })
public class UserInfoDTO {
    Long id;
    String userName;
    String passWord;
    String role;
    String email;
    String firstName;
    String lastName;

    String billingAddress;
    String phone;
    String address;
    Integer age;
    String gender;
    Integer height;
    Integer weight;


    public UserInfoDTO(Long id, String userName, String firstName, String lastName, String gender, Integer height, Integer weight, Integer age, String email) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.email = email;
    }


}

