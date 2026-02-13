package medtrajet.backend.infrastructure.gateways.trips.current;

import lombok.AllArgsConstructor;
import medtrajet.backend.domain.entities.Trip;
import medtrajet.backend.domain.repositories.TripRepository;
import medtrajet.backend.infrastructure.converters.trips.TripConverter;
import java.util.Optional;

@AllArgsConstructor
public class GetCurrentTripGatewayImpl implements GetCurrentTripGateway {

    private final TripRepository tripRepository;
    private final TripConverter tripConverter;

    @Override
    public Optional<Trip> get(Long userId) {
        return this.tripRepository.findByUserIdAndEndedAtIsNull(userId)
                .map(this.tripConverter::toDto);
    }

}
