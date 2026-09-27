package li.zhang.app_stat_tracker_rest_api.services.core;

import li.zhang.app_stat_tracker_rest_api.model.base.BaseService;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.PlayerDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
@Service
public class PlayerService implements BaseService<Player, PlayerDTO> {


    private final PlayerDAO playerDAO;
    private static final Logger logger = Logger.getLogger(PlayerService.class.getName());

    public PlayerService(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public PlayerDTO find(Long id) {
        return this.playerDAO.findPlayerById(id).orElse(null);
    }

    @Override
    public Player findByExample(Example<Player> example) {
       return this.playerDAO.findPlayerBy(example).orElse(null);
    }

    @Override
    public List<PlayerDTO> findAll() {
        return this.playerDAO.findAllBy();
    }

    @Override
    public List<Player> findAllByExample(Example<Player> example) {
        return this.playerDAO.findAllPlayerBy(example);
    }

    @Override
    public Page<PlayerDTO> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = Sort.Direction.fromString(sortOrder);
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        this.getLogger().log(Level.INFO, "findAllPaginatedAndSorted() params : - {}", pageable);
        return this.playerDAO.findAllBy(pageable);
    }

    public PlayerDTO findPlayerByName(String name) {
        return this.playerDAO.findPlayerByUserName(name).orElse(null);
    }

    @Override
    public Player create(Player entity) {
        return this.playerDAO.save(entity);
    }

    @Override
    public Player update(Player entity) {
        return this.playerDAO.save(entity);
    }

    @Override
    public void delete(Player entity) {
         this.playerDAO.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        this.playerDAO.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.playerDAO.deleteAll();
    }

    @Override
    public long count() {
        return this.playerDAO.count();
    }
}
