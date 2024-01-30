package com.example.project1;

public class GTClass {
    String courseName;
    String time;
    String instructor;

    public GTClass(String courseName, String time, String instructor) {
        this.courseName = courseName;
        this.time = time;
        this.instructor = instructor;
    }

    public GTClass() {
        this("n/a", "n/a", "n/a");
    }

    public void updateCourseName(String c) {
        this.courseName = c;
    }

    public void removeCourseName() {
        updateCourseName("n/a");
    }

    public void updateTime(String c) {
        this.time = c;
    }

    public void removeTime() {
        updateTime("n/a");
    }

    public void updateInstructor(String c) {
        this.instructor = c;
    }

    public void removeInstructor() {
        updateInstructor("n/a");
    }

    public String getInstructor() {
        return instructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getTime() {
        return time;
    }






}
