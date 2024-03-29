package com.example.project1.ui.GTClass;

import java.util.ArrayList;

public class GTClass {

    public static ArrayList<GTClass> classList = new ArrayList<>();
    String courseName;
    String time;
    String instructor;

    public GTClass(String courseName, String time, String instructor) {
        this.courseName = courseName;
        this.time = time;
        this.instructor = instructor;

        classList.add(this);
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof GTClass)) return false;
        GTClass o = (GTClass) obj;
        return o.courseName.equals(this.courseName);
    }

    /*
    public void removeClass() {
        if (classList.size() == 0) {
            return;
        }
        classList.remove(this);
    }
    */
}
