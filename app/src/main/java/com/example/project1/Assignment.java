package com.example.project1;

import java.util.Date;

public class Assignment {
    private String title;
    private Date dueDate;
    private String associatedClass; // This could be a course name or an identifier

    // Constructor
    public Assignment(String title, Date dueDate, String associatedClass) {
        this.title = title;
        this.dueDate = dueDate;
        this.associatedClass = associatedClass;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getAssociatedClass() {
        return associatedClass;
    }

    public void setAssociatedClass(String associatedClass) {
        this.associatedClass = associatedClass;
    }

    // Optionally, override toString() for easy printing/debugging
    @Override
    public String toString() {
        return "Assignment{" +
                "title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", associatedClass='" + associatedClass + '\'' +
                '}';
    }
}

