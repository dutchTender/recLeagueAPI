package li.zhang.app.utils.config.seed;

import li.zhang.app.services.util.SeedService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class SeedConfig {

    @Profile("test")
    @Bean
    CommandLineRunner initializeData(SeedService dataSeederService) {
        return args -> dataSeederService.seedDB();
    }
}
