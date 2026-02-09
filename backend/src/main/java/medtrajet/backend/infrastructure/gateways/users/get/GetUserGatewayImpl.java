package medtrajet.backend.infrastructure.gateways.users.get;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import medtrajet.backend.domain.entities.User;
import medtrajet.backend.domain.repositories.UserRepository;
import medtrajet.backend.infrastructure.converters.users.UserConverter;
import medtrajet.backend.infrastructure.jpa.UserJPA;

import java.util.Optional;

@AllArgsConstructor
public class GetUserGatewayImpl implements GetUserGateway {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public User get(long userId) {
        UserJPA fetchedUser = this.userRepository.findById(userId).orElseThrow(() -> {
            return new EntityNotFoundException("User not found");
        });
        return this.userConverter.toDto(fetchedUser);
    }

}
