package li.zhang.app_stat_tracker_rest_api.persistence.dao.core;

import li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.core.Game;
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
            " new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(ht.id, ht.teamName, ht.teamCoachName, ht.teamSponsors," +
            "new li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO(htp.id, htp.userName, htp.firstName, htp.lastName, htp.email, htp.phone, htp.sex," +
            "new li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerStatsDTO(hgs.id, hgs.points, hgs.assists,hgs.rebounds, hgs.turnOvers)))," +
            " new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(at.id, at.teamName, at.teamCoachName, at.teamSponsors," +
            "new li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO(atp.id, atp.userName, atp.firstName, atp.lastName, atp.email, atp.phone, atp.sex," +
            "new li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerStatsDTO(ags.id, ags.points, ags.assists,ags.rebounds, ags.turnOvers))))"+
            "FROM Game g " +
            "left Join g.homeTeam ht "+
            "left Join g.awayTeam at "+
            "left join ht.players htp "+
            "left join at.players atp "+
            "left join htp.playerStats hgs ON hgs.game.id = g.id "+
            "left join atp.playerStats ags ON ags.game.id = g.id "+
            "WHERE g.id = :id")
    List<GameDTO> findGameById(@Param("id")Long id);

    @Query("SELECT new li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO(g.id, g.gameType, g.gameDate, g.gameTime, g.gameLocation," +
            " new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(ht.id, ht.teamName, ht.teamCoachName, ht.teamSponsors," +
            "new li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO(htp.id, htp.userName, htp.firstName, htp.lastName, htp.email, htp.phone, htp.sex," +
            "new li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerStatsDTO(hgs.id, hgs.points, hgs.assists,hgs.rebounds, hgs.turnOvers)))," +
            " new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(at.id, at.teamName, at.teamCoachName, at.teamSponsors," +
            "new li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO(atp.id, atp.userName, atp.firstName, atp.lastName, atp.email, atp.phone, atp.sex," +
            "new li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerStatsDTO(ags.id, ags.points, ags.assists,ags.rebounds, ags.turnOvers))))"+
            "FROM Game g " +
            "left Join g.homeTeam ht "+
            "left Join g.awayTeam at "+
            "left join ht.players htp "+
            "left join at.players atp "+
            "left join htp.playerStats hgs ON hgs.game.id = g.id "+
            "left join atp.playerStats ags ON ags.game.id = g.id "+
            "WHERE g.gameTime = :gameTime")
    List<GameDTO> findGameByGameTime(@Param("gameTime")String gameTime);

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
