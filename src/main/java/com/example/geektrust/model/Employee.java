package com.example.geektrust.model;

public class Employee implements Comparable<Employee>{

    private String email;
    private String registrationDetails;

    private String course;


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistrationDetails() {
        return registrationDetails;
    }

    public void setRegistrationDetails(String registrationDetails) {
        this.registrationDetails = registrationDetails;
    }

    @Override
    public int compareTo(Employee o) {
        return this.getRegistrationDetails().compareTo(o.getRegistrationDetails());

    }
}
