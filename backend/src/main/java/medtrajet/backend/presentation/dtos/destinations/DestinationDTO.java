package medtrajet.backend.presentation.dtos.destinations;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record DestinationDTO(Long id, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
