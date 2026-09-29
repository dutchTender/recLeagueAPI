package li.zhang.app.utils.config;

import li.zhang.app.services.util.SeedService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeedConfig {

    @Bean
    CommandLineRunner initializeData(SeedService dataSeederService) {
        return args -> dataSeederService.seedDB();
    }
}
