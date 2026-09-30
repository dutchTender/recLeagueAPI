package li.zhang.app.persistence.entity.base;

import jakarta.persistence.*;
import li.zhang.app.model.base.BaseEntity;
import li.zhang.app.persistence.entity.core.Player;
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
    public UserInfo(String username) {
        this.userName = username;
    }
    public UserInfo() {
    }
    @Column(unique = true)
    String userName;
    String password;
    @Column(unique = true)
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
    Integer age;
    String gender;
    Integer height;
    Integer weight;
    @OneToMany(mappedBy = "user")
    private Set<Player> players = new HashSet<>();
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(id, userInfo.id) && Objects.equals(userName, userInfo.userName) && Objects.equals(password, userInfo.password) && Objects.equals(email, userInfo.email) && Objects.equals(firstName, userInfo.firstName) && Objects.equals(lastName, userInfo.lastName) && Objects.equals(billingAddress, userInfo.billingAddress) && Objects.equals(phone, userInfo.phone) && Objects.equals(address, userInfo.address);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, email, firstName, lastName, billingAddress, phone, address);
    }
}
