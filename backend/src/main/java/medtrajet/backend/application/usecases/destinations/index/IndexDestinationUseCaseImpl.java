package medtrajet.backend.application.usecases.destinations.index;

import lombok.AllArgsConstructor;
import medtrajet.backend.domain.entities.Destination;
import medtrajet.backend.infrastructure.gateways.destinations.index.IndexDestinationGateway;

import java.util.List;

@AllArgsConstructor
public class IndexDestinationUseCaseImpl implements IndexDestinationUseCase {

    private final IndexDestinationGateway indexDestinationGateway;

    @Override
    public List<Destination> execute(Void unused) {
        return this.indexDestinationGateway.index();
    }

}
