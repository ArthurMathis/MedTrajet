package medtrajet.backend.presentation.converters.destinations.dto;

import medtrajet.backend.domain.entities.Destination;
import medtrajet.backend.presentation.dtos.destinations.DestinationDTO;

public class DestinationDtoConverterImpl implements DestinationDtoConverter {

    @Override
    public Destination fromDto(DestinationDTO destinationDTO) {
        return Destination.builder()
                .id(destinationDTO.id())
                .name(destinationDTO.name())
                .createdAt(destinationDTO.createdAt())
                .updatedAt(destinationDTO.updatedAt())
                .build();
    }

    @Override
    public DestinationDTO toDto(Destination destination) {
        return DestinationDTO.builder()
                .id(destination.getId())
                .name(destination.getName())
                .createdAt(destination.getCreatedAt())
                .updatedAt(destination.getUpdatedAt())
                .build();
    }

}
