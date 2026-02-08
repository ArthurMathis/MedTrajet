package medtrajet.backend.application.services;

import lombok.AllArgsConstructor;
import medtrajet.backend.presentation.dtos.authentifications.AuthToken;
import medtrajet.backend.presentation.dtos.users.LoginUserDTO;
import medtrajet.backend.application.usecases.users.authenticate.AuthenticateUserUseCase;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final AuthenticateUserUseCase authenticateUserUseCase;

    public AuthToken authenticate(LoginUserDTO loginUserDTO) {
        return this.authenticateUserUseCase.execute(loginUserDTO);
    }

}
