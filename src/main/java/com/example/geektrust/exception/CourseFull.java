package com.example.geektrust.exception;

public class CourseFull extends Exception{

    private String message;

    public CourseFull(String message) {
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
