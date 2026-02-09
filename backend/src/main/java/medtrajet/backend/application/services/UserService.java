package medtrajet.backend.application.services;

import lombok.AllArgsConstructor;
import medtrajet.backend.application.usecases.users.get.GetUserUseCase;
import medtrajet.backend.presentation.converters.users.dto.UserDtoConverter;
import medtrajet.backend.presentation.dtos.authentifications.AuthToken;
import medtrajet.backend.presentation.dtos.users.LoginUserDTO;
import medtrajet.backend.application.usecases.users.authenticate.AuthenticateUserUseCase;
import medtrajet.backend.presentation.dtos.users.UserDTO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final AuthenticateUserUseCase authenticateUserUseCase;
    private final GetUserUseCase getUserUseCase;

    private final UserDtoConverter userDtoConverter;

    public AuthToken authenticate(LoginUserDTO loginUserDTO) {
        return this.authenticateUserUseCase.execute(loginUserDTO);
    }

    public UserDTO get(long userId) {
        return this.userDtoConverter.toDto(this.getUserUseCase.execute(userId));
    }

}
