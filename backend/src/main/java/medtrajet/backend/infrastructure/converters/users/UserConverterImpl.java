package medtrajet.backend.infrastructure.converters.users;

import medtrajet.backend.domain.entities.User;
import medtrajet.backend.infrastructure.jpa.UserJPA;

public class UserConverterImpl implements UserConverter {

    @Override
    public UserJPA fromDto(User user) {
        return UserJPA.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .isAdmin(user.getIsAdmin())
                .build();
    }

    @Override
    public User toDto(UserJPA userJPA) {
        return User.builder()
                .id(userJPA.getId())
                .email(userJPA.getEmail())
                .password(userJPA.getPassword())
                .isAdmin(userJPA.getIsAdmin())
                .build();
    }

}
