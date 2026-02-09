package medtrajet.backend.infrastructure.gateways.users.authenticate;

import medtrajet.backend.domain.entities.User;

/**
 * @interface AuthenticateUserGateway
 */
public interface AuthenticateUserGateway {

    /**
     * Public method that gets a user from his email
     *
     * @param email The searched email
     * @return The user
     */
    public User getByEmail(String email);

}
