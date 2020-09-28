package com.ualr.simpletasklist.model;

public class Task {

    // **** Two attributes for the Task Class ****
    private String task_Description;
    private boolean is_Done = false;

    // **** Getters & Setters ****
    public String getTask_Description() {
        return task_Description;
    }

    public void setTask_Description(String task_Description) {
        this.task_Description = task_Description;
    }

    public boolean getIs_Done() {
        return is_Done;
    }

    public void setIs_Done(boolean is_Done) {
        this.is_Done = is_Done;
    }

    // **** Class constructor ****
    public Task(String task_Description) {
        this.task_Description = task_Description;
        this.is_Done = false;
    }
}
