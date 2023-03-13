package com.example.geektrust.controller;

import com.example.geektrust.exception.Cancel;
import com.example.geektrust.exception.CourseFull;
import com.example.geektrust.exception.InvalidException;
import com.example.geektrust.service.CourseService;

public class CourseController {
    CourseService courseService = new CourseService();

    public void addCourse(String input[]) throws InvalidException {
        courseService.addCourse(input);
    }

    public void register(String []input) throws CourseFull, InvalidException {
        courseService.register(input);
    }

    public void allot(String string[]) {
        courseService.allot(string);
    }

    public void cancel(String string[]) throws Cancel {
        courseService.cancel(string);
    }
}
