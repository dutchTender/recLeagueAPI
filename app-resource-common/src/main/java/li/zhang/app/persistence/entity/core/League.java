package li.zhang.app.persistence.entity.core;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import li.zhang.app.model.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "League")
@Getter
@Setter
public class League  implements BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String  leagueName;
    private String  leagueType;
    private String  leagueDescription;
    private String  leagueRules;
    private Integer TeamRegistrationFees;
    @OneToMany(mappedBy = "league")
    Set<Team> teams = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        League league = (League) o;
        return Objects.equals(id, league.id) && Objects.equals(leagueName, league.leagueName) && Objects.equals(leagueType, league.leagueType) && Objects.equals(leagueDescription, league.leagueDescription) && Objects.equals(leagueRules, league.leagueRules) && Objects.equals(TeamRegistrationFees, league.TeamRegistrationFees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, leagueName, leagueType, leagueDescription, leagueRules, TeamRegistrationFees);
    }
}
