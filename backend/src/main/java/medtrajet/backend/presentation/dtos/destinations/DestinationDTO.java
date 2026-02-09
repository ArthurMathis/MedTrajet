package medtrajet.backend.presentation.dtos.destinations;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record DestinationDTO(long id, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
