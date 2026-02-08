package medtrajet.backend.infrastructure.converters.destinations;

import medtrajet.backend.core.Converter;
import medtrajet.backend.domain.entities.Destination;
import medtrajet.backend.infrastructure.jpa.DestinationJPA;

public interface DestinationConverter extends Converter<DestinationJPA, Destination> {
}
