package medtrajet.backend.application.exceptions.authentifications;

public class InvalidAuthentificationException extends RuntimeException {

    public InvalidAuthentificationException(String errorMessage) {
        super(errorMessage);
    }

}
