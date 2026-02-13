package medtrajet.backend.application.exceptions;

public class TripAlreadyInProgressException extends RuntimeException {

    public TripAlreadyInProgressException(Long userId) {
        super("User " + userId + " already has an active trip.");
    }
}
