package be.abis.sandwich.model;

import be.abis.sandwich.theenums.Course;

import java.util.Date;

public class Session {
     private static int counter;
     private int sessionNo;
    Date datum;
    Course course;

    public Session(Date datum, Course course) {
        this.datum = datum;
        this.course = course;
        sessionNo = counter++;
    }

}
