package medtrajet.backend.application.exceptions.trips;

public class TripAlreadyEndedException extends RuntimeException {

    public TripAlreadyEndedException(Long tripId) {
        super("Trip " + tripId + " already ended.");
    }
}
