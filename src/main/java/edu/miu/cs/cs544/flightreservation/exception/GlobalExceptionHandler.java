package edu.miu.cs.cs544.flightreservation.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * MethodArgumentNotValidException Handler for all Bad DTO objects
     * This should result in an HTTP 400 level error.</p>
     */

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> fieldError = new HashMap<>();

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        for (FieldError error : fieldErrors) {
            fieldError.put(error.getField(), error.getDefaultMessage());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("isSuccess", false);
        map.put("data", null);
        map.put("status", HttpStatus.BAD_REQUEST);
        map.put("fieldError", fieldError);
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    protected ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    /**
     * Generic RuntimeException Handler
     * This should result in an HTTP 400 level error.</p>
     */
    @ExceptionHandler(value = {UserAlreadyExistsException.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {

        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
