package medtrajet.backend.presentation.controllers;

import lombok.AllArgsConstructor;
import medtrajet.backend.application.services.TripService;
import medtrajet.backend.presentation.dtos.trips.StartTripDTO;
import medtrajet.backend.presentation.dtos.trips.TripDTO;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(path = "/trips")
@AllArgsConstructor
public class TripController {

    private final TripService tripService;

    // todo: index

    @GetMapping(path = "/me/current")
    public TripDTO getCurrent(Authentication authentication) {
        Long userId = (Long) authentication.getPrincipal();
        return this.tripService.getCurrent(userId);
    }

    @PostMapping()
    public void start(Authentication authentication, @RequestBody StartTripDTO tripDTO) {
        if(!Objects.equals((Long) authentication.getPrincipal(), tripDTO.userId())) {
            throw new AccessDeniedException("User authentification doesn't match with the user in trip");
        }
        this.tripService.start(tripDTO);
    }

    // todo: end

}
