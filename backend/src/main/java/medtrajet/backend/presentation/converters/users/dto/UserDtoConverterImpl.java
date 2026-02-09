package medtrajet.backend.presentation.converters.users.dto;

import medtrajet.backend.domain.entities.User;
import medtrajet.backend.presentation.dtos.users.UserDTO;

public class UserDtoConverterImpl implements UserDtoConverter {

    @Override
    public User fromDto(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.id())
                .email(userDTO.email())
                .isAdmin(userDTO.isAdmin())
                .createdAt(userDTO.createdAt())
                .updatedAt(userDTO.updatedAt())
                .build();
    }

    @Override
    public UserDTO toDto(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .isAdmin(user.getIsAdmin())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
