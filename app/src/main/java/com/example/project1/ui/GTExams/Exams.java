package com.example.project1.ui.GTExams;

import java.util.ArrayList;
import java.util.Date;

public class Exams {
    private String title;
    private Date date;
    private String time;
    private String location;
    private String details;


    public static ArrayList<Exams> exams = new ArrayList<>();


    public Exams(String title, Date date, String time, String location, String details) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.details = details;
        exams.add(this);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Exams)) return false;
        Exams o = (Exams) obj;
        return o.title.equals(this.title);
    }


    public void removeExam() {
        exams.remove(this);
    }
}
