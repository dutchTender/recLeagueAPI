package li.zhang.app.controller.base;

import li.zhang.app.model.base.AbstractAPIResponse;
import li.zhang.app.model.base.AbstractController;
import li.zhang.app.model.core.BaseService;
import li.zhang.app.persistence.dto.base.UserInfoDTO;
import li.zhang.app.persistence.entity.base.UserInfo;
import li.zhang.app.persistence.mapper.UserInfoMapper;
import li.zhang.app.services.base.UserInfoService;
import li.zhang.app.utils.constants.RestParams;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = RestParams.USER_ENTITY_PATH)
@CrossOrigin(origins = RestParams.API_CLIENT_URL)
public class UserInfoController extends AbstractController<UserInfo, UserInfoDTO> {

    private final UserInfoService service;
    private final UserInfoMapper mapper;
    private final AbstractAPIResponse<List<UserInfoDTO>> apiResponseCollection = new AbstractAPIResponse<>();
    private final AbstractAPIResponse<UserInfoDTO> apiResponseSingleton = new AbstractAPIResponse<>();

    public UserInfoController(UserInfoService service, UserInfoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    protected BaseService<UserInfo, UserInfoDTO> getService() {
        return null;
    }
}
