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

    public Session(Course course) {
        this.course = course;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Session{" +
                "course=" + course +
                '}';
    }
}
