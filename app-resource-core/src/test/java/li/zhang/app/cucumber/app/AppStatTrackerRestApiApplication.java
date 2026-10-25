package li.zhang.app.cucumber.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AppStatTrackerRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppStatTrackerRestApiApplication.class, args);
	}

}
