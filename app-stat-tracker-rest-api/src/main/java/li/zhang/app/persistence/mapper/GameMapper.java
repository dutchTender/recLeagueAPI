package li.zhang.app.persistence.mapper;

import li.zhang.app.model.base.BaseDTOMapper;
import li.zhang.app.persistence.dto.core.GameDTO;
import li.zhang.app.persistence.entity.core.Game;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface GameMapper extends BaseDTOMapper<Game, GameDTO> {
}
