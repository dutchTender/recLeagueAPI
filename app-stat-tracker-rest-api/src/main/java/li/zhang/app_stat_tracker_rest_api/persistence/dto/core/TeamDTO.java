package li.zhang.app_stat_tracker_rest_api.persistence.dto.core;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({ "id", "teamName", "teamCoachName", "teamSponsors", "homeGames", "awayGames", "players" })
public class TeamDTO {
    Long id;
    String teamName;
    String teamCoachName;
    String teamSponsors;
    Set<GameDTO> homeGames = new HashSet<>();
    Set<GameDTO> awayGames = new HashSet<>();
    Set<PlayerDTO> players = new HashSet<>();

    public TeamDTO(Long id, String teamName, String teamCoachName, String teamSponsors, GameDTO homeGame, GameDTO awayGame) {
        this.id = id;
        this.teamName = teamName;
        this.teamCoachName = teamCoachName;
        this.teamSponsors = teamSponsors;
        this.homeGames.add(homeGame);
        this.awayGames.add(awayGame);
    }
    public TeamDTO(Long id, String teamName, String teamCoachName, String teamSponsors, GameDTO homeGame, GameDTO awayGame, PlayerDTO player) {
        this.id = id;
        this.teamName = teamName;
        this.teamCoachName = teamCoachName;
        this.teamSponsors = teamSponsors;
        this.homeGames.add(homeGame);
        this.awayGames.add(awayGame);
        this.players.add(player);
    }
    public TeamDTO(Long id, String teamName, String teamCoachName, String teamSponsors, PlayerDTO player) {
        this.id = id;
        this.teamName = teamName;
        this.teamCoachName = teamCoachName;
        this.teamSponsors = teamSponsors;
        this.players.add(player);
    }
    public TeamDTO(Long id, String teamName, String teamCoachName, String teamSponsors) {
        this.id = id;
        this.teamName = teamName;
        this.teamCoachName = teamCoachName;
        this.teamSponsors = teamSponsors;
    }

    public void addPlayer(PlayerDTO playerDTO) {
        players.add(playerDTO);
    }
    public void removePlayer(PlayerDTO playerDTO) {
        players.remove(playerDTO);
    }
    public void addHomeGame(GameDTO gameDTO) {
        homeGames.add(gameDTO);
    }
    public GameDTO removeHomeGame(GameDTO gameDTO) {
        homeGames.remove(gameDTO);
        return gameDTO;
    }
    public void addAwayGame(GameDTO gameDTO) {
        awayGames.add(gameDTO);
    }
    public GameDTO removeAwayGame(GameDTO gameDTO) {
        awayGames.remove(gameDTO);
        return gameDTO;
    }


}
