package li.zhang.app_stat_tracker_rest_api.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "PlayerStats")
@Getter
@Setter
public class PlayerStats implements  BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    public Player player;

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    public Game game;

    public Integer points;
    public Integer rebounds;
    public Integer assists;
    public Integer turnOvers;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PlayerStats that = (PlayerStats) o;
        return Objects.equals(id, that.id) && Objects.equals(player, that.player) && Objects.equals(game, that.game);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, player, game);
    }
}
