package li.zhang.app.services.core;

import li.zhang.app.model.base.BaseService;
import li.zhang.app.persistence.dao.core.PlayerDAO;
import li.zhang.app.persistence.dto.core.PlayerDTO;
import li.zhang.app.persistence.entity.core.Player;
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
        resultDTO.setPosition(rawDTOResult.get(0).getPosition());
        resultDTO.setNumber(rawDTOResult.get(0).getNumber());
        resultDTO.setCaptain(rawDTOResult.get(0).isCaptain());
        resultDTO.setUser(rawDTOResult.get(0).getUser());
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
