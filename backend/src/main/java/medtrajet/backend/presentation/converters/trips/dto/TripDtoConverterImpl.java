package medtrajet.backend.presentation.converters.trips.dto;

import medtrajet.backend.domain.entities.Trip;
import medtrajet.backend.presentation.dtos.trips.TripDTO;

public class TripDtoConverterImpl implements TripDtoConverter {

    @Override
    public Trip fromDto(TripDTO tripDTO) {
        return Trip.builder()
                .id(tripDTO.id())
                .userId(tripDTO.userId())
                .destinationId(tripDTO.destinationId())
                .startMileage(tripDTO.startMileage())
                .endMileage(tripDTO.endMileage())
                .startedAt(tripDTO.startedAt())
                .endedAt(tripDTO.endedAt())
                .build();
    }

    @Override
    public TripDTO toDto(Trip trip) {
        return TripDTO.builder()
                .id(trip.getId())
                .userId(trip.getUserId())
                .destinationId(trip.getDestinationId())
                .startMileage(trip.getStartMileage())
                .endMileage(trip.getEndMileage())
                .startedAt(trip.getStartedAt())
                .endedAt(trip.getEndedAt())
                .build();
    }

}
