package medtrajet.backend.application.services;

import lombok.AllArgsConstructor;
import medtrajet.backend.application.usecases.destinations.create.CreateDestinationUseCase;
import medtrajet.backend.application.usecases.destinations.get.GetDestinationUseCase;
import medtrajet.backend.application.usecases.destinations.index.IndexDestinationUseCase;
import medtrajet.backend.presentation.converters.destinations.dto.DestinationDtoConverter;
import medtrajet.backend.presentation.dtos.destinations.CreateDestinationDTO;
import medtrajet.backend.presentation.dtos.destinations.DestinationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DestinationService {

    private final IndexDestinationUseCase indexDestinationUseCase;
    private final GetDestinationUseCase getDestinationUseCase;
    private final CreateDestinationUseCase createDestinationUseCase;

    private final DestinationDtoConverter destinationDtoConverter;

    public List<DestinationDTO> index() {
        return this.indexDestinationUseCase.execute(null).stream().map(this.destinationDtoConverter::toDto).toList();
    }

    public DestinationDTO get(long destinationId) {
        return this.destinationDtoConverter.toDto(
                this.getDestinationUseCase.execute(destinationId)
        );
    }

    public Long create(CreateDestinationDTO createDestinationDTO) {
        return this.createDestinationUseCase.execute(createDestinationDTO);
    }

}
