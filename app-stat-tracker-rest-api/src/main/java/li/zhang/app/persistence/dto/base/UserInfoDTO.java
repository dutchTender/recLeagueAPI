package li.zhang.app.persistence.dto.base;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({ "id", "userName", "firstName", "lastName", "gender","height","weight","age","email" })
public class UserInfoDTO {
    Long id;
    String userName;
    String firstName;
    String lastName;
    String gender;
    Integer height;
    Integer weight;
    Integer age;
    String email;


}

