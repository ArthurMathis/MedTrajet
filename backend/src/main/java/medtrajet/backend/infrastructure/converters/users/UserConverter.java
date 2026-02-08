package medtrajet.backend.infrastructure.converters.users;

import medtrajet.backend.core.Converter;
import medtrajet.backend.domain.entities.User;
import medtrajet.backend.infrastructure.jpa.UserJPA;

public interface UserConverter extends Converter<UserJPA, User> {
}
