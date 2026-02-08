package medtrajet.backend.application.usecases.destinations.create;

import lombok.AllArgsConstructor;
import medtrajet.backend.infrastructure.gateways.destinations.create.CreateDestinationGateway;
import medtrajet.backend.presentation.converters.destinations.create.CreateDestinationDtoConverter;
import medtrajet.backend.presentation.dtos.destinations.CreateDestinationDTO;

@AllArgsConstructor
public class CreateDestinationUseCaseImpl implements CreateDestinationUseCase {

    private final CreateDestinationGateway createDestinationGateway;
    private final CreateDestinationDtoConverter createDestinationDtoConverter;

    @Override
    public Long execute(CreateDestinationDTO createDestinationDTO) {
        return this.createDestinationGateway.create(this.createDestinationDtoConverter.fromDto(createDestinationDTO));
    }

}
