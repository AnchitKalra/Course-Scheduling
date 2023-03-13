package com.example.geektrust;

import com.example.geektrust.exception.Cancel;
import com.example.geektrust.exception.CourseFull;
import com.example.geektrust.exception.InvalidException;
import com.example.geektrust.model.Course;
import com.example.geektrust.model.Employee;
import com.example.geektrust.service.CourseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    CourseService courseService = new CourseService();

    @Test
    public void testAddCourse() {
        try {
            String string = "ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2";
            String input[] = string.split(" ");
            String output = courseService.addCourse(input);
            Assertions.assertEquals("OFFERING-JAVA-JAMES", output);
        }catch (Exception e) {

        }
    }

    @Test
    public void testRegister() {
        try{
            String string = "ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2";
            String input[] = string.split(" ");
            String output = courseService.addCourse(input);
            String s = "REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES";
             input = s.split(" ");
             output = courseService.register(input);
            Assertions.assertEquals("REG-COURSE-ANDY-JAVA ACCEPTED", output);
    }catch (Exception e) {
        }
    }
    @Test
    public void testAllot() {
        try {
            String string = "ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2";
            String input[] = string.split(" ");
            String output = courseService.addCourse(input);
            String s = "REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES";
            input = s.split(" ");
            output = courseService.register(input);
            s = "ALLOT OFFERING-JAVA-JAMES";
            input = s.split(" ");
            output = courseService.allot(input);
            Assertions.assertEquals("CONFIRMED", output);
        }
        catch (Exception e) {
        }
    }

    @Test
    public void testCancel() {
        try {
            String string = "ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2";
            String input[] = string.split(" ");
            String output = courseService.addCourse(input);
            String s = "REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES";
            input = s.split(" ");
            output = courseService.register(input);
            s = "CANCEL REG-COURSE-ANDY-JAVA";
            input = s.split(" ");
            output = courseService.cancel(input);
            Assertions.assertEquals("CANCEL_ACCEPTED", output);
        }catch (Exception e) {

        }
    }

    @Test
    public void testCancelException() {
        Cancel cancel = new Cancel(Constants.CANCEL);
        Assertions.assertEquals(Constants.CANCEL, cancel.getMessage());
    }

    @Test
    public void testCourseFull() {
        CourseFull courseFull = new CourseFull(Constants.COURSE_FULL_ERROR);
        Assertions.assertEquals(Constants.COURSE_FULL_ERROR, courseFull.getMessage());
    }

    @Test
    public void testInvalidException() {
        InvalidException invalidException = new InvalidException(Constants.INPUT_DATA_ERROR);
        Assertions.assertEquals(Constants.INPUT_DATA_ERROR, invalidException.getMessage());
    }

    @Test
    public void testEmployee() {
        Employee employee = new Employee();
        employee.setEmail("a@a.c");
        employee.setRegistrationDetails("abc");
        employee.setCourse("JAVA");
        Assertions.assertEquals("a@a.c" , employee.getEmail());
        Assertions.assertEquals("abc", employee.getRegistrationDetails());
        Assertions.assertEquals("JAVA", employee.getCourse());
    }

    @Test
    public void testCourse() {
        Course course = new Course();
        course.setMaxEmployees(5);
        course.setDate("123");
        course.setNumberOfEmployees(1);
        course.setCourse("JAVA");
        course.setInstructor("A");
        course.setMinEmployees(0);
        Assertions.assertEquals(5, course.getMaxEmployees());
        Assertions.assertEquals("123", course.getDate());
        Assertions.assertEquals(1, course.getNumberOfEmployees());
        Assertions.assertEquals("JAVA", course.getCourse());
        Assertions.assertEquals("A", course.getInstructor());
        Assertions.assertEquals(0, course.getMinEmployees());
    }
}