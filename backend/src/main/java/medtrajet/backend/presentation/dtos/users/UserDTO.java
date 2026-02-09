package medtrajet.backend.presentation.dtos.users;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserDTO(long id, String email, boolean isAdmin, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
