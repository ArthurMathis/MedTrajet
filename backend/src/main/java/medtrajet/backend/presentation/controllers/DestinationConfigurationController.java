package medtrajet.backend.presentation.controllers;

import lombok.AllArgsConstructor;
import medtrajet.backend.application.services.DestinationService;
import medtrajet.backend.presentation.dtos.destinations.DestinationDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "destinations")
@AllArgsConstructor
public class DestinationConfigurationController {

    private final DestinationService destinationService;

    @GetMapping()
    public List<DestinationDTO> index() {
        return this.destinationService.index();
    }

}
