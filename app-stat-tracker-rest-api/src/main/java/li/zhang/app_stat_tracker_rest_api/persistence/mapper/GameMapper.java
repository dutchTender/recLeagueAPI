package li.zhang.app_stat_tracker_rest_api.persistence.mapper;

import li.zhang.app_stat_tracker_rest_api.model.base.BaseDTOMapper;
import li.zhang.app_stat_tracker_rest_api.persistence.dto.core.GameDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.core.Game;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GameMapper extends BaseDTOMapper<Game, GameDTO> {
}
