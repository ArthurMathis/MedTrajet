package medtrajet.backend.application.exceptions;

public class InvalidAuthentificationException extends RuntimeException {

    public InvalidAuthentificationException(String errorMessage) {
        super(errorMessage);
    }

}
