package medtrajet.backend.infrastructure.converters;

import medtrajet.backend.infrastructure.converters.destinations.DestinationConverter;
import medtrajet.backend.infrastructure.converters.destinations.DestinationConverterImpl;
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

}
