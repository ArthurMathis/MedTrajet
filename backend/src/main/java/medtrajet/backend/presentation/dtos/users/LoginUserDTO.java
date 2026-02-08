package medtrajet.backend.presentation.dtos.users;

import lombok.Builder;

@Builder
public record LoginUserDTO(String email, String password) {
}
