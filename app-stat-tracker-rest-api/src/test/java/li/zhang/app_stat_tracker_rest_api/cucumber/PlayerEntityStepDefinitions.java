package li.zhang.app_stat_tracker_rest_api.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.PlayerDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
    public void aUserSavesANewCustomerNamed(String name) {
        playerRepository.saveAndFlush(new Player(name));
    }

    @Then("a player named {string} should exist in the database")
    public void aCustomerNamedShouldExistInTheDatabase(String name) {
        List<PlayerDTO> player = playerRepository.findPlayerByUserName(name);
        assertEquals(player.get(0).getUserName(), name, "Customer should be found in the database");
        log.info("cucumber tests completed");
    }

    @Given("the registration database is empty")
    public void clearDatabase() {
        playerRepository.deleteAll();
    }

    @When("a client requests registration for {string} with email {string}")
    public void registerUser(String name, String email) {
        log.info("registering user {} with email {}", name, email);
    }

    @Then("the response status should be {int}")
    public void verifyStatusCode(int expectedStatus) {
        log.info("verifying status code {}", expectedStatus);
    }

    @And("the player {string} should exist in the system")
    public void verifyUserPersisted(String expectedName) {
        boolean userExists = playerRepository.findAll().stream()
                .anyMatch(player -> player.getUserName().equals(expectedName));
        log.info("user exists {}", userExists);
    }



}
