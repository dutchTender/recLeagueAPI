package li.zhang.app_stat_tracker_rest_api.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.PlayerDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.PlayerStatsDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.PlayerStats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerStatsEntityStepDefinitions {
    private static final Logger log = LoggerFactory.getLogger(PlayerStatsEntityStepDefinitions.class);
    private  final PlayerDAO playerDAO;
    private final PlayerStatsDAO playerStatsDAO;

    public PlayerStatsEntityStepDefinitions(PlayerDAO playerDAO, PlayerStatsDAO playerStatsDAO) {
        this.playerDAO = playerDAO;
        this.playerStatsDAO = playerStatsDAO;
    }

    @Given("the Player and PlayerStats database is not empty")
    public void theDatabaseIsEmpty() {
        log.info("the team database is empty");
    }

    @When("a user saves a new PlayerStat for a Player named {string}")
    public void aUserSavesANewCustomerNamed(String name) {
        PlayerStats playerStats = new PlayerStats();
        Player testPlayer = new Player(name);
        Player newPlayer = this.playerDAO.save(testPlayer);
        playerStats.setPlayer(newPlayer);
        playerStatsDAO.save(playerStats);
    }

    @Then("a playerStat should exist for a Player named {string} should exist in the database")
    public void aPlayerStatsForPlayerNamedShouldExistInTheDatabase(String name) {
        List<PlayerDTO> player = playerDAO.findPlayerByUserName(name);
        log.info(player.toString());
        assertNotNull(player.get(0).getGameStats());
        log.info("cucumber tests completed");
    }
}
