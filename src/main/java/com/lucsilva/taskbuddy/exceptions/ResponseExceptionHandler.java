package com.lucsilva.taskbuddy.exceptions;

import com.lucsilva.taskbuddy.exceptions.ErrorResponseBody;
import com.lucsilva.taskbuddy.exceptions.NotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NotFound.class)
    public ResponseEntity<?> handleException(NotFound e){
        ErrorResponseBody erb = new ErrorResponseBody(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(erb, HttpStatus.NOT_FOUND);
    }

}
