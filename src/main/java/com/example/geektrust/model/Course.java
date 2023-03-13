package com.example.geektrust.model;

public class Course {
    private String instructor;
    private String date;
    private String course;

    private int minEmployees;

    private int maxEmployees;

    private  int numberOfEmployees = 0;

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public  void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getMinEmployees() {
        return minEmployees;
    }

    public void setMinEmployees(int minEmployees) {
        this.minEmployees = minEmployees;
    }

    public int getMaxEmployees() {
        return maxEmployees;
    }

    public void setMaxEmployees(int maxEmployees) {
        this.maxEmployees = maxEmployees;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
