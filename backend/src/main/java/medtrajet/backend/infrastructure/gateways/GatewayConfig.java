package medtrajet.backend.infrastructure.gateways;

import medtrajet.backend.domain.repositories.UserRepository;
import medtrajet.backend.infrastructure.converters.users.UserConverter;
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

}
