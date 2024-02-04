package com.example.project1;

import java.util.Date;

public class Assignment {
    private String title;
    private Date dateDue;
    private String courseName; 

    // Constructor
    public Assignment(String title, Date dateDue, String courseName) {
        this.title = title;
        this.dateDue = dateDue;
        this.courseName = courseName;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getdateDue() {
        return dateDue;
    }

    public void setdateDue(Date dateDue) {
        this.dateDue = dateDue;
    }

    public String getcourseName() {
        return courseName;
    }

    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }

    // Optionally, override toString() for easy printing/debugging
    @Override
    public String toString() {
        return "Assignment{" +
                "title='" + title + '\'' +
                ", dateDue=" + dateDue +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}

