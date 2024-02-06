package com.example.project1.ui.GTExams;

import java.util.ArrayList;

public class Exams {
    String title;
    String time;
    String location;
    String details;

    public static ArrayList<Exams> exams = new ArrayList<>();

    public Exams(String title, String time, String location, String details) {
        this.title = title;
        this.time = time;
        this.location = location;
        this.details = details;

        exams.add(this);

    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Exams)) return false;
        Exams o = (Exams) obj;
        return o.title == this.title;
    }

    public void removeAssignment() {
        if (exams.size() == 0) {
            return;
        }
        exams.remove(this);
    }
}


