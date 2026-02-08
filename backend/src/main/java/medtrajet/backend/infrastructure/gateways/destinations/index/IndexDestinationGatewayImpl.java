package medtrajet.backend.infrastructure.gateways.destinations.index;

import lombok.AllArgsConstructor;
import medtrajet.backend.domain.entities.Destination;
import medtrajet.backend.domain.repositories.DestinationRepository;
import medtrajet.backend.infrastructure.converters.destinations.DestinationConverter;

import java.util.List;

@AllArgsConstructor
public class IndexDestinationGatewayImpl implements IndexDestinationGateway {

    private DestinationRepository destinationRepository;
    private DestinationConverter destinationConverter;

    @Override
    public List<Destination> index() {
        return this.destinationRepository.findAll().stream().map(this.destinationConverter::toDto).toList();
    }

}
