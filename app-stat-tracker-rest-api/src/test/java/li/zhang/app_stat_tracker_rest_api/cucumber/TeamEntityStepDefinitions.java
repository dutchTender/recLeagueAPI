package li.zhang.app_stat_tracker_rest_api.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.core.TeamDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.dto.core.TeamDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.core.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class TeamEntityStepDefinitions {
    private static final Logger log = LoggerFactory.getLogger(TeamEntityStepDefinitions.class);
    private final TeamDAO repository;
    public TeamEntityStepDefinitions(TeamDAO repository) {
        this.repository = repository;
    }
    @Given("the team database is empty")
    public void theDatabaseIsEmpty() {
        log.info("the team database is empty");
    }

    @When("a user saves a new team named {string}")
    public void aUserSavesANewTeamNamed(String name) {
        repository.save(new Team(name));
    }

    @Then("a team named {string} should exist in the database")
    public void aTeamNamedShouldExistInTheDatabase(String name) {
        List<TeamDTO> team = repository.findTeamByTeamName(name);
        assertEquals(team.get(0).getTeamName(), name, "Customer should be found in the database");
        log.info("cucumber tests completed");
    }
}
