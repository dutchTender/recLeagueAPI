package li.zhang.app.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import li.zhang.app.persistence.dao.core.PlayerDAO;
import li.zhang.app.persistence.dto.core.PlayerDTO;
import li.zhang.app.persistence.entity.core.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class PlayerEntityStepDefinitions {

    private static final Logger log = LoggerFactory.getLogger(PlayerEntityStepDefinitions.class);
    private final PlayerDAO playerRepository;

    public PlayerEntityStepDefinitions(PlayerDAO playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Given("the player database is empty")
    public void theDatabaseIsEmpty() {
    log.info("the player database is empty");
    }

    @When("a user saves a new player named {string}")
    public void aUserSavesANewPlayerNamed(String name) {

        playerRepository.saveAndFlush(new Player());
    }

    @Then("a player named {string} should exist in the database")
    public void aPlayerNamedShouldExistInTheDatabase(String name) {

        log.info("cucumber tests completed");
    }


}
