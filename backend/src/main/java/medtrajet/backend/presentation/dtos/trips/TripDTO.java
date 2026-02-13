package medtrajet.backend.presentation.dtos.trips;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TripDTO(Long id, Long userId, Long destinationId, Long startMileage, Long endMileage, LocalDateTime startedAt, LocalDateTime endedAt) {
}
