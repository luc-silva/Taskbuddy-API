package com.lucsilva.taskbuddy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class NotAuthenticated extends RuntimeException {
    public NotAuthenticated() {
    }

    public NotAuthenticated(String message) {
        super("Not Authenticated: " + message);
    }
}
