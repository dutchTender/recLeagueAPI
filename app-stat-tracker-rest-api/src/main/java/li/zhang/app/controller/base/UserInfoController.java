package li.zhang.app.controller.base;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import li.zhang.app.model.base.AbstractAPIResponse;
import li.zhang.app.model.base.AbstractController;
import li.zhang.app.model.base.AbstractRestMetaData;
import li.zhang.app.model.base.AbstractRestResponse;
import li.zhang.app.model.constants.QueryConstants;
import li.zhang.app.model.core.BaseService;
import li.zhang.app.persistence.dto.base.UserInfoDTO;
import li.zhang.app.persistence.entity.base.UserInfo;
import li.zhang.app.persistence.mapper.UserInfoMapper;
import li.zhang.app.services.base.UserInfoService;
import li.zhang.app.utils.constants.RestParams;
import li.zhang.app.utils.constants.RestResponseMessage;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        return service;
    }

    @GetMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE, QueryConstants.SORT_BY })
    public ResponseEntity<AbstractRestResponse<List<UserInfoDTO>>> findAllUserInfoPaginatedAndSorted(@RequestParam(value = QueryConstants.PAGE) final int page,
                                                                                                  @RequestParam(value = QueryConstants.SIZE) final int size,
                                                                                                  @RequestParam(value = QueryConstants.SORT_BY) final String sortBy,
                                                                                                  @RequestParam(value = QueryConstants.SORT_ORDER) final String sortOrder) {
        Page<UserInfoDTO> resultPage = this.service.findAllPaginatedAndSorted(page, size, sortBy, sortOrder);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.USER_ENTITY_PATH, "params: sort by - {" +sortBy+" }" + " sort order - { "+sortOrder+" }  page - {"+page+"}  size - {"+size+"} total USERS : "+resultPage.getTotalPages()*resultPage.getContent().size());
        return apiResponseCollection.createAPIResponse(resultPage.getContent() , metaData, RestResponseMessage.USERS_GET_SUCCESS, RestParams.API_STATUS_OK);
    }

    @GetMapping()
    public ResponseEntity<AbstractRestResponse<List<UserInfoDTO>>> findAllUserInfo(final HttpServletRequest request) {
        List<UserInfoDTO> resultList = this.service.findAll();
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.USER_ENTITY_PATH, "params: find all USER - count : "+resultList.size());
        return apiResponseCollection.createAPIResponse(resultList , metaData, RestResponseMessage.USERS_GET_SUCCESS, RestParams.API_STATUS_OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AbstractRestResponse<UserInfoDTO>> findOneUserInfo(@PathVariable("id") final Long id) {
        UserInfoDTO result = service.find(id);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.USER_ENTITY_PATH, "params: find one USER - count : 1 ");
        return apiResponseSingleton.createAPIResponse(result , metaData, RestResponseMessage.USER_GET_SUCCESS,RestParams.API_STATUS_OK);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<AbstractRestResponse<UserInfoDTO>> findOneUserByName(@PathVariable("name") final String name) {
        UserInfoDTO result = service.findByUserName(name);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.USER_ENTITY_PATH, "params: find one USER - count : 1 ");
        return apiResponseSingleton.createAPIResponse(result , metaData, RestResponseMessage.USER_GET_SUCCESS,RestParams.API_STATUS_OK);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AbstractRestResponse<UserInfoDTO>> createUser(@RequestBody @Valid final UserInfoDTO dto) {
        UserInfo result = service.create(mapper.toEntity(dto));
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.USER_ENTITY_PATH, "params: create USER - count : 1  ");
        return apiResponseSingleton.createAPIResponse(mapper.toDTO(result) , metaData, RestResponseMessage.USER_CREATE_SUCCESS,String.valueOf(HttpStatus.CREATED));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AbstractRestResponse<UserInfoDTO>> updateUser(@PathVariable("id") final Long id, @RequestBody @Valid UserInfoDTO dto) {
         UserInfo result = service.update(mapper.toEntity(dto));
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.USER_ENTITY_PATH, "params: update USER - count : 1  ");
        return apiResponseSingleton.createAPIResponse(mapper.toDTO(result) , metaData, RestResponseMessage.USER_UPDATE_SUCCESS, String.valueOf(HttpStatus.OK));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<AbstractRestResponse<UserInfoDTO>> delete(@PathVariable("id") final Long id) {
        this.service.deleteById(id);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.USER_ENTITY_PATH, "params: delete PLAYER - count : 1  ");
        return apiResponseSingleton.createAPIResponse(null , metaData, RestResponseMessage.USER_DELETE_SUCCESS, String.valueOf(HttpStatus.NO_CONTENT));
    }



}
