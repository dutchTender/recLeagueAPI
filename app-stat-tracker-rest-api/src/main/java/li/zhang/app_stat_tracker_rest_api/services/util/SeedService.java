package li.zhang.app_stat_tracker_rest_api.services.util;

import li.zhang.app_stat_tracker_rest_api.persistence.dao.GameDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.PlayerDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.PlayerStatsDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.TeamDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Game;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.PlayerStats;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Team;
import org.springframework.stereotype.Service;

@Service
public class SeedService {

    private final PlayerDAO playerDAO;
    private final TeamDAO teamDAO;
    private final GameDAO gameDAO;
    private final PlayerStatsDAO playerStatsDAO;
    public SeedService(PlayerDAO playerDAO, TeamDAO teamDAO, GameDAO gameDAO, PlayerStatsDAO playerStatsDAO) {
        this.playerDAO = playerDAO;
        this.teamDAO = teamDAO;
        this.gameDAO = gameDAO;
        this.playerStatsDAO = playerStatsDAO;
    }

    public void seedDB(){
/*
start of team 1
 */

        Player player1 = new Player();
        player1.setUserName("dutchTender");
        player1.setEmail("lzhang421@gmailo.com");
        player1.setFirstName("li");
        player1.setLastName("zhang");
        player1.setSex("male");
        player1.setPhone("571-839-7777");

        this.playerDAO.saveAndFlush(player1);

        Player player2 = new Player();
        player2.setUserName("black-lighting");
        player2.setEmail("lzhang4333@gmailo.com");
        player2.setFirstName("mike");
        player2.setLastName("johnson");
        player2.setSex("male");
        player2.setPhone("571-555-7777");

        this.playerDAO.saveAndFlush(player2);

        Player player3 = new Player();
        player3.setUserName("white-thunder");
        player3.setEmail("xxxx@gmailo.com");
        player3.setFirstName("nick");
        player3.setLastName("price");
        player3.setSex("male");
        player3.setPhone("222-555-7777");

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
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);
        this.teamDAO.saveAndFlush(team1);
/*
start of team 2
 */
        Player player4 = new Player();
        player4.setUserName("gentle-giant");
        player4.setEmail("lzhxxxx1@gmailo.com");
        player4.setFirstName("jason");
        player4.setLastName("borne");
        player4.setSex("male");
        player4.setPhone("571-839-7777");

        this.playerDAO.saveAndFlush(player4);

        Player player5 = new Player();
        player5.setUserName("skip to my lu");
        player5.setEmail("2342525t@gmailo.com");
        player5.setFirstName("mike");
        player5.setLastName("ryan");
        player5.setSex("male");
        player5.setPhone("571-555-7777");

        this.playerDAO.saveAndFlush(player5);

        Player player6 = new Player();
        player6.setUserName("while chocolate");
        player6.setEmail("x4444444x@gmailo.com");
        player6.setFirstName("jason");
        player6.setLastName("williams");
        player6.setSex("male");
        player6.setPhone("222-555-7777");

        this.playerDAO.saveAndFlush(player3);


        Team team2 = new Team("Team-lightning");
        team2.setTeamCoachName("steve kerr");
        this.teamDAO.saveAndFlush(team2);

        player4.setTeam(team2);
        player5.setTeam(team2);
        player6.setTeam(team2);
        this.playerDAO.saveAndFlush(player4);
        this.playerDAO.saveAndFlush(player5);
        this.playerDAO.saveAndFlush(player6);

        team2.addPlayer(player4);
        team2.addPlayer(player5);
        team2.addPlayer(player6);
        this.teamDAO.saveAndFlush(team2);


/*
crate first game
 */
        Game game = new Game();
        game.setGameType("season");
        game.setGameLocation("Thomas Farm Community Center");
        game.setHomeTeam(team1);
        game.setAwayTeam(team2);
        game.setGameTime("12:00PM");
        game.setGameDate("2/22/2227");
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
