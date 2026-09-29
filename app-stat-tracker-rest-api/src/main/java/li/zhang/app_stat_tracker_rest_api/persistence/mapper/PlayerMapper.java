package li.zhang.app_stat_tracker_rest_api.persistence.mapper;

import li.zhang.app_stat_tracker_rest_api.model.base.BaseDTOMapper;
import li.zhang.app_stat_tracker_rest_api.persistence.dto.core.PlayerDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.core.Player;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlayerMapper extends BaseDTOMapper<Player, PlayerDTO> {
}