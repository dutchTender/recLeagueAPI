package li.zhang.app.persistence.mapper;

import li.zhang.app.model.core.BaseDTOMapper;
import li.zhang.app.persistence.dto.core.PlayerStatsDTO;
import li.zhang.app.persistence.entity.core.PlayerStats;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlayerStatsMapper extends BaseDTOMapper<PlayerStats, PlayerStatsDTO> {
}
