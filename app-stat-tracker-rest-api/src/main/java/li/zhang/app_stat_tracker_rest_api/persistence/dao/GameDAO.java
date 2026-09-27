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
    @Query("SELECT new li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO(g.id, g.gameType, g.gameDate, g.gameTime, g.gameLocation," +
                 " new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(ht.id, ht.teamName, ht.teamCoachName, ht.teamSponsors)," +
            " new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(ht.id, ht.teamName, ht.teamCoachName, ht.teamSponsors))"+
            "FROM Game g " +
            "left Join g.homeTeam ht "+
            "left Join g.awayTeam at "+
            "WHERE g.id = :id")
    Optional<GameDTO> findGameById(@Param("id")Long id);

    @Query("SELECT new li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO(g.id, g.gameType, g.gameDate, g.gameTime, g.gameLocation," +
            " new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(ht.id, ht.teamName, ht.teamCoachName, ht.teamSponsors)," +
            " new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(ht.id, ht.teamName, ht.teamCoachName, ht.teamSponsors))"+
            "FROM Game g " +
            "left Join g.homeTeam ht "+
            "left Join g.awayTeam at "+
            "WHERE g.gameTime = :gameTime")
    Optional<GameDTO> findGameByGameTime(@Param("gameTime")String gameTime);

    @Query("SELECT new li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO(g.id, g.gameType, g.gameDate, g.gameTime, g.gameLocation," +
            " new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(ht.id, ht.teamName, ht.teamCoachName, ht.teamSponsors)," +
            " new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(ht.id, ht.teamName, ht.teamCoachName, ht.teamSponsors))"+
            "FROM Game g " +
            "left Join g.homeTeam ht "+
            "left Join g.awayTeam at ")
    List<GameDTO> findAllBy();

    @Query("SELECT new li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO(g.id, g.gameType, g.gameDate, g.gameTime, g.gameLocation," +
            " new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(ht.id, ht.teamName, ht.teamCoachName, ht.teamSponsors)," +
            " new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(ht.id, ht.teamName, ht.teamCoachName, ht.teamSponsors))"+
            "FROM Game g " +
            "left Join g.homeTeam ht "+
            "left Join g.awayTeam at ")
    Page<GameDTO> findAllBy(Pageable pageable);

    List<Game> findAllBy(Example<Game> example);

    Optional<Game> findGameBy(Example<Game> example);
}
