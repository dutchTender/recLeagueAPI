package li.zhang.app_stat_tracker_rest_api.services.core;

import li.zhang.app_stat_tracker_rest_api.model.base.BaseService;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.core.GameDAO;

import li.zhang.app_stat_tracker_rest_api.persistence.dto.core.GameDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.core.Game;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class GameService implements BaseService<Game, GameDTO> {

    private final GameDAO gameDAO;

    private static final Logger logger = Logger.getLogger(GameService.class.getName());

    public GameService(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public GameDTO find(Long id) {
        List<GameDTO> rawDTOResult = this.gameDAO.findGameById(id);
        return getGameDTO(rawDTOResult);
    }

    @Override
    public Game findByExample(Example<Game> example) {
        return this.gameDAO.findGameBy(example).orElse(null);
    }

    public GameDTO findGameByGameTime(String gameTime) {
        List<GameDTO> rawDTOResult = this.gameDAO.findGameByGameTime(gameTime);
        return getGameDTO(rawDTOResult);
    }

    @NonNull
    private GameDTO getGameDTO(List<GameDTO> rawDTOResult) {
        GameDTO resultDTO = new GameDTO();
        resultDTO.setId(rawDTOResult.get(0).getId());
        resultDTO.setGameDate(rawDTOResult.get(0).getGameDate());
        resultDTO.setGameTime(rawDTOResult.get(0).getGameTime());
        resultDTO.setGameLocation(rawDTOResult.get(0).getGameLocation());
        resultDTO.setHomeTeam(rawDTOResult.get(0).getHomeTeam());
        resultDTO.setAwayTeam(rawDTOResult.get(0).getAwayTeam());
        rawDTOResult.forEach(gameDTO -> {
            resultDTO.addHomeTeamPlayer(gameDTO.getHomeTeam().getPlayers().stream().findFirst().orElse(null));
            resultDTO.addAwayTeamPlayer(gameDTO.getAwayTeam().getPlayers().stream().findFirst().orElse(null));

        });
        return resultDTO;
    }

    @Override
    public List<GameDTO> findAll() {
        return this.gameDAO.findAllBy();
    }

    @Override
    public List<Game> findAllByExample(Example<Game> example) {
        return this.gameDAO.findAllBy(example);
    }

    @Override
    public Page<GameDTO> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = Sort.Direction.fromString(sortOrder);
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        this.getLogger().log(Level.INFO, "findAllPaginatedAndSorted() params : - {}", pageable);
        return this.gameDAO.findAllBy(pageable);
    }

    @Override
    public Game create(Game entity) {
       return this.gameDAO.save(entity);
    }

    @Override
    public Game update(Game entity) {

        return this.gameDAO.save(entity);
    }

    @Override
    public void delete(Game entity) {
            this.gameDAO.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
            this.gameDAO.deleteById(id);
    }

    @Override
    public void deleteAll() {
            this.gameDAO.deleteAll();
    }

    @Override
    public long count() {
        return this.gameDAO.count();
    }
}
