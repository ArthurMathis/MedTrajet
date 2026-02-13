package medtrajet.backend.infrastructure.gateways.trips.current;

import medtrajet.backend.domain.entities.Trip;

import java.util.Optional;

public interface GetCurrentTripGateway {

    public Optional<Trip> get(Long userId);
}
