package medtrajet.backend.infrastructure.gateways.users.get;

import medtrajet.backend.domain.entities.User;

public interface GetUserGateway {

    /**
     * Public method that gets a user by his id
     *
     * @param userId The user's id
     * @return The user
     */
    public User get(long userId);
}
