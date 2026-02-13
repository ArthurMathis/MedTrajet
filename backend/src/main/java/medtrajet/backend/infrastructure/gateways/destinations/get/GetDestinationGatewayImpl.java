package medtrajet.backend.infrastructure.gateways.destinations.get;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import medtrajet.backend.domain.entities.Destination;
import medtrajet.backend.domain.repositories.DestinationRepository;
import medtrajet.backend.infrastructure.converters.destinations.DestinationConverter;
import medtrajet.backend.infrastructure.jpa.DestinationJPA;

@AllArgsConstructor
public class GetDestinationGatewayImpl implements GetDestinationGateway {

    private final DestinationRepository destinationRepository;
    private final DestinationConverter destinationConverter;

    @Override
    public Destination get(long destinationId) {
        DestinationJPA destination = this.destinationRepository.findById(destinationId).orElseThrow(() -> {
            return new EntityNotFoundException("Destination not found");
        });
        return this.destinationConverter.toDto(destination);
    }

}
