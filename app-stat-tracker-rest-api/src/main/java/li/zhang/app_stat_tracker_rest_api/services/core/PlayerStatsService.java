package li.zhang.app_stat_tracker_rest_api.services.core;

import li.zhang.app_stat_tracker_rest_api.model.base.BaseService;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.PlayerStatsDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerStatsDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.PlayerStats;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PlayerStatsService implements BaseService<PlayerStats, PlayerStatsDTO> {

    private final PlayerStatsDAO playerStatsDAO;
    private static final Logger logger = Logger.getLogger(PlayerStatsService.class.getName());

    public PlayerStatsService(PlayerStatsDAO playerStatsDAO) {
        this.playerStatsDAO = playerStatsDAO;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public PlayerStatsDTO find(Long id) {
        return this.playerStatsDAO.findPlayerStatsById(id).orElse(null);
    }

    @Override
    public PlayerStats findByExample(Example<PlayerStats> example) {
        return this.playerStatsDAO.findPlayerStatsBy(example).orElse(null);
    }

    @Override
    public List<PlayerStatsDTO> findAll() {
        return this.playerStatsDAO.findAllBy();
    }

    @Override
    public List<PlayerStats> findAllByExample(Example<PlayerStats> example) {
        return this.playerStatsDAO.findAllPlayerStatsBy(example);
    }

    @Override
    public Page<PlayerStatsDTO> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = Sort.Direction.fromString(sortOrder);
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        this.getLogger().log(Level.INFO, "findAllPaginatedAndSorted() params : - {}", pageable);
        return this.playerStatsDAO.findAllBy(pageable);
    }

    @Override
    public PlayerStats create(PlayerStats entity) {
        return this.playerStatsDAO.save(entity);
    }

    @Override
    public PlayerStats update(PlayerStats entity) {
        return this.playerStatsDAO.save(entity);
    }

    @Override
    public void delete(PlayerStats entity) {
        this.playerStatsDAO.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        this.playerStatsDAO.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.playerStatsDAO.deleteAll();
    }

    @Override
    public long count() {
        return this.playerStatsDAO.count();
    }
}
