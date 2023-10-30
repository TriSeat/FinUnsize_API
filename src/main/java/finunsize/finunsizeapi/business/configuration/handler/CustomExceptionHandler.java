package finunsize.finunsizeapi.business.configuration.handler;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.configuration.handler.user.EntityAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<String> handleEntityAlreadyExistsException(EntityAlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ContextNullException.class)
    public ResponseEntity<String> handleContextNullException(ContextNullException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}
