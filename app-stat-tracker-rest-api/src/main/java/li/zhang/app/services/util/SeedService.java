package li.zhang.app.services.util;

import li.zhang.app.persistence.dao.base.UserInfoDAO;
import li.zhang.app.persistence.dao.core.GameDAO;
import li.zhang.app.persistence.dao.core.PlayerDAO;
import li.zhang.app.persistence.dao.core.PlayerStatsDAO;
import li.zhang.app.persistence.dao.core.TeamDAO;
import li.zhang.app.persistence.dto.base.UserInfoDTO;
import li.zhang.app.persistence.entity.base.UserInfo;
import li.zhang.app.persistence.entity.core.Game;
import li.zhang.app.persistence.entity.core.Player;
import li.zhang.app.persistence.entity.core.PlayerStats;
import li.zhang.app.persistence.entity.core.Team;
import org.springframework.stereotype.Service;

@Service
public class SeedService {

    private final PlayerDAO playerDAO;
    private final TeamDAO teamDAO;
    private final GameDAO gameDAO;
    private final PlayerStatsDAO playerStatsDAO;
    private final UserInfoDAO userInfoDAO;
    public SeedService(PlayerDAO playerDAO, TeamDAO teamDAO, GameDAO gameDAO, PlayerStatsDAO playerStatsDAO, UserInfoDAO userInfoDAO) {
        this.playerDAO = playerDAO;
        this.teamDAO = teamDAO;
        this.gameDAO = gameDAO;
        this.playerStatsDAO = playerStatsDAO;
        this.userInfoDAO = userInfoDAO;
    }

    public void seedDB(){
/*
start of team 1
 */
        UserInfo user1 = new UserInfo("dutchTender");
        user1.setEmail("lzhang421@gmailo.com");
        user1.setFirstName("li");
        user1.setLastName("zhang");
        user1.setGender("male");
        user1.setPhone("571-839-7777");
        UserInfo newAppUser1 = this.userInfoDAO.save(user1);

        Player player1 = new Player(newAppUser1);
        this.playerDAO.saveAndFlush(player1);


        UserInfo user2 = new UserInfo("black-lighting");
        user2.setEmail("lzhang4333@gmailo.com");
        user2.setFirstName("mike");
        user2.setLastName("johnson");
        user2.setGender("male");
        user2.setPhone("571-555-7777");
        UserInfo newAppUser2 = this.userInfoDAO.save(user2);
        Player player2 = new Player(newAppUser2);
        this.playerDAO.saveAndFlush(player2);

        UserInfo user3 = new UserInfo("white-thunder");
        user3.setEmail("xxxx@gmailo.com");
        user3.setFirstName("nick");
        user3.setLastName("price");
        user3.setGender("male");
        user3.setPhone("222-555-7777");
        UserInfo newAppUser3 = this.userInfoDAO.save(user3);
        Player player3 = new Player(newAppUser3);
        this.playerDAO.saveAndFlush(player3);


        Team team1 = new Team("Team-Thunder");
        team1.setTeamCoachName("Dutch Tender");
        this.teamDAO.saveAndFlush(team1);

        player1.setTeam(team1);
        player2.setTeam(team1);
        player3.setTeam(team1);
        this.playerDAO.saveAndFlush(player1);
        this.playerDAO.saveAndFlush(player2);
        this.playerDAO.saveAndFlush(player3);

/*
start of team 2
 */
        UserInfo user4 = new UserInfo("gentle-giant");
        user4.setEmail("lzhxxxx1@gmailo.com");
        user4.setFirstName("jason");
        user4.setLastName("borne");
        user4.setGender("male");
        user4.setPhone("571-839-7777");
        UserInfo newAppUser4= this.userInfoDAO.save(user4);
        Player player4 = new Player(newAppUser4);
        this.playerDAO.saveAndFlush(player4);


        UserInfo user5 = new UserInfo("skip_to-myLu");
        user5.setEmail("2342525t@gmailo.com");
        user5.setFirstName("mike");
        user5.setLastName("ryan");
        user5.setGender("male");
        user5.setPhone("571-555-7777");
        UserInfo newAppUser5 = this.userInfoDAO.save(user5);
        Player player5 = new Player(newAppUser5);
        this.playerDAO.saveAndFlush(player5);


        UserInfo user6 = new UserInfo("while-chocolate");
        user6.setEmail("x4444444x@gmailo.com");
        user6.setFirstName("jason");
        user6.setLastName("williams");
        user6.setGender("male");
        user6.setPhone("222-555-7777");
        UserInfo newAppUser6 = this.userInfoDAO.save(user6);
        Player player6 = new Player(newAppUser6);
        this.playerDAO.saveAndFlush(player6);


        Team team2 = new Team("Team-lightning");
        team2.setTeamCoachName("steve kerr");
        this.teamDAO.saveAndFlush(team2);

        player4.setTeam(team2);
        player5.setTeam(team2);
        player6.setTeam(team2);
        this.playerDAO.saveAndFlush(player4);
        this.playerDAO.saveAndFlush(player5);
        this.playerDAO.saveAndFlush(player6);



/*
crate first game
 */
        Game game = new Game();
        game.setGameType("season");
        game.setGameLocation("Thomas Farm Community Center");
        game.setHomeTeam(team1);
        game.setAwayTeam(team2);
        game.setGameTime("12:00PM");
        game.setGameDate("2-22-2227");
        this.gameDAO.saveAndFlush(game);


        /*
        * create player stats for players
        * */
        PlayerStats playerStats1 = new PlayerStats();
        playerStats1.setPoints(11);
        playerStats1.setRebounds(8);
        playerStats1.setAssists(4);
        playerStats1.setTurnOvers(3);
        playerStats1.setGame(game);
        playerStats1.setPlayer(player1);
        this.playerStatsDAO.saveAndFlush(playerStats1);


        PlayerStats playerStats11 = new PlayerStats();

        playerStats11.setPlayer(player1);

        this.playerStatsDAO.saveAndFlush(playerStats11);

        PlayerStats playerStats2 = new PlayerStats();
        playerStats2.setPoints(15);
        playerStats2.setRebounds(3);
        playerStats2.setGame(game);
        playerStats2.setAssists(3);
        playerStats2.setTurnOvers(3);
        playerStats2.setPlayer(player2);

        this.playerStatsDAO.saveAndFlush(playerStats2);

        PlayerStats playerStats3 = new PlayerStats();
        playerStats3.setPoints(25);
        playerStats3.setRebounds(3);
        playerStats3.setGame(game);
        playerStats3.setAssists(3);
        playerStats3.setPlayer(player3);
        playerStats3.setTurnOvers(0);
        this.playerStatsDAO.saveAndFlush(playerStats3);
/*
start team 2
 */

        PlayerStats playerStats4 = new PlayerStats();
        playerStats4.setPoints(13);
        playerStats4.setRebounds(7);
        playerStats4.setAssists(4);
        playerStats4.setTurnOvers(7);
        playerStats4.setGame(game);
        playerStats4.setPlayer(player4);

        this.playerStatsDAO.saveAndFlush(playerStats4);

        PlayerStats playerStats5 = new PlayerStats();
        playerStats5.setPoints(25);
        playerStats5.setRebounds(3);
        playerStats5.setGame(game);
        playerStats5.setAssists(1);
        playerStats5.setTurnOvers(3);
        playerStats5.setPlayer(player5);

        this.playerStatsDAO.saveAndFlush(playerStats5);

        PlayerStats playerStats6 = new PlayerStats();
        playerStats6.setPoints(9);
        playerStats6.setRebounds(12);
        playerStats6.setGame(game);
        playerStats6.setAssists(5);
        playerStats6.setTurnOvers(4);
        playerStats6.setPlayer(player6);
        this.playerStatsDAO.saveAndFlush(playerStats6);
    }
}
