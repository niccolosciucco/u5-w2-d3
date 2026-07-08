package niccolosciucco.u5_w2_d3.authors.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(NotFound.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorHandlerPayload handleNotFound(NotFound ex) {
        return new ErrorHandlerPayload(LocalDateTime.now(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorHandlerPayload handleGenericExceptions(Exception ex) {
        ex.printStackTrace();
        return new ErrorHandlerPayload(LocalDateTime.now(), "Server error");
    }
}
