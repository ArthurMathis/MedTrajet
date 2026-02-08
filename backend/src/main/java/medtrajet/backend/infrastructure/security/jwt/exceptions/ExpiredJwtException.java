package medtrajet.backend.infrastructure.security.jwt.exceptions;

public class ExpiredJwtException extends Exception {

    public ExpiredJwtException(String errorMessage) {
        super(errorMessage);
    }

}
