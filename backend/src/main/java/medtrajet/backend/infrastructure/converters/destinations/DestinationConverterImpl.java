package medtrajet.backend.infrastructure.converters.destinations;

import medtrajet.backend.domain.entities.Destination;
import medtrajet.backend.infrastructure.jpa.DestinationJPA;

public class DestinationConverterImpl implements DestinationConverter {

    @Override
    public DestinationJPA fromDto(Destination destination) {
        return DestinationJPA.builder()
                .id(destination.getId())
                .name(destination.getName())
                .createdAt(destination.getCreatedAt())
                .updatedAt(destination.getUpdatedAt())
                .build();
    }

    @Override
    public Destination toDto(DestinationJPA destinationJPA) {
        return Destination.builder()
                .id(destinationJPA.getId())
                .name(destinationJPA.getName())
                .createdAt(destinationJPA.getCreatedAt())
                .updatedAt(destinationJPA.getUpdatedAt())
                .build();
    }

}
