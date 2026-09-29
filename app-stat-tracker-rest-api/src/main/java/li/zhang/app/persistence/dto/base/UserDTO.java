package li.zhang.app.persistence.dto.base;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({ "id", "userName", "firstName", "lastName", "email", "phone" })
public class UserDTO {
    Long id;
    String userName;
    String firstName;
    String lastName;
    String email;
    String phone;
}
