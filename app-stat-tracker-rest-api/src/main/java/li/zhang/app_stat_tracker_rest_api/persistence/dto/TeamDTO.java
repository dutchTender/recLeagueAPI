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

    public TeamDTO(Long id, String teamName, String teamCoachName, String teamSponsors, GameDTO homeGame) {
        this.id = id;
        this.teamName = teamName;
        this.teamCoachName = teamCoachName;
        this.teamSponsors = teamSponsors;
        this.homeGames.add(homeGame);
    }
}
