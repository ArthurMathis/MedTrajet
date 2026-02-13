package medtrajet.backend.application.usecases.trips.start;

import lombok.AllArgsConstructor;
import medtrajet.backend.application.exceptions.trips.TripAlreadyInProgressException;
import medtrajet.backend.domain.entities.Trip;
import medtrajet.backend.infrastructure.gateways.trips.current.GetCurrentTripGateway;
import medtrajet.backend.infrastructure.gateways.trips.start.StartTripGateway;

@AllArgsConstructor
public class StartTripUseCaseImpl implements StartTripUseCase {

    private final GetCurrentTripGateway getCurrentTripGateway;
    private final StartTripGateway startTripGateway;

    @Override
    public Void execute(Trip trip) {
        this.getCurrentTripGateway.get(trip.getUserId()).ifPresent(existingTrip -> {
            throw new TripAlreadyInProgressException(trip.getUserId());
        });
        this.startTripGateway.start(trip);
        return null;
    }
}
