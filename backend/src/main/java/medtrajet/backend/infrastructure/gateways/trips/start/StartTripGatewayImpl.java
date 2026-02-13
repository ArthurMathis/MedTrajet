package medtrajet.backend.infrastructure.gateways.trips.start;

import lombok.AllArgsConstructor;
import medtrajet.backend.domain.entities.Trip;
import medtrajet.backend.domain.repositories.TripRepository;
import medtrajet.backend.infrastructure.converters.trips.TripConverter;
import medtrajet.backend.infrastructure.jpa.TripJPA;

@AllArgsConstructor
public class StartTripGatewayImpl implements StartTripGateway {

    private final TripRepository tripRepository;
    private final TripConverter tripConverter;

    @Override
    public void start(Trip trip) {
        TripJPA tripJPA = this.tripConverter.fromDto(trip);
        this.tripRepository.save(tripJPA);
    }

}
