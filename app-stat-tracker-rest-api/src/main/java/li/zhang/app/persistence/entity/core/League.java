package li.zhang.app.persistence.entity.core;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import li.zhang.app.model.core.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
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
    // not a traditional league like the nba where there are seasons
    // but rather a paid rec league or lifetime league where the league is time based or game based.   10 games ..etc
    @OneToMany(mappedBy = "league")
    Set<Team> teams = new HashSet<>();
    private String  leagueName;
    private String  leagueType;
    private String  leagueDescription;
    private String  leagueRules;
    private Integer TeamRegistrationFees;

}
