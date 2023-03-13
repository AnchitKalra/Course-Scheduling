package com.example.geektrust.service;

import com.example.geektrust.Constants;
import com.example.geektrust.exception.Cancel;
import com.example.geektrust.exception.CourseFull;
import com.example.geektrust.exception.InvalidException;
import com.example.geektrust.model.Course;
import com.example.geektrust.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseService {
    private List<Course> coursesList = new ArrayList<>();
    private List<String> list = new ArrayList<>();

    private List<Employee> employeeList = new ArrayList<>();

    private Boolean flag = false;
    public String addCourse(String input[]) throws InvalidException {
        try {
            Course course = new Course();
            course.setCourse(input[1]);
            course.setInstructor(input[2]);
            course.setDate(input[3]);
            course.setMinEmployees(Integer.parseInt(input[4]));
            course.setMaxEmployees(Integer.parseInt(input[5]));
            coursesList.add(course);
            list.add("OFFERING-" + course.getCourse() + "-" + course.getInstructor());
            System.out.println("OFFERING-" + course.getCourse() + "-" + course.getInstructor());
            return ("OFFERING-" + course.getCourse() + "-" + course.getInstructor());
        }
        catch (Exception e) {
            throw new InvalidException(Constants.INPUT_DATA_ERROR);
        }
    }

    public String register(String []input) throws CourseFull, InvalidException{
        try {
            //System.out.println(list);
            if (list.contains(input[2])) {
               // System.out.println("HI");
                String processedString[] = input[2].split("-");
                String courseName = processedString[1];
                for (Course course : coursesList) {
                    if (course.getCourse().equalsIgnoreCase(courseName)) {
                        if (course.getNumberOfEmployees() < course.getMaxEmployees()) {
                            course.setNumberOfEmployees(course.getNumberOfEmployees() + 1);
                        } else {
                            throw new CourseFull(Constants.COURSE_FULL_ERROR);
                        }
                    }
                }
                Employee employee = new Employee();
                employee.setEmail(input[1]);
                String s[] = input[1].split("@");
                String a = "REG-COURSE-";
                a += s[0] + "-";
                a += processedString[1];
                employee.setCourse(processedString[1]);
                employee.setRegistrationDetails(a);
                employeeList.add(employee);
                System.out.println(a + " " + "ACCEPTED");
                return (a + " " + "ACCEPTED");
            }
        }catch (Exception e) {
            if(e.getMessage().equalsIgnoreCase(Constants.COURSE_FULL_ERROR)) {
                throw new CourseFull(Constants.COURSE_FULL_ERROR);
            }
            throw new InvalidException(Constants.INPUT_DATA_ERROR);
        }
        return "";

    }

    public String allot(String input[]) {
        if(list.contains(input[1])) {
            String s[] = input[1].split("-");
            Collections.sort(employeeList);
            for (Employee employee : employeeList) {
                if(s[1].equalsIgnoreCase(employee.getCourse())) {
                    System.out.print(employee.getRegistrationDetails() + " " + employee.getEmail() + " " + input[1] + " ");
                    for (Course course : coursesList) {
                        if(s[1].equalsIgnoreCase(course.getCourse())) {
                            System.out.println(course.getCourse() + " " + course.getInstructor() + " " + course.getDate() + " " + (((course.getNumberOfEmployees() < course.getMinEmployees()) ? " COURSE_CANCELED" : "CONFIRMED")));
                        }
                    }
                }
            }


        }
        flag = true;
        return "CONFIRMED";
    }
    public String cancel(String input[]) throws Cancel{
        if(!flag) {
            Employee employe = new Employee();
            for (Employee employee : employeeList) {
                if(employee.getRegistrationDetails().equalsIgnoreCase(input[1])) {
                    employe = employee;
                }
            }
            employeeList.remove(employe);
            System.out.println(input[1] + " " + "CANCEL_ACCEPTED");
            return "CANCEL_ACCEPTED";
        }
        else {
            throw new Cancel(input[1] + " " + "CANCEL_REJECTED");
        }
    }
}
