package li.zhang.app.controller.core;

import li.zhang.app.model.base.AbstractAPIResponse;
import li.zhang.app.model.base.AbstractController;
import li.zhang.app.model.base.AbstractRestMetaData;
import li.zhang.app.model.base.AbstractRestResponse;
import li.zhang.app.model.constants.QueryConstants;
import li.zhang.app.model.core.BaseService;
import li.zhang.app.persistence.dto.core.PlayerStatsDTO;
import li.zhang.app.persistence.entity.core.PlayerStats;
import li.zhang.app.persistence.mapper.PlayerStatsMapper;
import li.zhang.app.services.core.PlayerStatsService;
import li.zhang.app.utils.constants.RestParams;
import li.zhang.app.utils.constants.RestResponseMessage;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = RestParams.PLAYER_STATS_ENTITY_PATH)
@CrossOrigin(origins = RestParams.API_CLIENT_URL)
public class PlayerStatsController extends AbstractController<PlayerStats, PlayerStatsDTO> {

    private final PlayerStatsService service;
    private final PlayerStatsMapper mapper;
    private final AbstractAPIResponse<List<PlayerStatsDTO>> apiResponseCollection = new AbstractAPIResponse<>();
    private final AbstractAPIResponse<PlayerStatsDTO> apiResponseSingleton = new AbstractAPIResponse<>();

    public PlayerStatsController(final PlayerStatsService playerStatsService, PlayerStatsMapper mapper) {
        this.service = playerStatsService;
        this.mapper = mapper;
    }

    @Override
    protected BaseService<PlayerStats, PlayerStatsDTO> getService() {
        return service;
    }

    @GetMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE, QueryConstants.SORT_BY })
    public ResponseEntity<AbstractRestResponse<List<PlayerStatsDTO>>> findAllPlayersPaginatedAndSorted(@RequestParam(value = QueryConstants.PAGE) final int page,
                                                                                                  @RequestParam(value = QueryConstants.SIZE) final int size,
                                                                                                  @RequestParam(value = QueryConstants.SORT_BY) final String sortBy,
                                                                                                  @RequestParam(value = QueryConstants.SORT_ORDER) final String sortOrder) {
        Page<PlayerStatsDTO> resultPage = this.service.findAllPaginatedAndSorted(page, size, sortBy, sortOrder);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.PLAYER_STATS_ENTITY_PATH, "params: sort by - {" +sortBy+" }" + " sort order - { "+sortOrder+" }  page - {"+page+"}  size - {"+size+"} total players stats: "+resultPage.getTotalPages()*resultPage.getContent().size());
        return apiResponseCollection.createAPIResponse(resultPage.getContent() , metaData, RestResponseMessage.PLAYERS_STATS_GET_SUCCESS, RestParams.API_STATUS_OK);
    }
}
