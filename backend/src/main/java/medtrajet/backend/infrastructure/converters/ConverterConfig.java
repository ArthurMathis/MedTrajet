package medtrajet.backend.infrastructure.converters;

import medtrajet.backend.infrastructure.converters.users.UserConverter;
import medtrajet.backend.infrastructure.converters.users.UserConverterImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConverterConfig {

    // * USER * //
    @Bean
    public UserConverter userConverter() {
        return new UserConverterImpl();
    }

}
