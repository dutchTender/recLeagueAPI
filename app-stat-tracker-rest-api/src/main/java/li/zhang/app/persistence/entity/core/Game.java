package li.zhang.app.persistence.entity.core;
import jakarta.persistence.*;
import li.zhang.app.model.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "Game")
@Getter
@Setter
public class Game implements BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    public Game(String gameTime) {
        this.gameTime = gameTime;
    }
    public Game() {
    }
    public String gameType;
    public String gameDate;
    public String gameTime;
    public String gameLocation;
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    public Team homeTeam;
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    public Team awayTeam;
    @OneToMany(mappedBy = "game")
    private Set<PlayerStats> gameStats;
    private boolean completed = false;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id) && Objects.equals(gameTime, game.gameTime) && Objects.equals(gameLocation, game.gameLocation) && Objects.equals(homeTeam, game.homeTeam) && Objects.equals(awayTeam, game.awayTeam);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, gameTime, gameLocation, homeTeam, awayTeam);
    }
}
