package li.zhang.app_stat_tracker_rest_api.persistence.entity.core;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "Team")
@Getter
@Setter
public class Team implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Team() {
    }
    public Team(String teamName) {
        this.teamName = teamName;
    }

    public String teamName;
    public String teamCoachName;
    public String teamSponsors;

    @OneToMany(mappedBy = "homeTeam")
    private Set<Game> homeGames = new HashSet<>();

    @OneToMany(mappedBy = "awayTeam")
    private Set<Game> awayGames = new HashSet<>();

    @OneToMany(mappedBy = "team")
    private Set<Player> players = new HashSet<>();

    public void addPlayer(Player player){
        this.players.add(player);
        player.setTeam(this);
    }
    public void removePlayer(Player player){
        this.players.remove(player);
        player.setTeam(null);
    }
    public void addHomeGame(Game game){
        this.homeGames.add(game);
    }
    public void removeHomeGame(Game game){
        this.homeGames.remove(game);
    }
    public void addAwayGame(Game game){
        this.awayGames.add(game);
    }
    public void removeAwayGame(Game game){
        this.awayGames.remove(game);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) && Objects.equals(teamName, team.teamName) && Objects.equals(teamCoachName, team.teamCoachName) && Objects.equals(teamSponsors, team.teamSponsors) && Objects.equals(homeGames, team.homeGames) && Objects.equals(awayGames, team.awayGames) && Objects.equals(players, team.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamName, teamCoachName, teamSponsors, homeGames, awayGames, players);
    }
}

