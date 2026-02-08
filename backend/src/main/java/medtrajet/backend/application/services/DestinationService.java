package medtrajet.backend.application.services;

import lombok.AllArgsConstructor;
import medtrajet.backend.application.usecases.destinations.index.IndexDestinationUseCase;
import medtrajet.backend.presentation.converters.destinations.dto.DestinationDtoConverter;
import medtrajet.backend.presentation.dtos.destinations.DestinationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DestinationService {

    private final IndexDestinationUseCase indexDestinationUseCase;
    private final DestinationDtoConverter destinationDtoConverter;

    public List<DestinationDTO> index() {
        return this.indexDestinationUseCase.execute(null).stream().map(this.destinationDtoConverter::toDto).toList();
    }

    // todo : create

}
