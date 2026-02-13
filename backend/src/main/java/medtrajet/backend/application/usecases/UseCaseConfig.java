package medtrajet.backend.application.usecases;

import medtrajet.backend.application.usecases.destinations.create.CreateDestinationUseCase;
import medtrajet.backend.application.usecases.destinations.create.CreateDestinationUseCaseImpl;
import medtrajet.backend.application.usecases.destinations.get.GetDestinationUseCase;
import medtrajet.backend.application.usecases.destinations.get.GetDestinationUseCaseImpl;
import medtrajet.backend.application.usecases.destinations.index.IndexDestinationUseCase;
import medtrajet.backend.application.usecases.destinations.index.IndexDestinationUseCaseImpl;
import medtrajet.backend.application.usecases.trips.current.GetCurrentTripUseCase;
import medtrajet.backend.application.usecases.trips.current.GetCurrentTripUseCaseImpl;
import medtrajet.backend.application.usecases.trips.start.StartTripUseCase;
import medtrajet.backend.application.usecases.trips.start.StartTripUseCaseImpl;
import medtrajet.backend.application.usecases.users.authenticate.AuthenticateUserUseCase;
import medtrajet.backend.application.usecases.users.authenticate.AuthenticateUserUseCaseImpl;
import medtrajet.backend.application.usecases.users.get.GetUserUseCase;
import medtrajet.backend.application.usecases.users.get.GetUserUseCaseImpl;
import medtrajet.backend.infrastructure.gateways.destinations.create.CreateDestinationGateway;
import medtrajet.backend.infrastructure.gateways.destinations.get.GetDestinationGateway;
import medtrajet.backend.infrastructure.gateways.destinations.index.IndexDestinationGateway;
import medtrajet.backend.infrastructure.gateways.trips.current.GetCurrentTripGateway;
import medtrajet.backend.infrastructure.gateways.trips.start.StartTripGateway;
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
    public GetDestinationUseCase getDestinationUseCase(GetDestinationGateway getDestinationGateway) {
        return new GetDestinationUseCaseImpl(getDestinationGateway);
    }

    @Bean
    public CreateDestinationUseCase createDestinationUseCase(CreateDestinationGateway createDestinationGateway, CreateDestinationDtoConverter createDestinationDtoConverter) {
        return new CreateDestinationUseCaseImpl(createDestinationGateway, createDestinationDtoConverter);
    }

    // * TRIP * //
    @Bean
    public GetCurrentTripUseCase getCurrentTripUseCase(GetCurrentTripGateway getCurrentTripGateway) {
        return new GetCurrentTripUseCaseImpl(getCurrentTripGateway);
    }

    @Bean
    public StartTripUseCase startTripUseCase(GetCurrentTripGateway getCurrentTripGateway, StartTripGateway startTripGateway) {
        return new StartTripUseCaseImpl(getCurrentTripGateway, startTripGateway);
    }
}
