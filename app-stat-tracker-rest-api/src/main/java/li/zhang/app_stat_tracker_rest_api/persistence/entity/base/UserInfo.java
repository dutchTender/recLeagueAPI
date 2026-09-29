package li.zhang.app_stat_tracker_rest_api.persistence.entity.base;

import jakarta.persistence.*;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name="Users")
public class UserInfo implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String username;
    String password;
    String email;
    String firstName;
    String lastName;
    /*
    a player is created when a user registers for a league
    can be a free agent, does not need to have a team
     */
    String billingAddress;
    String phoneNumber;
    String address;



}
