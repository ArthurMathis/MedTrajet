package medtrajet.backend.application.exceptions.trips;

public class InvalidEndMileageException extends RuntimeException {

    public InvalidEndMileageException() {
        super("Trip end mileage can't be lower or equal to start mileage");
    }
}
