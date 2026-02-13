package medtrajet.backend.infrastructure.gateways.trips.start;

import medtrajet.backend.domain.entities.Trip;

public interface StartTripGateway {

    public void start(Trip trip);

}
