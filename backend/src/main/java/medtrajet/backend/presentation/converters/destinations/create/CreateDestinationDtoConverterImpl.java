package medtrajet.backend.presentation.converters.destinations.create;

import medtrajet.backend.domain.entities.Destination;
import medtrajet.backend.presentation.dtos.destinations.CreateDestinationDTO;

public class CreateDestinationDtoConverterImpl implements CreateDestinationDtoConverter {

    @Override
    public Destination fromDto(CreateDestinationDTO createDestinationDTO) {
        return Destination.builder()
                .name(createDestinationDTO.name())
                .build();
    }

    @Override
    public CreateDestinationDTO toDto(Destination destination) {
        return CreateDestinationDTO.builder()
                .name(destination.getName())
                .build();
    }
}
