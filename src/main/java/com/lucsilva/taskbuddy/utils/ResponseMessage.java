package com.lucsilva.taskbuddy.utils;

import java.io.Serializable;

public class ResponseMessage implements Serializable {
    private String message;

    public ResponseMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
