package medtrajet.backend.presentation.apiResponse;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import medtrajet.backend.application.exceptions.InvalidAuthentificationException;
import medtrajet.backend.application.exceptions.TripAlreadyInProgressException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TripAlreadyInProgressException.class)
    public ResponseEntity<ApiError> handleTripAlreadyInProgress(TripAlreadyInProgressException ex, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ApiError apiError = new ApiError(status, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(apiError);
    }

    @ExceptionHandler(InvalidAuthentificationException.class)
    public ResponseEntity<ApiError> handleInvalidAuthentification(InvalidAuthentificationException ex, HttpServletRequest request) {
        HttpStatus httpResponse = HttpStatus.UNAUTHORIZED;
        ApiError apiError = new ApiError(httpResponse, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpResponse).body(apiError);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> handleEntityNotFound(EntityNotFoundException ex, HttpServletRequest request) {
        HttpStatus httpResponse = HttpStatus.NOT_FOUND;
        ApiError apiError = new ApiError(httpResponse, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpResponse).body(apiError);
    }

}
