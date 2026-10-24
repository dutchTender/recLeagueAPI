package li.zhang.app.persistence.dto.core;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({ "id", "gameType", "gameDate", "gameTime", "gameLocation", "homeTeam", "awayTeam" })
public class GameDTO {
    Long id;
    String gameType;
    String gameDate;
    String gameTime;
    String gameLocation;
    TeamDTO homeTeam;
    TeamDTO awayTeam;

    public GameDTO(Long id, String gameType, String gameDate, String gameTime, String gameLocation) {
        this.id = id;
        this.gameType = gameType;
        this.gameDate = gameDate;
        this.gameTime = gameTime;
        this.gameLocation = gameLocation;
    }

    public void addHomeTeamPlayer(PlayerDTO player) {
        this.homeTeam.addPlayer(player);
    }
    public void removeHomeTeamPlayer(PlayerDTO player) {
        this.homeTeam.removePlayer(player);
    }
    public void addAwayTeamPlayer(PlayerDTO player) {
        this.awayTeam.addPlayer(player);
    }
    public void removeAwayTeamPlayer(PlayerDTO player) {
        this.awayTeam.removePlayer(player);
    }

}
