package medtrajet.backend.infrastructure.gateways.trips.end;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import medtrajet.backend.domain.entities.Trip;
import medtrajet.backend.domain.repositories.TripRepository;
import medtrajet.backend.infrastructure.jpa.TripJPA;

import java.time.LocalDateTime;

@AllArgsConstructor
public class EndTripGatewayImpl implements EndTripGateway {

    private final TripRepository tripRepository;

    @Override
    public void end(Trip trip) {
        TripJPA endedTrip = this.tripRepository.findById(trip.getId()).orElseThrow(() -> {
            return new EntityNotFoundException("Trip not found");
        });
        endedTrip.setEndMileage(trip.getEndMileage());
        endedTrip.setEndedAt(LocalDateTime.now());
        this.tripRepository.save(endedTrip);
    }

}
