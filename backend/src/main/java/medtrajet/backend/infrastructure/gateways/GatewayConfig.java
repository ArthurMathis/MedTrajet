package medtrajet.backend.infrastructure.gateways;

import medtrajet.backend.domain.repositories.DestinationRepository;
import medtrajet.backend.domain.repositories.UserRepository;
import medtrajet.backend.infrastructure.converters.destinations.DestinationConverter;
import medtrajet.backend.infrastructure.converters.users.UserConverter;
import medtrajet.backend.infrastructure.gateways.destinations.create.CreateDestinationGateway;
import medtrajet.backend.infrastructure.gateways.destinations.create.CreateDestinationGatewayImpl;
import medtrajet.backend.infrastructure.gateways.destinations.index.IndexDestinationGateway;
import medtrajet.backend.infrastructure.gateways.destinations.index.IndexDestinationGatewayImpl;
import medtrajet.backend.infrastructure.gateways.users.authenticate.AuthenticateUserGateway;
import medtrajet.backend.infrastructure.gateways.users.authenticate.AuthenticateUserGatewayImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    // * USER * //
    @Bean
    public AuthenticateUserGateway authenticateUserGateway(UserRepository userRepository, UserConverter userJPAConverter) {
        return new AuthenticateUserGatewayImpl(userRepository, userJPAConverter);
    }

    // * DESTINATION * //
    @Bean
    public IndexDestinationGateway indexDestinationGateway(DestinationRepository destinationRepository, DestinationConverter destinationConverter) {
        return new IndexDestinationGatewayImpl(destinationRepository, destinationConverter);
    }

    @Bean
    public CreateDestinationGateway createDestinationGateway(DestinationRepository destinationRepository, DestinationConverter destinationConverter) {
        return new CreateDestinationGatewayImpl(destinationRepository, destinationConverter);
    }

}
