package be.abis.sandwich.model;

import be.abis.sandwich.theenums.Course;

import java.time.LocalDateTime;
import java.util.Date;

public class Session {
     private static int counter;
     private int sessionNo;
    LocalDateTime datum;
    Course course;

    public Session(LocalDateTime datum, Course course) {
        this.datum = datum;
        this.course = course;
        sessionNo = counter++;
    }

}
