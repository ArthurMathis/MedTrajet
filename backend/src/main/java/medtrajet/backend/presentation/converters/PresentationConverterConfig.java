package medtrajet.backend.presentation.converters;

import medtrajet.backend.presentation.converters.destinations.create.CreateDestinationDtoConverter;
import medtrajet.backend.presentation.converters.destinations.create.CreateDestinationDtoConverterImpl;
import medtrajet.backend.presentation.converters.destinations.dto.DestinationDtoConverter;
import medtrajet.backend.presentation.converters.destinations.dto.DestinationDtoConverterImpl;
import medtrajet.backend.presentation.converters.trips.dto.TripDtoConverter;
import medtrajet.backend.presentation.converters.trips.dto.TripDtoConverterImpl;
import medtrajet.backend.presentation.converters.trips.end.EndTripDtoConverter;
import medtrajet.backend.presentation.converters.trips.end.EndTripDtoConverterImpl;
import medtrajet.backend.presentation.converters.trips.start.StartTripDtoConverter;
import medtrajet.backend.presentation.converters.trips.start.StartTripDtoConverterImpl;
import medtrajet.backend.presentation.converters.users.dto.UserDtoConverter;
import medtrajet.backend.presentation.converters.users.dto.UserDtoConverterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PresentationConverterConfig {

    // * USER * //
    @Bean
    public UserDtoConverter userDtoConverter() {
        return new UserDtoConverterImpl();
    }

    // * DESTINATION * //
    @Bean
    public DestinationDtoConverter destinationDtoConverter() {
        return new DestinationDtoConverterImpl();
    }

    @Bean
    public CreateDestinationDtoConverter createDestinationDtoConverter() {
        return new CreateDestinationDtoConverterImpl();
    }

    // * TRIP * //
    @Bean
    public TripDtoConverter tripDtoConverter() {
        return new TripDtoConverterImpl();
    }

    @Bean
    public StartTripDtoConverter startTripDtoConverter() {
        return new StartTripDtoConverterImpl();
    }

    @Bean
    public EndTripDtoConverter endTripDtoConverter() {
        return new EndTripDtoConverterImpl();
    }

}
