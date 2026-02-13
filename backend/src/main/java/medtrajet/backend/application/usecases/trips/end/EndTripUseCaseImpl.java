package medtrajet.backend.application.usecases.trips.end;

import lombok.AllArgsConstructor;
import medtrajet.backend.application.exceptions.trips.InvalidEndMileageException;
import medtrajet.backend.application.exceptions.trips.TripAlreadyEndedException;
import medtrajet.backend.domain.entities.Trip;
import medtrajet.backend.infrastructure.gateways.trips.end.EndTripGateway;
import medtrajet.backend.infrastructure.gateways.trips.get.GetTrip;
import medtrajet.backend.presentation.converters.trips.end.EndTripDtoConverter;
import medtrajet.backend.presentation.dtos.trips.EndTripDTO;

@AllArgsConstructor
public class EndTripUseCaseImpl implements EndTripUseCase {

    private final EndTripGateway endTripGateway;
    private final EndTripDtoConverter endTripDtoConverter;
    private final GetTrip getTrip;

    @Override
    public Void execute(EndTripDTO endTripDTO) {
        Trip currentTrip = this.getTrip.get(endTripDTO.id());
        if(currentTrip.getEndMileage() != null) {
            throw new TripAlreadyEndedException(currentTrip.getId());
        }

        if(endTripDTO.endMileage() <= currentTrip.getStartMileage()) {
            throw new InvalidEndMileageException();
        }

        this.endTripGateway.end(this.endTripDtoConverter.fromDto(endTripDTO));
        return null;
    }

}
