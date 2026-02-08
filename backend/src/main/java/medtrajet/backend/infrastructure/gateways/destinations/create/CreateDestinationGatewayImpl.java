package medtrajet.backend.infrastructure.gateways.destinations.create;

import lombok.AllArgsConstructor;
import medtrajet.backend.domain.entities.Destination;
import medtrajet.backend.domain.repositories.DestinationRepository;
import medtrajet.backend.infrastructure.converters.destinations.DestinationConverter;
import medtrajet.backend.infrastructure.jpa.DestinationJPA;

@AllArgsConstructor
public class CreateDestinationGatewayImpl implements CreateDestinationGateway {

    private final DestinationRepository destinationRepository;
    private final DestinationConverter destinationConverter;

    @Override
    public Long create(Destination destination) {
        DestinationJPA destinationJPA = this.destinationConverter.fromDto(destination);
        return this.destinationRepository.save(destinationJPA).getId();
    }

}
