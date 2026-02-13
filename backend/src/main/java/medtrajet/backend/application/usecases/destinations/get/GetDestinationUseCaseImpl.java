package medtrajet.backend.application.usecases.destinations.get;

import lombok.AllArgsConstructor;
import medtrajet.backend.domain.entities.Destination;
import medtrajet.backend.infrastructure.gateways.destinations.get.GetDestinationGateway;

@AllArgsConstructor
public class GetDestinationUseCaseImpl implements GetDestinationUseCase {

    private final GetDestinationGateway getDestinationGateway;

    @Override
    public Destination execute(Long destinationId) {
        return this.getDestinationGateway.get(destinationId);
    }

}
