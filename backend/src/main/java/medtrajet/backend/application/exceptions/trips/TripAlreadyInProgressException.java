package medtrajet.backend.application.exceptions.trips;

public class TripAlreadyInProgressException extends RuntimeException {

    public TripAlreadyInProgressException(Long userId) {
        super("User " + userId + " already has an active trip.");
    }
}
