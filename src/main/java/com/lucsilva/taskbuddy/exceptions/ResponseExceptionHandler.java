package com.lucsilva.taskbuddy.exceptions;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NotFound.class)
    public ResponseEntity<?> handleNotFoundException(NotFound e) {
        ErrorResponseBody erb = new ErrorResponseBody(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(erb, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<?> handleInvalidData(IllegalArgumentException e) {
        ErrorResponseBody erb = new ErrorResponseBody(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(erb, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NotAuthenticated.class)
    public ResponseEntity<?> handleUnauthorizedAccess(NotAuthenticated e) {
        ErrorResponseBody erb = new ErrorResponseBody(e.getMessage(), HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(erb, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(value = PropertyValueException.class)
    public ResponseEntity<?> genericResponse(PropertyValueException e) {
        ErrorResponseBody erb = new ErrorResponseBody(e.getMessage(), HttpStatus.BAD_GATEWAY);
        return new ResponseEntity<>(erb, HttpStatus.BAD_GATEWAY);
    }

}
