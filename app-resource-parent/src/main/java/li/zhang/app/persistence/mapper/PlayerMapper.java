package li.zhang.app.persistence.mapper;

import li.zhang.app.model.core.BaseDTOMapper;
import li.zhang.app.persistence.dto.core.PlayerDTO;
import li.zhang.app.persistence.entity.core.Player;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlayerMapper extends BaseDTOMapper<Player, PlayerDTO> {
}