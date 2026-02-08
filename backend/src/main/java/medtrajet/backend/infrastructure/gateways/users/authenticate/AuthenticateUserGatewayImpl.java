package medtrajet.backend.infrastructure.gateways.users.authenticate;

import lombok.AllArgsConstructor;
import medtrajet.backend.domain.entities.User;
import medtrajet.backend.domain.repositories.UserRepository;
import medtrajet.backend.infrastructure.converters.users.UserConverter;
import medtrajet.backend.infrastructure.jpa.UserJPA;

import java.util.Optional;

@AllArgsConstructor
public class AuthenticateUserGatewayImpl implements AuthenticateUserGateway {

    private final UserRepository userRepository;
    private final UserConverter userJPAConverter;

    @Override
    public User getByEmail(String email) {
        Optional<UserJPA> searchedUser = this.userRepository.findByEmail(email);
        return searchedUser.map(this.userJPAConverter::toDto).orElse(null);
    }

}
