package medtrajet.backend.presentation.converters;

import medtrajet.backend.presentation.converters.destinations.create.CreateDestinationDtoConverter;
import medtrajet.backend.presentation.converters.destinations.create.CreateDestinationDtoConverterImpl;
import medtrajet.backend.presentation.converters.destinations.dto.DestinationDtoConverter;
import medtrajet.backend.presentation.converters.destinations.dto.DestinationDtoConverterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PresentationConverterConfig {

    // * DESTINATION * //
    @Bean
    public DestinationDtoConverter destinationDtoConverter() {
        return new DestinationDtoConverterImpl();
    }

    @Bean
    public CreateDestinationDtoConverter createDestinationDtoConverter() {
        return new CreateDestinationDtoConverterImpl();
    }

}
