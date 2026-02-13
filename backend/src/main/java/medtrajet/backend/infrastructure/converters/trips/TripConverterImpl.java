package medtrajet.backend.infrastructure.converters.trips;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import medtrajet.backend.domain.entities.Trip;
import medtrajet.backend.domain.repositories.DestinationRepository;
import medtrajet.backend.domain.repositories.UserRepository;
import medtrajet.backend.infrastructure.jpa.DestinationJPA;
import medtrajet.backend.infrastructure.jpa.TripJPA;
import medtrajet.backend.infrastructure.jpa.UserJPA;

@AllArgsConstructor
public class TripConverterImpl implements TripConverter {

    private final UserRepository userRepository;
    private final DestinationRepository destinationRepository;

    @Override
    public TripJPA fromDto(Trip trip) {
        UserJPA user = this.userRepository.findById(trip.getUserId()).orElseThrow(() -> {
            return new EntityNotFoundException("User not found");
        });

        DestinationJPA destination = this.destinationRepository.findById(trip.getDestinationId()).orElseThrow(() -> {
            return new EntityNotFoundException("Destination not found");
        });

        return TripJPA.builder()
                .id(trip.getId())
                .user(user)
                .destination(destination)
                .startMileage(trip.getStartMileage())
                .endMileage(trip.getEndMileage())
                .startedAt(trip.getStartedAt())
                .endedAt(trip.getEndedAt())
                .build();
    }

    @Override
    public Trip toDto(TripJPA tripJPA) {
        return Trip.builder()
                .id(tripJPA.getId())
                .userId(tripJPA.getUser().getId())
                .destinationId(tripJPA.getDestination().getId())
                .startMileage(tripJPA.getStartMileage())
                .endMileage(tripJPA.getEndMileage())
                .startedAt(tripJPA.getStartedAt())
                .endedAt(tripJPA.getEndedAt())
                .build();
    }

}
