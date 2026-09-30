package li.zhang.app.persistence.mapper;

import li.zhang.app.model.core.BaseDTOMapper;

import li.zhang.app.persistence.dto.core.TeamDTO;
import li.zhang.app.persistence.entity.core.Team;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMapper extends BaseDTOMapper<Team, TeamDTO> {
}
