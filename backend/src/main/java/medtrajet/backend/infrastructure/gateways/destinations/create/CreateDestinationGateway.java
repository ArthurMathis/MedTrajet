package medtrajet.backend.infrastructure.gateways.destinations.create;

import medtrajet.backend.domain.entities.Destination;

public interface CreateDestinationGateway {

    public Long create(Destination destination);
}
