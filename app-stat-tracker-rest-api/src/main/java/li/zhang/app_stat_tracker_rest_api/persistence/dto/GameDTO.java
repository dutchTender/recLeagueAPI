package li.zhang.app_stat_tracker_rest_api.persistence.dto;


import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getGameDate() {
        return gameDate;
    }

    public void setGameDate(String gameDate) {
        this.gameDate = gameDate;
    }

    public String getGameTime() {
        return gameTime;
    }

    public void setGameTime(String gameTime) {
        this.gameTime = gameTime;
    }

    public String getGameLocation() {
        return gameLocation;
    }

    public void setGameLocation(String gameLocation) {
        this.gameLocation = gameLocation;
    }

    public TeamDTO getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(TeamDTO homeTeam) {
        this.homeTeam = homeTeam;
    }

    public TeamDTO getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(TeamDTO awayTeam) {
        this.awayTeam = awayTeam;
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
