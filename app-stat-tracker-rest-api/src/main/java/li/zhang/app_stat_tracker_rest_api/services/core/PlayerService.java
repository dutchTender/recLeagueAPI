package li.zhang.app_stat_tracker_rest_api.services.core;

import li.zhang.app_stat_tracker_rest_api.model.base.BaseService;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.core.PlayerDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.core.Player;
import org.jspecify.annotations.NonNull;
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
        PlayerDTO resultDTO = new PlayerDTO();
        List<PlayerDTO> rawDTOResult = this.playerDAO.findPlayerById(id);
        return getPlayerDTO(resultDTO, rawDTOResult);

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
        PlayerDTO resultDTO = new PlayerDTO();
        List<PlayerDTO> rawDTOResult = this.playerDAO.findPlayerByUserName(name);
        return getPlayerDTO(resultDTO, rawDTOResult);
    }

    @NonNull
    private PlayerDTO getPlayerDTO(PlayerDTO resultDTO, List<PlayerDTO> rawDTOResult) {
        resultDTO.setId(rawDTOResult.get(0).getId());
        resultDTO.setUserName(rawDTOResult.get(0).getUserName());
        resultDTO.setFirstName(rawDTOResult.get(0).getFirstName());
        resultDTO.setLastName(rawDTOResult.get(0).getLastName());
        resultDTO.setEmail(rawDTOResult.get(0).getEmail());
        resultDTO.setPhone(rawDTOResult.get(0).getPhone());
        resultDTO.setSex(rawDTOResult.get(0).getSex());
        resultDTO.setTeam(rawDTOResult.get(0).getTeam());
        rawDTOResult.forEach(playerDTO -> resultDTO.addPlayerSeasonStats(playerDTO.getGameStats()));

        return resultDTO;
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
