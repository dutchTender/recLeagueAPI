package li.zhang.app_stat_tracker_rest_api.services.util;

import li.zhang.app_stat_tracker_rest_api.persistence.dao.PlayerDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.TeamDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Team;
import org.springframework.stereotype.Service;

@Service
public class SeedService {

    private final PlayerDAO playerDAO;
    private final TeamDAO teamDAO;
    public SeedService(PlayerDAO playerDAO,  TeamDAO teamDAO) {

        this.playerDAO = playerDAO;
        this.teamDAO = teamDAO;
    }


    public void seedDB(){
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

    }
}
