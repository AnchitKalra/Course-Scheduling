package com.example.geektrust;

import com.example.geektrust.exception.Cancel;
import com.example.geektrust.exception.CourseFull;
import com.example.geektrust.exception.InvalidException;
import com.example.geektrust.controller.CourseController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            CourseController controller = new CourseController();
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
                String s = sc.nextLine();
                String input[] = s.split(" ");
                if(input[0].equalsIgnoreCase(Constants.ADDCOURSEOFFERING)) {
                    try {
                        controller.addCourse(input);
                    }
                    catch (InvalidException invalidException) {
                        System.out.println(invalidException.getMessage());
                    }
                }
                if(input[0].equalsIgnoreCase(Constants.REGISTER)) {
                    try {
                        controller.register(input);
                    }
                    catch (CourseFull courseFull) {
                        System.out.println(courseFull.getMessage());
                    }
                    catch (InvalidException invalidException) {
                        System.out.println(invalidException.getMessage());
                    }
                }
                if(input[0].equalsIgnoreCase(Constants.ALLOT)) {
                    controller.allot(input);
                }
                if(input[0].equalsIgnoreCase(Constants.CANCEL)) {
                    try {
                        controller.cancel(input);
                    }catch (Cancel cancel) {
                        System.out.println(cancel.getMessage());
                    }
                }

            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }
    }
}
