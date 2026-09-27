package li.zhang.app_stat_tracker_rest_api.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public PlayerDTO addPlayer(PlayerDTO playerDTO) {
        players.add(playerDTO);
        return playerDTO;
    }
    public PlayerDTO removePlayer(PlayerDTO playerDTO) {
        players.remove(playerDTO);
        return playerDTO;
    }
    public GameDTO addHomeGame(GameDTO gameDTO) {
        homeGames.add(gameDTO);
        return gameDTO;
    }
    public GameDTO removeHomeGame(GameDTO gameDTO) {
        homeGames.remove(gameDTO);
        return gameDTO;
    }
    public GameDTO addAwayGame(GameDTO gameDTO) {
        awayGames.add(gameDTO);
        return gameDTO;
    }
    public GameDTO removeAwayGame(GameDTO gameDTO) {
        awayGames.remove(gameDTO);
        return gameDTO;
    }
}
