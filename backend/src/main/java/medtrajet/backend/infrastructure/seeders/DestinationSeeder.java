package medtrajet.backend.infrastructure.seeders;

import medtrajet.backend.domain.repositories.DestinationRepository;
import medtrajet.backend.infrastructure.jpa.DestinationJPA;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DestinationSeeder implements CommandLineRunner {

    private final DestinationRepository destinationRepository;

    public DestinationSeeder(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Value("${data.seed.enabled}")
    private boolean isSeedEnabled;

    @Value("${data.seed.destinations}")
    private List<String> destinations;

    @Override
    public void run(String... args) throws Exception {
        this.seedDestinations();
    }

    private void seedDestinations() {
        if(this.isSeedEnabled && destinationRepository.count() == 0) {
            this.destinations.forEach((destination) -> {
                DestinationJPA destinationJPA = DestinationJPA.builder()
                        .name(destination)
                        .build();
                this.destinationRepository.save(destinationJPA);
            });
        }
    }

}
