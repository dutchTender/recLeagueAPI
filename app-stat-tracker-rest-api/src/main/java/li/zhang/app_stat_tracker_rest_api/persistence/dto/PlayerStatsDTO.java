package li.zhang.app_stat_tracker_rest_api.persistence.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlayerStatsDTO{
    Long id;
    Integer points;
    Integer assists;
    Integer rebounds;
    Integer turnOvers;

}
