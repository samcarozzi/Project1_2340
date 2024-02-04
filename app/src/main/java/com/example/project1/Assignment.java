package com.example.project1;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Assignment {
    private String title;
    private Date dateDue;
    private String courseName;

    public static ArrayList<Assignment> assignments = new ArrayList<Assignment>();

    public Assignment(String title, Date dateDue, String courseName) {
        this.title = title;
        this.dateDue = dateDue;
        this.courseName = courseName;

        assignments.add(this);

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

    //hdfsdf
    public void sortDueDates() {
        Collections.sort(assignments, (a1, a2) -> a1.getDateDue().compareTo(a2.getDateDue()));
    }

}

