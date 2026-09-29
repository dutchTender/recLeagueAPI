package li.zhang.app_stat_tracker_rest_api.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractAPIResponse;
import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractController;
import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractRestMetaData;
import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractRestResponse;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseService;
import li.zhang.app_stat_tracker_rest_api.model.constants.QueryConstants;
import li.zhang.app_stat_tracker_rest_api.persistence.dto.core.PlayerDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.core.Player;
import li.zhang.app_stat_tracker_rest_api.persistence.mapper.PlayerMapper;
import li.zhang.app_stat_tracker_rest_api.services.core.PlayerService;
import li.zhang.app_stat_tracker_rest_api.utils.constants.RestParams;
import li.zhang.app_stat_tracker_rest_api.utils.constants.RestResponseMessage;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = RestParams.PLAYER_ENTITY_PATH)
@CrossOrigin(origins = RestParams.API_CLIENT_URL)
public class PlayerController extends AbstractController<Player, PlayerDTO> {


    private final PlayerService service;
    private final PlayerMapper mapper;
    private final AbstractAPIResponse<List<PlayerDTO>> apiResponseCollection = new AbstractAPIResponse<>();
    private final AbstractAPIResponse<PlayerDTO> apiResponseSingleton = new AbstractAPIResponse<>();

    public PlayerController(PlayerService service, PlayerMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    protected BaseService<Player, PlayerDTO> getService() {
        return service;
    }

    @GetMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE, QueryConstants.SORT_BY })
    public
    ResponseEntity<AbstractRestResponse<List<PlayerDTO>>> findAllPlayersPaginatedAndSorted(@RequestParam(value = QueryConstants.PAGE) final int page,
                                                                                                     @RequestParam(value = QueryConstants.SIZE) final int size,
                                                                                                     @RequestParam(value = QueryConstants.SORT_BY) final String sortBy,
                                                                                                     @RequestParam(value = QueryConstants.SORT_ORDER) final String sortOrder) {
        Page<PlayerDTO> playersResultPage = this.service.findAllPaginatedAndSorted(page, size, sortBy, sortOrder);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.PLAYER_ENTITY_PATH, "params: sort by - {" +sortBy+" }" + " sort order - { "+sortOrder+" }  page - {"+page+"}  size - {"+size+"} total players : "+playersResultPage.getTotalPages()*playersResultPage.getContent().size());
        return apiResponseCollection.createAPIResponse(playersResultPage.getContent() , metaData, RestResponseMessage.PLAYERS_GET_SUCCESS, RestParams.API_STATUS_OK);
    }

    @GetMapping()
    public ResponseEntity<AbstractRestResponse<List<PlayerDTO>>> findAllPlayers(final HttpServletRequest request) {
        List<PlayerDTO> playersResultList = this.service.findAll();
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.PLAYER_ENTITY_PATH, "params: find all PLAYER - count : "+playersResultList.size());
        return apiResponseCollection.createAPIResponse(playersResultList , metaData, RestResponseMessage.PLAYERS_GET_SUCCESS, RestParams.API_STATUS_OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<AbstractRestResponse<PlayerDTO>> findOnePlayer(@PathVariable("id") final Long id) {
        PlayerDTO playerResult = service.find(id);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.PLAYER_ENTITY_PATH, "params: find one PLAYER - count : 1 ");
        return apiResponseSingleton.createAPIResponse(playerResult , metaData, RestResponseMessage.PLAYER_GET_SUCCESS,RestParams.API_STATUS_OK);
    }


    @GetMapping(value = "/name/{name}")
    public ResponseEntity<AbstractRestResponse<PlayerDTO>> findOnePlayerByName(@PathVariable("name") final String name) {
        PlayerDTO playerResult = service.findPlayerByName(name);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.PLAYER_ENTITY_PATH, "params: find one PLAYER - count : 1 ");
        return apiResponseSingleton.createAPIResponse(playerResult , metaData, RestResponseMessage.PLAYER_GET_SUCCESS,RestParams.API_STATUS_OK);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AbstractRestResponse<PlayerDTO>> createPlayer(@RequestBody @Valid final PlayerDTO dto) {
        Player playerResult = service.create(mapper.toEntity(dto));
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.PLAYER_ENTITY_PATH, "params: create PLAYER - count : 1  ");
        return apiResponseSingleton.createAPIResponse(mapper.toDTO(playerResult) , metaData, RestResponseMessage.PLAYER_CREATE_SUCCESS,String.valueOf(HttpStatus.CREATED));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AbstractRestResponse<PlayerDTO>> updatePlayer(@PathVariable("id") final Long id, @RequestBody @Valid PlayerDTO dto) {
        Player playerResult = service.update(mapper.toEntity(dto));
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.PLAYER_ENTITY_PATH, "params: update PLAYER - count : 1  ");
        return apiResponseSingleton.createAPIResponse(mapper.toDTO(playerResult) , metaData, RestResponseMessage.PLAYER_UPDATE_SUCCESS, String.valueOf(HttpStatus.OK));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<AbstractRestResponse<PlayerDTO>> delete(@PathVariable("id") final Long id) {
        this.service.deleteById(id);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.PLAYER_ENTITY_PATH, "params: delete PLAYER - count : 1  ");
        return apiResponseSingleton.createAPIResponse(null , metaData, RestResponseMessage.PLAYER_DELETE_SUCCESS, String.valueOf(HttpStatus.NO_CONTENT));
    }

}
