package com.example.project1;

import java.util.Date;

public class Assignment {
    private String title;
    private Date dateDue;
    private String courseName;

    public Assignment(String title, Date dateDue, String courseName) {
        this.title = title;
        this.dateDue = dateDue;
        this.courseName = courseName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateDue() {
        return dateDue;
    }

    public void setDateDue(Date dateDue) {
        this.dateDue = dateDue;
    }

    public String getcourseName() {
        return courseName;
    }

    public void setcourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "title='" + title + '\'' +
                ", dateDue=" + dateDue +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}

