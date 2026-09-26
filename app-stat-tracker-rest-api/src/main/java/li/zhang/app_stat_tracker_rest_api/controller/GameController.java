package li.zhang.app_stat_tracker_rest_api.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractAPIResponse;
import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractController;
import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractRestMetaData;
import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractRestResponse;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseService;
import li.zhang.app_stat_tracker_rest_api.model.constants.QueryConstants;
import li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Game;
import li.zhang.app_stat_tracker_rest_api.persistence.mapper.GameMapper;
import li.zhang.app_stat_tracker_rest_api.services.core.GameService;
import li.zhang.app_stat_tracker_rest_api.utils.constants.RestParams;
import li.zhang.app_stat_tracker_rest_api.utils.constants.RestResponseMessage;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = RestParams.GAME_ENTITY_PATH)
@CrossOrigin(origins = RestParams.API_CLIENT_URL)
public class GameController extends AbstractController<Game, GameDTO> {

    private final GameService service;
    private final GameMapper mapper;
    private final AbstractAPIResponse<List<GameDTO>> apiResponseCollection = new AbstractAPIResponse<>();
    private final AbstractAPIResponse<GameDTO> apiResponseSingleton = new AbstractAPIResponse<>();

    public GameController(GameService service, GameMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    protected BaseService<Game, GameDTO> getService() {
        return this.service;
    }

    @GetMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE, QueryConstants.SORT_BY })
    public ResponseEntity<AbstractRestResponse<List<GameDTO>>> findAllGamesPaginatedAndSorted(@RequestParam(value = QueryConstants.PAGE) final int page,
                                                                                                  @RequestParam(value = QueryConstants.SIZE) final int size,
                                                                                                  @RequestParam(value = QueryConstants.SORT_BY) final String sortBy,
                                                                                                  @RequestParam(value = QueryConstants.SORT_ORDER) final String sortOrder) {
        Page<GameDTO> gamesResultPage = this.service.findAllPaginatedAndSorted(page, size, sortBy, sortOrder);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.GAME_ENTITY_PATH, "params: sort by - {" +sortBy+" }" + " sort order - { "+sortOrder+" }  page - {"+page+"}  size - {"+size+"} total players : "+gamesResultPage.getTotalPages()*gamesResultPage.getContent().size());
        return apiResponseCollection.createAPIResponse(gamesResultPage.getContent() , metaData, RestResponseMessage.GAMES_GET_SUCCESS, RestParams.API_STATUS_OK);
    }

    @GetMapping()
    public ResponseEntity<AbstractRestResponse<List<GameDTO>>> findAllGames(final HttpServletRequest request) {
        List<GameDTO> gamesResultList = this.service.findAll();
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.GAME_ENTITY_PATH, "params: find all GAMES - count : "+gamesResultList.size());
        return apiResponseCollection.createAPIResponse(gamesResultList , metaData, RestResponseMessage.GAMES_GET_SUCCESS, RestParams.API_STATUS_OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AbstractRestResponse<GameDTO>> findOneGame(@PathVariable("id") final Long id) {
        GameDTO gameResult = service.find(id);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.GAME_ENTITY_PATH, "params: find one GAME - count : 1 ");
        return apiResponseSingleton.createAPIResponse(gameResult , metaData, RestResponseMessage.GAME_GET_SUCCESS,RestParams.API_STATUS_OK);
    }

    @GetMapping(value = "/time/{gameTime}")
    public ResponseEntity<AbstractRestResponse<GameDTO>> findOneGameByGameTime(@PathVariable("gameTime") final String gameTime) {
        GameDTO gameResult = service.findGameByGameTime(gameTime);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.GAME_ENTITY_PATH, "params: find one GAME - count : 1 ");
        return apiResponseSingleton.createAPIResponse(gameResult , metaData, RestResponseMessage.GAME_GET_SUCCESS,RestParams.API_STATUS_OK);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AbstractRestResponse<GameDTO>> createGame(@RequestBody @Valid final GameDTO dto) {
        Game gameResult = service.create(mapper.toEntity(dto));
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.GAME_ENTITY_PATH, "params: create GAME - count : 1  ");
        return apiResponseSingleton.createAPIResponse(mapper.toDTO(gameResult) , metaData, RestResponseMessage.GAME_CREATE_SUCCESS,String.valueOf(HttpStatus.CREATED));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AbstractRestResponse<GameDTO>> updateGame(@PathVariable("id") final Long id, @RequestBody @Valid GameDTO dto) {
        Game gameResult = service.update(mapper.toEntity(dto));
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.GAME_ENTITY_PATH, "params: update GAME - count : 1  ");
        return apiResponseSingleton.createAPIResponse(mapper.toDTO(gameResult) , metaData, RestResponseMessage.GAME_UPDATE_SUCCESS, String.valueOf(HttpStatus.OK));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<AbstractRestResponse<GameDTO>> delete(@PathVariable("id") final Long id) {
        this.service.deleteById(id);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.GAME_ENTITY_PATH, "params: delete GAME - count : 1  ");
        return apiResponseSingleton.createAPIResponse(null , metaData, RestResponseMessage.GAME_DELETE_SUCCESS, String.valueOf(HttpStatus.NO_CONTENT));
    }



}
