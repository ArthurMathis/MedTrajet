package medtrajet.backend.infrastructure.security.jwt.exceptions;

public class InvalidJwtException extends Exception {

    public InvalidJwtException(String errorMessage) {
        super(errorMessage);
    }

}
