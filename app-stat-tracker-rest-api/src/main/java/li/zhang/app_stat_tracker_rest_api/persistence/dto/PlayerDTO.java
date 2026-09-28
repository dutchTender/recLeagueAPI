package li.zhang.app_stat_tracker_rest_api.persistence.dto;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.PlayerStats;
import lombok.*;
import java.util.HashSet;
import java.util.Set;


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
    PlayerStats gameStats = new PlayerStats();
    Set<PlayerStats> seasonStats = new HashSet<>();

    public PlayerDTO(Long id, String userName, String firstName, String lastName, String email, String phone, String sex) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
    }

    public PlayerDTO(Long id, String userName, String firstName, String lastName, String phone, String email, String sex, TeamDTO team) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
        this.team = team;
    }

    public PlayerDTO(Long id, String userName, String firstName, String lastName, String email, String phone, String sex, TeamDTO team, PlayerStats gameStats) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.team = team;
        this.gameStats = gameStats;
    }

    public void addPlayerSeasonStats(PlayerStats playerStats) {
        this.seasonStats.add(playerStats);
    }
    public void removePlayerStats(PlayerStats playerStats) {
        this.seasonStats.remove(playerStats);
    }
}
