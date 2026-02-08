package medtrajet.backend.presentation.apiResponse;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiError {

    @JsonIgnore
    protected HttpStatus status;
    protected String content;
    protected String path;
    protected LocalDateTime timestamp;

    // * JSON SERIALISATION * //
    @JsonProperty("status")
    public int getStatusCode() {
        return status.value();
    }

    @JsonProperty("error")
    public String getStatusError() {
        return status.name();
    }

    // * CONSTRUCTORS * //
    public ApiError(HttpStatus status, String content, String path, LocalDateTime timestamp) {
        this.status = status;
        this.content = content;
        this.path = path;
        this.timestamp = timestamp;
    }

    public ApiError(HttpStatus status, String message, String path) {
        this(status, message, path, LocalDateTime.now());
    }

    public ApiError(String message, String path) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, message, path, LocalDateTime.now());
    }

    // * GETTERS & SETTERS * //
    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}
