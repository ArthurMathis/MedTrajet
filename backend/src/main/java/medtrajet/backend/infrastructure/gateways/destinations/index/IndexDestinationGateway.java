package medtrajet.backend.infrastructure.gateways.destinations.index;

import medtrajet.backend.domain.entities.Destination;

import java.util.List;

/**
 * @interface IndexDestinationGateway
 */
public interface IndexDestinationGateway {

    /**
     * Public method that return the list of destinations
     *
     * @return The list of destinations
     */
    public List<Destination> index();
}
