package com.example.geektrust.exception;

public class Cancel extends Exception{

    private String message;

    public Cancel(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
