package medtrajet.backend.application.services;

import lombok.AllArgsConstructor;
import medtrajet.backend.application.usecases.trips.current.GetCurrentTripUseCase;
import medtrajet.backend.application.usecases.trips.end.EndTripUseCase;
import medtrajet.backend.application.usecases.trips.start.StartTripUseCase;
import medtrajet.backend.domain.entities.Trip;
import medtrajet.backend.presentation.converters.trips.dto.TripDtoConverter;
import medtrajet.backend.presentation.converters.trips.start.StartTripDtoConverter;
import medtrajet.backend.presentation.dtos.trips.EndTripDTO;
import medtrajet.backend.presentation.dtos.trips.StartTripDTO;
import medtrajet.backend.presentation.dtos.trips.TripDTO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TripService {

    private final GetCurrentTripUseCase getCurrentTripUseCase;
    private final StartTripUseCase startTripUseCase;
    private final EndTripUseCase endTripUseCase;

    private final TripDtoConverter tripDtoConverter;
    private final StartTripDtoConverter startTripDtoConverter;

    public TripDTO getCurrent(Long userId) {
        Trip trip = this.getCurrentTripUseCase.execute(userId);
        if (trip == null) {
            return null;
        }
        return this.tripDtoConverter.toDto(trip);
    }

    public void start(StartTripDTO trip) {
        this.startTripUseCase.execute(this.startTripDtoConverter.fromDto(trip));
    }

    public void end(EndTripDTO trip) {
        this.endTripUseCase.execute(trip);
    }

}
