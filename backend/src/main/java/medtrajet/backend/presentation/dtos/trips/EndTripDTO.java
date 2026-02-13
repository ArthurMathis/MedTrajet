package medtrajet.backend.presentation.dtos.trips;

import lombok.Builder;

@Builder
public record EndTripDTO(Long id, Long endMileage) {
}
