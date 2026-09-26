package li.zhang.app_stat_tracker_rest_api.persistence.dao;

import li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Game;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.Optional;

public interface GameDAO extends JpaRepository<Game, Long>, QueryByExampleExecutor<Game> {
    @Query("SELECT new li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO(g.id, g.gameType, g.gameTime, g.gameLocation)" +
            "FROM Game g " +
            "WHERE g.id = :id")
    Optional<GameDTO> findGameById(@Param("id")Long id);

    @Query("SELECT new li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO(g.id, g.gameType, g.gameTime, g.gameLocation)" +
            "FROM Game g " +
            "WHERE g.gameTime = :gameTime")
    Optional<GameDTO> findGameByGameTime(@Param("gameTime")String gameTime);

    @Query("SELECT new li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO(g.id, g.gameType, g.gameTime, g.gameLocation)" +
            "FROM Game g " )
    List<GameDTO> findAllBy();

    @Query("SELECT new li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO(g.id, g.gameType, g.gameTime, g.gameLocation)" +
            "FROM Game g " )
    Page<GameDTO> findAllBy(Pageable pageable);

    List<Game> findAllBy(Example<Game> example);

    Optional<Game> findGameBy(Example<Game> example);
}
