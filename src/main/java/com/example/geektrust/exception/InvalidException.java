package com.example.geektrust.exception;

public class InvalidException extends Exception{
    private String message;

   public InvalidException(String message) {
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
