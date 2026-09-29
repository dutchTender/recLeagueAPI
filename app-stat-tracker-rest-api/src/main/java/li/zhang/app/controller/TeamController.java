package li.zhang.app.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import li.zhang.app.model.abs.AbstractAPIResponse;
import li.zhang.app.model.abs.AbstractController;
import li.zhang.app.model.abs.AbstractRestMetaData;
import li.zhang.app.model.abs.AbstractRestResponse;
import li.zhang.app.model.base.BaseService;
import li.zhang.app.model.constants.QueryConstants;
import li.zhang.app.persistence.dto.core.TeamDTO;
import li.zhang.app.persistence.entity.core.Team;
import li.zhang.app.persistence.mapper.TeamMapper;
import li.zhang.app.services.core.TeamService;
import li.zhang.app.utils.constants.RestParams;
import li.zhang.app.utils.constants.RestResponseMessage;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = RestParams.TEAM_ENTITY_PATH)
@CrossOrigin(origins = RestParams.API_CLIENT_URL)
public class TeamController extends AbstractController<Team, TeamDTO> {

    private final TeamService service;
    private final TeamMapper mapper;
    private final AbstractAPIResponse<List<TeamDTO>> apiResponseCollection = new AbstractAPIResponse<>();
    private final AbstractAPIResponse<TeamDTO> apiResponseSingleton = new AbstractAPIResponse<>();

    public TeamController(TeamService service, TeamMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    @Override
    protected BaseService<Team, TeamDTO> getService() {
        return service;
    }

    @GetMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE, QueryConstants.SORT_BY })
    public ResponseEntity<AbstractRestResponse<List<TeamDTO>>> findAllTeamsPaginatedAndSorted(@RequestParam(value = QueryConstants.PAGE) final int page,
                                                                                                        @RequestParam(value = QueryConstants.SIZE) final int size,
                                                                                                        @RequestParam(value = QueryConstants.SORT_BY) final String sortBy,
                                                                                                        @RequestParam(value = QueryConstants.SORT_ORDER) final String sortOrder) {
        Page<TeamDTO> teamResultPage = this.service.findAllPaginatedAndSorted(page, size, sortBy, sortOrder);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.TEAM_ENTITY_PATH, "params: sort by - {" +sortBy+" }" + " sort order - { "+sortOrder+" }  page - {"+page+"}  size - {"+size+"} total players : "+teamResultPage.getTotalPages()*teamResultPage.getContent().size());
        return apiResponseCollection.createAPIResponse(teamResultPage.getContent() , metaData, RestResponseMessage.TEAMS_GET_SUCCESS, RestParams.API_STATUS_OK);
    }

    @GetMapping()
    public ResponseEntity<AbstractRestResponse<List<TeamDTO>>> findAllTeams(final HttpServletRequest request) {
        List<TeamDTO> teamsResultList = this.service.findAll();
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.TEAM_ENTITY_PATH, "params: find all TEAM - count : "+teamsResultList.size());
        return apiResponseCollection.createAPIResponse(teamsResultList , metaData, RestResponseMessage.TEAMS_GET_SUCCESS, RestParams.API_STATUS_OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<AbstractRestResponse<TeamDTO>> findOneTeam(@PathVariable("id") final Long id) {
        TeamDTO teamResult = service.find(id);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.TEAM_ENTITY_PATH, "params: find one TEAM - count : 1 ");
        return apiResponseSingleton.createAPIResponse(teamResult , metaData, RestResponseMessage.TEAM_GET_SUCCESS,RestParams.API_STATUS_OK);
    }

    @GetMapping(value = "/name/{teamName}")
    public ResponseEntity<AbstractRestResponse<TeamDTO>> findOneTeamByNaME(@PathVariable("teamName") final String teamName) {
        TeamDTO teamResult = service.findByTeamName(teamName);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.TEAM_ENTITY_PATH, "params: find one TEAM - count : 1 ");
        return apiResponseSingleton.createAPIResponse(teamResult , metaData, RestResponseMessage.TEAM_GET_SUCCESS,RestParams.API_STATUS_OK);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AbstractRestResponse<TeamDTO>> createTeam(@RequestBody @Valid final TeamDTO dto) {
        Team teamResult = service.create(mapper.toEntity(dto));
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.TEAM_ENTITY_PATH, "params: create TEAM - count : 1  ");
        return apiResponseSingleton.createAPIResponse(mapper.toDTO(teamResult) , metaData, RestResponseMessage.TEAM_CREATE_SUCCESS,String.valueOf(HttpStatus.CREATED));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AbstractRestResponse<TeamDTO>> updateTeam(@PathVariable("id") final Long id, @RequestBody @Valid TeamDTO dto) {
        Team teamResult = service.update(mapper.toEntity(dto));
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.TEAM_ENTITY_PATH, "params: update TEAM - count : 1  ");
        return apiResponseSingleton.createAPIResponse(mapper.toDTO(teamResult) , metaData, RestResponseMessage.TEAM_UPDATE_SUCCESS, String.valueOf(HttpStatus.OK));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<AbstractRestResponse<TeamDTO>> delete(@PathVariable("id") final Long id) {
        this.service.deleteById(id);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.TEAM_ENTITY_PATH, "params: delete TEAM - count : 1  ");
        return apiResponseSingleton.createAPIResponse(null , metaData, RestResponseMessage.TEAM_DELETE_SUCCESS, String.valueOf(HttpStatus.NO_CONTENT));
    }

}
