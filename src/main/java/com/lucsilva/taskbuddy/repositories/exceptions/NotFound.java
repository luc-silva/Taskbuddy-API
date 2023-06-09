package com.lucsilva.taskbuddy.repositories.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFound extends RuntimeException{
    public NotFound(){}
    public NotFound(String message){
        super(message);
    }
}
