package medtrajet.backend.presentation.dtos.authentifications;

import lombok.Builder;

@Builder
public record AuthToken(String token) {
}
