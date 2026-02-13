package medtrajet.backend.application.usecases.trips.current;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import medtrajet.backend.domain.entities.Trip;
import medtrajet.backend.infrastructure.gateways.trips.current.GetCurrentTripGateway;

@AllArgsConstructor
public class GetCurrentTripUseCaseImpl implements GetCurrentTripUseCase {

    private final GetCurrentTripGateway getCurrentTripGateway;

    @Override
    public Trip execute(Long userId) {
        return this.getCurrentTripGateway.get(userId).orElse(null);
    }

}
