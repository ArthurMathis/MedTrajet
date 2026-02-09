package medtrajet.backend.application.usecases.users.get;

import lombok.AllArgsConstructor;
import medtrajet.backend.domain.entities.User;
import medtrajet.backend.infrastructure.gateways.users.get.GetUserGateway;

@AllArgsConstructor
public class GetUserUseCaseImpl implements GetUserUseCase {

    private final GetUserGateway getUserGateway;

    @Override
    public User execute(Long userId) {
        return this.getUserGateway.get(userId);
    }

}
