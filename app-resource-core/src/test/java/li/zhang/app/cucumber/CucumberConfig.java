package li.zhang.app.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import li.zhang.app.AppResourceCore;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@CucumberContextConfiguration
@SpringBootTest(classes = AppResourceCore.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberConfig {
    @LocalServerPort
    protected int port; // Automatically injects the random port assigned
}