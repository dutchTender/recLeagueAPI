package li.zhang.app_stat_tracker_rest_api.persistence.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
