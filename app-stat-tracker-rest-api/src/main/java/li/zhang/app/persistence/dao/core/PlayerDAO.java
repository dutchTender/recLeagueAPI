package li.zhang.app.persistence.dao.core;

import li.zhang.app.persistence.dto.core.PlayerDTO;
import li.zhang.app.persistence.entity.core.Player;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import java.util.List;
import java.util.Optional;

public interface PlayerDAO extends JpaRepository<Player, Long> , QueryByExampleExecutor<Player> {

    @Query("SELECT new li.zhang.app.persistence.dto.core.PlayerDTO( " +
            "  new li.zhang.app.persistence.dto.base.UserInfoDTO(ui.id, ui.userName, ui.firstName,ui.lastName, ui.gender, ui.height, ui.weight, ui.age, ui.email), " +
            "  new li.zhang.app.persistence.dto.core.TeamDTO(t.id, t.teamName,t.teamCoachName, t.teamSponsors," +
            "  new li.zhang.app.persistence.dto.core.GameDTO(hg.id, hg.gameType,hg.gameDate, hg.gameTime, hg.gameLocation)," +
            "  new li.zhang.app.persistence.dto.core.GameDTO(ag.id, ag.gameType,ag.gameDate,ag.gameTime, ag.gameLocation))," +
            "  new li.zhang.app.persistence.dto.core.PlayerStatsDTO(ps.id, ps.points, ps.assists, ps.rebounds, ps.turnOvers)" + ") " +
            "FROM Player p " +
            "left JOIN p.team t " + // Explicit JOIN to fetch team data efficiently
            "left JOIN t.homeGames hg " +
            "left JOIN t.awayGames ag " +
            "left join p.playerStats ps "+
            "left join UserInfo ui on ui.id = p.user.id "+
            "WHERE p.id = :id")
    List<PlayerDTO> findPlayerById(@Param("id") Long id);

    @Query("SELECT new li.zhang.app.persistence.dto.core.PlayerDTO( " +
            "  new li.zhang.app.persistence.dto.base.UserInfoDTO(ui.id, ui.userName, ui.firstName,ui.lastName, ui.gender, ui.height, ui.weight, ui.age, ui.email), " +
            "  new li.zhang.app.persistence.dto.core.TeamDTO(t.id, t.teamName,t.teamCoachName, t.teamSponsors," +
            "  new li.zhang.app.persistence.dto.core.GameDTO(hg.id, hg.gameType,hg.gameDate, hg.gameTime, hg.gameLocation)," +
            "  new li.zhang.app.persistence.dto.core.GameDTO(ag.id, ag.gameType,ag.gameDate,ag.gameTime, ag.gameLocation))," +
            "  new li.zhang.app.persistence.dto.core.PlayerStatsDTO(ps.id, ps.points, ps.assists, ps.rebounds, ps.turnOvers)" + ") " +
            "FROM Player p " +
            "left JOIN p.team t " + // Explicit JOIN to fetch team data efficiently
            "left JOIN t.homeGames hg " +
            "left JOIN t.awayGames ag " +
            "left join p.playerStats ps "+
            "left join UserInfo ui on ui.id = p.user.id "+
            "WHERE p.user.userName = :name")
    List<PlayerDTO> findPlayerByUserName(@Param("name") String name);

    @Query("SELECT new li.zhang.app.persistence.dto.core.PlayerDTO( " +
            "  new li.zhang.app.persistence.dto.base.UserInfoDTO(ui.id, ui.userName, ui.firstName,ui.lastName, ui.gender, ui.height, ui.weight, ui.age, ui.email), " +
            "  new li.zhang.app.persistence.dto.core.TeamDTO(t.id, t.teamName,t.teamCoachName, t.teamSponsors," +
            "  new li.zhang.app.persistence.dto.core.GameDTO(hg.id, hg.gameType,hg.gameDate, hg.gameTime, hg.gameLocation)," +
            "  new li.zhang.app.persistence.dto.core.GameDTO(ag.id, ag.gameType,ag.gameDate, ag.gameTime, ag.gameLocation))" + ") " +
            "FROM Player p " +
            "left JOIN p.team t " + // Explicit JOIN to fetch team data efficiently
            "left JOIN t.homeGames hg " +
            "left JOIN t.awayGames ag " +
            "left join UserInfo ui on ui.id = p.user.id ")
    List<PlayerDTO> findAllBy();

    @Query("SELECT new li.zhang.app.persistence.dto.core.PlayerDTO( " +
            "  new li.zhang.app.persistence.dto.base.UserInfoDTO(ui.id, ui.userName, ui.firstName,ui.lastName, ui.gender, ui.height, ui.weight, ui.age, ui.email), " +
            "  new li.zhang.app.persistence.dto.core.TeamDTO(t.id, t.teamName,t.teamCoachName, t.teamSponsors," +
            "  new li.zhang.app.persistence.dto.core.GameDTO(hg.id, hg.gameType,hg.gameDate, hg.gameTime, hg.gameLocation)," +
            "  new li.zhang.app.persistence.dto.core.GameDTO(ag.id, ag.gameType,ag.gameDate, ag.gameTime, ag.gameLocation))" + ") " +
            "FROM Player p " +
            "left JOIN p.team t " + // Explicit JOIN to fetch team data efficiently
            "left JOIN t.homeGames hg " +
            "left JOIN t.awayGames ag " +
            "left join UserInfo ui on ui.id = p.user.id ")
    Page<PlayerDTO> findAllBy(Pageable pageable);

    List<Player> findAllPlayerBy(Example<Player> example);

    Optional<Player> findPlayerBy(Example<Player> example);
}
