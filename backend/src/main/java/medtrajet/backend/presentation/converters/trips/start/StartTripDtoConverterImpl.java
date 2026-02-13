package medtrajet.backend.presentation.converters.trips.start;

import medtrajet.backend.domain.entities.Trip;
import medtrajet.backend.presentation.dtos.trips.StartTripDTO;

public class StartTripDtoConverterImpl implements StartTripDtoConverter {

    @Override
    public Trip fromDto(StartTripDTO startTripDTO) {
        return Trip.builder()
                .userId(startTripDTO.userId())
                .destinationId(startTripDTO.destinationId())
                .startMileage(startTripDTO.startMileage())
                .build();
    }

    @Override
    public StartTripDTO toDto(Trip trip) {
        return StartTripDTO.builder()
                .userId(trip.getUserId())
                .destinationId(trip.getDestinationId())
                .startMileage(trip.getStartMileage())
                .build();
    }

}
