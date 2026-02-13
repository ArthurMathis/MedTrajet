package medtrajet.backend.infrastructure.converters.trips;

import medtrajet.backend.core.Converter;
import medtrajet.backend.domain.entities.Trip;
import medtrajet.backend.infrastructure.jpa.TripJPA;

public interface TripConverter extends Converter<TripJPA, Trip> {
}
