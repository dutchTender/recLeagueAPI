package li.zhang.app.persistence.entity.core;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import li.zhang.app.model.base.BaseEntity;
import li.zhang.app.persistence.entity.base.UserInfo;
import lombok.Getter;
import lombok.Setter;
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
    private boolean isCaptain;

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


}
