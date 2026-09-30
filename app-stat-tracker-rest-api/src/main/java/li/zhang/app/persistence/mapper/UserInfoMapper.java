package li.zhang.app.persistence.mapper;

import li.zhang.app.model.core.BaseDTOMapper;
import li.zhang.app.persistence.dto.base.UserInfoDTO;
import li.zhang.app.persistence.entity.base.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserInfoMapper extends BaseDTOMapper<UserInfo, UserInfoDTO> {
}
