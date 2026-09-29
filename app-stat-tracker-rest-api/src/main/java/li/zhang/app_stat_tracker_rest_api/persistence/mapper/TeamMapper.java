package li.zhang.app_stat_tracker_rest_api.persistence.mapper;

import li.zhang.app_stat_tracker_rest_api.model.base.BaseDTOMapper;

import li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.core.Team;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMapper extends BaseDTOMapper<Team, TeamDTO> {
}
