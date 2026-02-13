package medtrajet.backend.infrastructure.gateways.trips.get;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import medtrajet.backend.domain.entities.Trip;
import medtrajet.backend.domain.repositories.TripRepository;
import medtrajet.backend.infrastructure.converters.trips.TripConverter;
import medtrajet.backend.infrastructure.jpa.TripJPA;

@AllArgsConstructor
public class GetTripImpl implements GetTrip {

    private final TripRepository tripRepository;
    private final TripConverter tripConverter;

    @Override
    public Trip get(Long tripId) {
        TripJPA tripJpa = this.tripRepository.findById(tripId).orElseThrow(() -> {
            return new EntityNotFoundException("Trip not found");
        });
        return this.tripConverter.toDto(tripJpa);
    }

}
