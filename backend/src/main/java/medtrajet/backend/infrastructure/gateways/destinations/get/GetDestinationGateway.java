package medtrajet.backend.infrastructure.gateways.destinations.get;

import medtrajet.backend.domain.entities.Destination;

public interface GetDestinationGateway {

    public Destination get(long destinationId);
}
