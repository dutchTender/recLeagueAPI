package li.zhang.app_stat_tracker_rest_api.services.core;

import li.zhang.app_stat_tracker_rest_api.model.base.BaseService;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.TeamDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Team;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class TeamService implements BaseService<Team, TeamDTO> {

    private final TeamDAO teamRepository;
    private static final Logger logger = Logger.getLogger(TeamService.class.getName());

    public TeamService(TeamDAO teamRepository) {
        this.teamRepository = teamRepository;
    }
    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public TeamDTO find(Long id) {
        List<TeamDTO> rawDTOResult = teamRepository.findTeamById(id);
        logger.info(rawDTOResult.toString());
        return getTeamDTO(rawDTOResult);
    }

    public TeamDTO findByTeamName(String teamName) {
        List<TeamDTO> rawDTOResult = teamRepository.findTeamByTeamName(teamName);
        return getTeamDTO(rawDTOResult);
    }

    @NonNull
    private TeamDTO getTeamDTO(List<TeamDTO> rawDTOResult) {
        TeamDTO resultDTO = new TeamDTO();
        resultDTO.setTeamName(rawDTOResult.get(0).getTeamName());
        resultDTO.setId(rawDTOResult.get(0).getId());
        rawDTOResult.forEach(team -> {
            resultDTO.addHomeGame(team.getHomeGames().stream().findFirst().orElse(null));
            resultDTO.addAwayGame(team.getAwayGames().stream().findFirst().orElse(null));
            PlayerDTO playerDTO = team.getPlayers().stream().findFirst().orElse(null);
            assert playerDTO != null;
            // check if player already exist in result set.
            // if yes. that means there are additional matched game stats rows
            resultDTO.getPlayers().stream()
                    .filter(obj -> playerDTO.getId().equals(obj.getId()))
                    .findFirst()
                    .ifPresentOrElse(
                            matchedObj -> {
                                // Action A: Runs if the object exists
                                logger.info(matchedObj.toString());
                                matchedObj.addPlayerSeasonStats(playerDTO.getGameStats());
                            },
                            () -> {
                                // Action B: Runs if no matching object was found
                                playerDTO.addPlayerSeasonStats(playerDTO.getGameStats());
                                playerDTO.setGameStats(null);
                                resultDTO.addPlayer(playerDTO);
                            }
                    );
        });
        return resultDTO;
    }

    @Override
    public Team findByExample(Example<Team> example) {
        return  teamRepository.findTeamBy(example).orElse(null);
    }

    @Override
    public List<TeamDTO> findAll() {
        return teamRepository.findAllBy();
    }

    @Override
    public List<Team> findAllByExample(Example<Team> example) {
        return teamRepository.findAllBy(example);
    }

    @Override
    public Page<TeamDTO> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = Sort.Direction.fromString(sortOrder);
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        this.getLogger().log(Level.INFO, "findAllPaginatedAndSorted() params : - {}", pageable);
        return teamRepository.findAllBy(pageable);
    }

    @Override
    public Team create(Team entity) {
        return teamRepository.save(entity);
    }

    @Override
    public Team update(Team entity) {
        return teamRepository.save(entity);
    }

    @Override
    public void delete(Team entity) {
        teamRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
            teamRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
            teamRepository.deleteAll();
    }

    @Override
    public long count() {
        return teamRepository.count();
    }
}
