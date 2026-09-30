package li.zhang.app.persistence.dto.core;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import li.zhang.app.persistence.dto.base.UserInfoDTO;
import lombok.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter @JsonPropertyOrder({ "id", "position", "number", "isCaptain", "team", "gameStats", "seasonStats" })
public class PlayerDTO {
    Long id;
    String position;
    Integer number;
    UserInfoDTO user;
    TeamDTO team;
    PlayerStatsDTO gameStats;
    Set<PlayerStatsDTO> seasonStats = new HashSet<>();


    public void addPlayerSeasonStats(PlayerStatsDTO playerStats) {
        this.seasonStats.add(playerStats);
    }

    public void removePlayerStats(PlayerStatsDTO playerStats) {
        this.seasonStats.remove(playerStats);
    }

    public PlayerDTO(Long id, String position, Integer number, UserInfoDTO user, TeamDTO team, PlayerStatsDTO gameStats) {
        this.id = id;
        this.position = position;
        this.number = number;
        this.user = user;
        this.team = team;
        this.gameStats = gameStats;
    }

    public PlayerDTO(Long id, String position, Integer number, UserInfoDTO user, TeamDTO team, Set<PlayerStatsDTO> seasonStats) {
        this.id = id;
        this.position = position;
        this.number = number;
        this.user = user;
        this.team = team;
        this.seasonStats = seasonStats;
    }

    public PlayerDTO(Long id, String position, Integer number, UserInfoDTO user, PlayerStatsDTO gameStats) {
        this.id = id;
        this.position = position;
        this.number = number;
        this.user = user;
        this.gameStats = gameStats;
    }

    public PlayerDTO(UserInfoDTO user, TeamDTO team, PlayerStatsDTO gameStats) {
        this.user = user;
        this.team = team;
        this.gameStats = gameStats;
    }

    public PlayerDTO(UserInfoDTO user, TeamDTO team) {
        this.user = user;
        this.team = team;
    }
}
