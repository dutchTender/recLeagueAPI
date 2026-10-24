package li.zhang.app.persistence.dto.core;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({ "id", "points", "assists", "rebounds", "turnOvers" })
public class PlayerStatsDTO{
    Long id;
    Integer points;
    Integer assists;
    Integer rebounds;
    Integer turnOvers;

}
