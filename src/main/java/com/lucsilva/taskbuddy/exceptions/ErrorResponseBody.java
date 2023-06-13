package com.lucsilva.taskbuddy.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ErrorResponseBody implements Serializable {
    String message;
    HttpStatus status;
    Integer status_code;

    public ErrorResponseBody() {
    }

    public ErrorResponseBody(String message, HttpStatus status) {
        this.message = message;
        this.status_code = status.value();
        this.status = status;
    }

    public ErrorResponseBody(String message, int status) {
        this.message = message;
        this.status_code = status;
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

    public Integer getStatus_code() {
        return status_code;
    }

    public void setStatus_code(Integer status_code) {
        this.status_code = status_code;
    }

    @Override
    public String toString() {
        return "ErrorResponseBody{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", status_code=" + status_code +
                '}';
    }
}
