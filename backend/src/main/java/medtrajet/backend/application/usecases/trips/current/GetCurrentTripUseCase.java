package medtrajet.backend.application.usecases.trips.current;

import medtrajet.backend.core.UseCase;
import medtrajet.backend.domain.entities.Trip;

public interface GetCurrentTripUseCase extends UseCase<Long, Trip> {
}
