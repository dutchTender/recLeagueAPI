package li.zhang.app.persistence.entity.core;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import li.zhang.app.model.core.BaseEntity;
import li.zhang.app.persistence.entity.base.UserInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "Players")
@Getter
@Setter
public class Player implements BaseEntity{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Player(UserInfo userInfo) {
       this.user =  userInfo;
    }
    public Player() {
    }
    private String position;
    private Integer number;
    private boolean isCaptain = false;
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserInfo user;
    @OneToMany(mappedBy = "player" , cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PlayerStats> playerStats;
    public void addPlayerStats(PlayerStats playerStats) {
        this.playerStats.add(playerStats);
    }
    public void removePlayerStats(PlayerStats playerStats) {
        this.playerStats.remove(playerStats);
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) && Objects.equals(position, player.position) && Objects.equals(number, player.number) && Objects.equals(team, player.team) && Objects.equals(user, player.user) && Objects.equals(playerStats, player.playerStats);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, position, number, team, user, playerStats);
    }
}
