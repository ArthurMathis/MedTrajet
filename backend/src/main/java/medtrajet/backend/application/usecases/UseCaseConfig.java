package medtrajet.backend.application.usecases;

import medtrajet.backend.application.usecases.users.authenticate.AuthenticateUserUseCase;
import medtrajet.backend.application.usecases.users.authenticate.AuthenticateUserUseCaseImpl;
import medtrajet.backend.infrastructure.gateways.users.authenticate.AuthenticateUserGateway;
import medtrajet.backend.infrastructure.security.jwt.JwtProvider;
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
}
