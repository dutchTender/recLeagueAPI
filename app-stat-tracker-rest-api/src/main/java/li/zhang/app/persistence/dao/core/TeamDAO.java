package li.zhang.app.persistence.dao.core;

import li.zhang.app.persistence.dto.core.TeamDTO;
import li.zhang.app.persistence.entity.core.Team;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import java.util.List;
import java.util.Optional;

public interface TeamDAO extends JpaRepository<Team, Long>, QueryByExampleExecutor<Team> {

    @Query("SELECT new li.zhang.app.persistence.dto.core.TeamDTO(t.id, t.teamName,t.teamCoachName, t.teamSponsors," +
            "new li.zhang.app.persistence.dto.core.GameDTO(hg.id, hg.gameType,hg.gameDate,hg.gameTime, hg.gameLocation)," +
            "new li.zhang.app.persistence.dto.core.GameDTO(ag.id, ag.gameType,ag.gameDate,ag.gameTime, ag.gameLocation)," +
            "new li.zhang.app.persistence.dto.core.PlayerDTO(p.id, p.position, p.number, p.isCaptain," +
            "new li.zhang.app.persistence.dto.base.UserInfoDTO(ui.id, ui.userName, ui.firstName, ui.lastName, ui.gender, ui.height, ui.weight,ui.age, ui.email),"+
            "new li.zhang.app.persistence.dto.core.PlayerStatsDTO(ps.id, ps.points, ps.assists, ps.rebounds, ps.turnOvers)"+") )" +
            "FROM Team t " +
            "left JOIN t.homeGames hg " +
            "left JOIN t.awayGames ag " +
            "left JOIN t.players p " +
            "left join p.playerStats ps "+
            "left join UserInfo ui on ui.id = p.user.id " +
            "WHERE t.id = :id")
    List<TeamDTO> findTeamById(@Param("id") Long id);

    @Query("SELECT new li.zhang.app.persistence.dto.core.TeamDTO(t.id, t.teamName,t.teamCoachName, t.teamSponsors," +
            "new li.zhang.app.persistence.dto.core.GameDTO(hg.id, hg.gameType,hg.gameDate,hg.gameTime, hg.gameLocation)," +
            "new li.zhang.app.persistence.dto.core.GameDTO(ag.id, ag.gameType,ag.gameDate,ag.gameTime, ag.gameLocation)," +
            "new li.zhang.app.persistence.dto.core.PlayerDTO(p.id, p.position, p.number, p.isCaptain," +
            "new li.zhang.app.persistence.dto.base.UserInfoDTO(ui.id, ui.userName, ui.firstName, ui.lastName, ui.gender, ui.height, ui.weight,ui.age, ui.email),"+
            "new li.zhang.app.persistence.dto.core.PlayerStatsDTO(ps.id, ps.points, ps.assists, ps.rebounds, ps.turnOvers)"+") )" +
            "FROM Team t " +
            "left JOIN t.homeGames hg " +
            "left JOIN t.awayGames ag " +
            "left JOIN t.players p " +
            "left join p.playerStats ps "+
            "left join UserInfo ui on ui.id = p.user.id " +
            "WHERE t.teamName = :teamName")
    List<TeamDTO> findTeamByTeamName(@Param("teamName") String teamName);

    @Query("SELECT new li.zhang.app.persistence.dto.core.TeamDTO(t.id, t.teamName,t.teamCoachName, t.teamSponsors," +
            "new li.zhang.app.persistence.dto.core.GameDTO(hg.id, hg.gameType,hg.gameDate,hg.gameTime, hg.gameLocation)," +
            "new li.zhang.app.persistence.dto.core.GameDTO(ag.id, ag.gameType,ag.gameDate,ag.gameTime, ag.gameLocation))" +
            "FROM Team t " +
            "left JOIN t.homeGames hg " +
            "left JOIN t.awayGames ag ")
    List<TeamDTO> findAllBy();

    @Query("SELECT new li.zhang.app.persistence.dto.core.TeamDTO(t.id, t.teamName,t.teamCoachName, t.teamSponsors," +
            "new li.zhang.app.persistence.dto.core.GameDTO(hg.id, hg.gameType,hg.gameDate,hg.gameTime, hg.gameLocation)," +
            "new li.zhang.app.persistence.dto.core.GameDTO(ag.id, ag.gameType,ag.gameDate,ag.gameTime, ag.gameLocation))" +
            "FROM Team t " +
            "left JOIN t.homeGames hg " +
            "left JOIN t.awayGames ag ")
    Page<TeamDTO> findAllBy(Pageable pageable);

    Optional<Team> findTeamBy(Example<Team> example);

    List<Team> findAllBy(Example<Team> example);
}
