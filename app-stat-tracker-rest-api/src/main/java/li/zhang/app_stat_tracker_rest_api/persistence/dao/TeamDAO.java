package li.zhang.app_stat_tracker_rest_api.persistence.dao;

import li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Team;
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

    @Query("SELECT new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(t.id, t.teamName,t.teamCoachName, t.teamSponsors," +
                  "new li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO(hg.id, hg.gameType,hg.gameTime, hg.gameLocation)," +
                  "new li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO(ag.id, ag.gameType,ag.gameTime, ag.gameLocation)," +
                  "new li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO(p.id, p.userName, p.firstName, p.lastName, p.email, p.phone, p.sex)   )" +
            "FROM Team t " +
            "left JOIN t.homeGames hg " +
            "left JOIN t.awayGames ag " +
            "left JOIN t.players p " +
            "WHERE t.id = :id")
    List<TeamDTO> findTeamById(@Param("id") Long id);

    @Query("SELECT new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(t.id, t.teamName,t.teamCoachName, t.teamSponsors," +
            "new li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO(hg.id, hg.gameType,hg.gameTime, hg.gameLocation)," +
            "new li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO(ag.id, ag.gameType,ag.gameTime, ag.gameLocation)," +
            "new li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO(p.id, p.userName, p.firstName, p.lastName, p.email, p.phone, p.sex)   )" +
            "FROM Team t " +
            "left JOIN t.homeGames hg " +
            "left JOIN t.awayGames ag " +
            "left JOIN t.players p "+
            "WHERE t.teamName = :teamName")
    Optional<TeamDTO> findTeamByTeamName(@Param("teamName") String teamName);

    @Query("SELECT new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(t.id, t.teamName,t.teamCoachName, t.teamSponsors," +
            "new li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO(hg.id, hg.gameType,hg.gameTime, hg.gameLocation)," +
            "new li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO(ag.id, ag.gameType,ag.gameTime, ag.gameLocation)," +
            "new li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO(p.id, p.userName, p.firstName, p.lastName, p.email, p.phone, p.sex)   )" +
            "FROM Team t " +
            "left JOIN t.homeGames hg " +
            "left JOIN t.awayGames ag " +
            "left JOIN t.players p " )
    List<TeamDTO> findAllBy();

    @Query("SELECT new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(t.id, t.teamName,t.teamCoachName, t.teamSponsors," +
            "new li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO(hg.id, hg.gameType,hg.gameTime, hg.gameLocation)," +
            "new li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO(ag.id, ag.gameType,ag.gameTime, ag.gameLocation)," +
            "new li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO(p.id, p.userName, p.firstName, p.lastName, p.email, p.phone, p.sex)   )" +
            "FROM Team t " +
            "left JOIN t.homeGames hg " +
            "left JOIN t.awayGames ag " +
            "left JOIN t.players p " )
    Page<TeamDTO> findAllBy(Pageable pageable);

    Optional<Team> findTeamBy(Example<Team> example);

    List<Team> findAllBy(Example<Team> example);
}
