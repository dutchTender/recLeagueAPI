package li.zhang.app_stat_tracker_rest_api.persistence.entity.base;

import jakarta.persistence.*;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseEntity;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.core.Player;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


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
    String phone;
    String address;

    public UserInfo(String username) {
        this.username = username;
    }

    public UserInfo() {
    }

    @OneToMany(mappedBy = "user")
    private Set<Player> players = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(id, userInfo.id) && Objects.equals(username, userInfo.username) && Objects.equals(password, userInfo.password) && Objects.equals(email, userInfo.email) && Objects.equals(firstName, userInfo.firstName) && Objects.equals(lastName, userInfo.lastName) && Objects.equals(billingAddress, userInfo.billingAddress) && Objects.equals(phone, userInfo.phone) && Objects.equals(address, userInfo.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, firstName, lastName, billingAddress, phone, address);
    }
}
