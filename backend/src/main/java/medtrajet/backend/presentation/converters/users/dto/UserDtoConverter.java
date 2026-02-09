package medtrajet.backend.presentation.converters.users.dto;

import medtrajet.backend.core.Converter;
import medtrajet.backend.domain.entities.User;
import medtrajet.backend.presentation.dtos.users.UserDTO;

public interface UserDtoConverter extends Converter<User, UserDTO> {
}
