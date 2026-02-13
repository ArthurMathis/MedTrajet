package medtrajet.backend.presentation.controllers;

import lombok.AllArgsConstructor;
import medtrajet.backend.application.services.DestinationService;
import medtrajet.backend.presentation.dtos.destinations.CreateDestinationDTO;
import medtrajet.backend.presentation.dtos.destinations.DestinationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "destinations")
@AllArgsConstructor
public class DestinationController {

    private final DestinationService destinationService;

    @GetMapping()
    public List<DestinationDTO> index() {
        return this.destinationService.index();
    }

    @GetMapping(path = "{destinationId}")
    public DestinationDTO get(@PathVariable Long destinationId) {
        return this.destinationService.get(destinationId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public Long create(@RequestBody CreateDestinationDTO createDestinationDTO) {
        return this.destinationService.create(createDestinationDTO);
    }

}
