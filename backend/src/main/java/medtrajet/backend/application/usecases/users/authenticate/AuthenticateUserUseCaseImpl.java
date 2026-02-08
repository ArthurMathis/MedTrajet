package medtrajet.backend.application.usecases.users.authenticate;

import lombok.AllArgsConstructor;
import medtrajet.backend.presentation.dtos.authentifications.AuthToken;
import medtrajet.backend.presentation.dtos.authentifications.TokenUserData;
import medtrajet.backend.presentation.dtos.users.LoginUserDTO;
import medtrajet.backend.application.exceptions.InvalidAuthentificationException;
import medtrajet.backend.domain.entities.User;
import medtrajet.backend.infrastructure.gateways.users.authenticate.AuthenticateUserGateway;
import medtrajet.backend.infrastructure.security.jwt.JwtProvider;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@AllArgsConstructor
public class AuthenticateUserUseCaseImpl implements AuthenticateUserUseCase {

    private static final String errorMessage = "Authentication failed. Please check your login credentials.";

    private final AuthenticateUserGateway authenticateUserGateway;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    public AuthToken execute(LoginUserDTO loginUserDTO) {
        User user = Optional.ofNullable(
                this.authenticateUserGateway.getByEmail(loginUserDTO.email())
        ).orElseThrow(() -> new InvalidAuthentificationException(errorMessage));

        if(!this.passwordEncoder.matches(loginUserDTO.password(), user.getPassword())) {
            throw new InvalidAuthentificationException(errorMessage);
        }

        TokenUserData tokenUserData = TokenUserData.builder()
                .userId(user.getId())
                .build();
        return this.jwtProvider.generateToken(tokenUserData);
    }

}
