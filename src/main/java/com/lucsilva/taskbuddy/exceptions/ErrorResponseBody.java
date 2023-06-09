package com.lucsilva.taskbuddy.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ErrorResponseBody implements Serializable {
    String message;
    HttpStatus status;

    public ErrorResponseBody() {
    }

    public ErrorResponseBody(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public ErrorResponseBody(String message, int status) {
        this.message = message;
        this.status = HttpStatus.valueOf(status);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ErrorResponseBody{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
