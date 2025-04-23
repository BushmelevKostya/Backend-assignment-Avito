package avito.backendassignment.util;

import avito.backendassignment.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String fieldName = error.getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }
  
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleUsernameNotFoundException(UsernameNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(error);
    }
    
    @ExceptionHandler(InvalidCityException.class)
    public ResponseEntity<Map<String, String>> handleInvalidCityException(InvalidCityException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        
        return ResponseEntity.badRequest().body(error);
    }
    
    @ExceptionHandler({AccessDeniedException.class, ForbiddenException.class})
    public ResponseEntity<Map<String, String>> handleAccessDeniedException(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", "Доступ запрещен");
        error.put("details", ex.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleAllExceptions(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", "Произошла ошибка, но не волнуйся, все будет хорошо ^-^");
        error.put("details", ex.getMessage());
        return ResponseEntity.internalServerError().body(error);
    }
    
    @ExceptionHandler(ActiveReceptionExistsException.class)
    public ResponseEntity<Error> handleActiveReceptionExists(ActiveReceptionExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new Error(ex.getMessage()));
    }
    
    @ExceptionHandler(NoActiveReceptionException.class)
    public ResponseEntity<Error> handleNoActiveReception(NoActiveReceptionException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new Error(ex.getMessage()));
    }
    
    @ExceptionHandler(PvzNotFoundException.class)
    public ResponseEntity<Error> handlePvzNotFound(PvzNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new Error(ex.getMessage()));
    }
}