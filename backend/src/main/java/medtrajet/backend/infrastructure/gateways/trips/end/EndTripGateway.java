package medtrajet.backend.infrastructure.gateways.trips.end;

import medtrajet.backend.domain.entities.Trip;

public interface EndTripGateway {

    public void end(Trip trip);
}
