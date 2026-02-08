package medtrajet.backend.application.usecases.users.authenticate;

import medtrajet.backend.presentation.dtos.authentifications.AuthToken;
import medtrajet.backend.presentation.dtos.users.LoginUserDTO;
import medtrajet.backend.core.UseCase;

public interface AuthenticateUserUseCase extends UseCase<LoginUserDTO, AuthToken> {
}
