package li.zhang.app_stat_tracker_rest_api.persistence.dto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({ "id", "userName", "firstName", "lastName", "email", "phone", "sex", "team", "gameStats", "seasonStats" })
public class PlayerDTO {
    Long id;
    String userName;
    String firstName;
    String lastName;
    String email;
    String phone;
    String sex;
    TeamDTO team;
    PlayerStatsDTO gameStats = new PlayerStatsDTO();
    Set<PlayerStatsDTO> seasonStats = new HashSet<>();

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
    public PlayerDTO(Long id, String userName, String firstName, String lastName, String email, String phone, String sex, TeamDTO team, PlayerStatsDTO gameStats) {
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
    public PlayerDTO(Long id, String userName, String firstName, String lastName, String email, String phone, String sex, TeamDTO team, Set<PlayerStatsDTO> seasonStats) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.team = team;
        this.seasonStats = seasonStats;
    }
    public PlayerDTO(Long id, String userName, String lastName, String firstName, String email, String phone, String sex, PlayerStatsDTO gameStats) {
        this.id = id;
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.gameStats = gameStats;
    }

    public void addPlayerSeasonStats(PlayerStatsDTO playerStats) {
        this.seasonStats.add(playerStats);
    }
    public void removePlayerStats(PlayerStatsDTO playerStats) {
        this.seasonStats.remove(playerStats);
    }
}
