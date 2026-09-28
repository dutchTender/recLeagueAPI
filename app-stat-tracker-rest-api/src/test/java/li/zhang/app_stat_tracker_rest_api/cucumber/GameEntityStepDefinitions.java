package li.zhang.app_stat_tracker_rest_api.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.GameDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameEntityStepDefinitions {

    private static final Logger log = LoggerFactory.getLogger(GameEntityStepDefinitions.class);
    private final GameDAO repository;
    public GameEntityStepDefinitions(GameDAO repository) {
        this.repository = repository;
    }
    @Given("the game database is empty")
    public void theDatabaseIsEmpty() {
        log.info("the game database is empty");
    }

    @When("a user create a new game for the date {string}")
    public void aUserSavesANewCustomerNamed(String date) {
        repository.save(new Game(date));
    }

    @Then("a game dated {string} should exist in the database")
    public void aCustomerNamedShouldExistInTheDatabase(String gameTime) {
        List<GameDTO> game = repository.findGameByGameTime(gameTime);
        assertEquals(game.get(0).getGameTime(), gameTime, "Game should be found in the database");
        log.info("cucumber tests completed");
    }
}
