package li.zhang.app_stat_tracker_rest_api.persistence.dto;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerDTO {
    Long id;
    String userName;
    String firstName;
    String lastName;
    String email;
    String phone;
    String sex;
    TeamDTO team;

    public PlayerDTO(Long id, String userName, String firstName, String lastName, String email, String phone, String sex) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
    }
}
