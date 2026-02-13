package medtrajet.backend.presentation.dtos.trips;

import lombok.Builder;

@Builder
public record StartTripDTO(Long userId, Long destinationId, Long startMileage) {
}
