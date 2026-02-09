package medtrajet.backend.application.usecases;

import medtrajet.backend.application.usecases.destinations.create.CreateDestinationUseCase;
import medtrajet.backend.application.usecases.destinations.create.CreateDestinationUseCaseImpl;
import medtrajet.backend.application.usecases.destinations.index.IndexDestinationUseCase;
import medtrajet.backend.application.usecases.destinations.index.IndexDestinationUseCaseImpl;
import medtrajet.backend.application.usecases.users.authenticate.AuthenticateUserUseCase;
import medtrajet.backend.application.usecases.users.authenticate.AuthenticateUserUseCaseImpl;
import medtrajet.backend.application.usecases.users.get.GetUserUseCase;
import medtrajet.backend.application.usecases.users.get.GetUserUseCaseImpl;
import medtrajet.backend.infrastructure.gateways.destinations.create.CreateDestinationGateway;
import medtrajet.backend.infrastructure.gateways.destinations.index.IndexDestinationGateway;
import medtrajet.backend.infrastructure.gateways.users.authenticate.AuthenticateUserGateway;
import medtrajet.backend.infrastructure.gateways.users.get.GetUserGateway;
import medtrajet.backend.infrastructure.security.jwt.JwtProvider;
import medtrajet.backend.presentation.converters.destinations.create.CreateDestinationDtoConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UseCaseConfig {

    // * USER * //
    @Bean
    public AuthenticateUserUseCase authenticateUserUseCase(AuthenticateUserGateway authenticateUserGateway, PasswordEncoder passwordEncoder, JwtProvider jwtProvider) {
        return new AuthenticateUserUseCaseImpl(authenticateUserGateway, passwordEncoder, jwtProvider);
    }

    @Bean
    public GetUserUseCase getUserUseCase(GetUserGateway getUserGateway) {
        return new GetUserUseCaseImpl(getUserGateway);
    }

    // * DESTINATION * //
    @Bean
    public IndexDestinationUseCase indexDestinationUseCase(IndexDestinationGateway indexDestinationGateway) {
        return new IndexDestinationUseCaseImpl(indexDestinationGateway);
    }

    @Bean
    public CreateDestinationUseCase createDestinationUseCase(CreateDestinationGateway createDestinationGateway, CreateDestinationDtoConverter createDestinationDtoConverter) {
        return new CreateDestinationUseCaseImpl(createDestinationGateway, createDestinationDtoConverter);
    }
}
