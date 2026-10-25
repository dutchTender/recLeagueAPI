package li.zhang.app.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import li.zhang.app.AppStatTrackerRestApiApplication;
import org.springframework.boot.test.web.server.LocalServerPort;

@CucumberContextConfiguration
@SpringBootTest(classes = AppStatTrackerRestApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberConfig {
    @LocalServerPort
    protected int port; // Automatically injects the random port assigned
}