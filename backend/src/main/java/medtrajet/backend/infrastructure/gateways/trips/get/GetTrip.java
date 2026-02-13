package medtrajet.backend.infrastructure.gateways.trips.get;

import medtrajet.backend.domain.entities.Trip;

public interface GetTrip {

    public Trip get(Long tripId);
}
