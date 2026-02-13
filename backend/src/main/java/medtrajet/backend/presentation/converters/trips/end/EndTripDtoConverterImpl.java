package medtrajet.backend.presentation.converters.trips.end;

import medtrajet.backend.domain.entities.Trip;
import medtrajet.backend.presentation.dtos.trips.EndTripDTO;

public class EndTripDtoConverterImpl implements EndTripDtoConverter {

    @Override
    public Trip fromDto(EndTripDTO endTripDTO) {
        return Trip.builder()
                .id(endTripDTO.id())
                .endMileage(endTripDTO.endMileage())
                .build();
    }

    @Override
    public EndTripDTO toDto(Trip trip) {
        return EndTripDTO.builder()
                .id(trip.getId())
                .endMileage(trip.getEndMileage())
                .build();
    }

}
