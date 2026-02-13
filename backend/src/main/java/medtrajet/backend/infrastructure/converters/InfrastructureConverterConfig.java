package medtrajet.backend.infrastructure.converters;

import medtrajet.backend.domain.repositories.DestinationRepository;
import medtrajet.backend.domain.repositories.UserRepository;
import medtrajet.backend.infrastructure.converters.destinations.DestinationConverter;
import medtrajet.backend.infrastructure.converters.destinations.DestinationConverterImpl;
import medtrajet.backend.infrastructure.converters.trips.TripConverter;
import medtrajet.backend.infrastructure.converters.trips.TripConverterImpl;
import medtrajet.backend.infrastructure.converters.users.UserConverter;
import medtrajet.backend.infrastructure.converters.users.UserConverterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfrastructureConverterConfig {

    // * USER * //
    @Bean
    public UserConverter userConverter() {
        return new UserConverterImpl();
    }

    // * DESTINATION * //
    @Bean
    public DestinationConverter destinationConverter() {
        return new DestinationConverterImpl();
    }

    // * TRIP $ //
    @Bean
    public TripConverter tripConverter(UserRepository userRepository, DestinationRepository destinationRepository) {
        return new TripConverterImpl(userRepository, destinationRepository);
    }

}
