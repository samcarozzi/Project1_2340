package com.example.project1.ui.GTToDoList;

import java.util.ArrayList;

public class GTToDoList {
    private String body;
    public static ArrayList<GTToDoList> todoList = new ArrayList<>();

    // Constructor to create a new ToDoItem and add it to the list
    public GTToDoList(String body) {
        this.body = body;
        todoList.add(this);
    }

    // Getter for the body field
    public String getBody() {
        return body;
    }

    // Setter for the body field
    public void setBody(String body) {
        this.body = body;
    }

    // Method to remove this ToDoItem from the list
    public void removeToDoItem() {
        todoList.remove(this);
    }



}
