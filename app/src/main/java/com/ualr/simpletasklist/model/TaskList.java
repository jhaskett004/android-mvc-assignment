package com.ualr.simpletasklist.model;

import java.util.HashMap;
import java.util.*;

public class TaskList {

    // **** TaskList's only attribute ****
    private HashMap<Integer, Task> stored_Tasks;
    private int taskID = 1;

    // **** Constructor ****
    public TaskList() {
        stored_Tasks = new HashMap<>();
    }


    // **** Setters & Getters ****
    public String get_Stored_Task(int taskID) {
        Task retrieved_Task = this.stored_Tasks.get(taskID);
        return retrieved_Task.getTask_Description();
    }

    public boolean get_Stored_Task_isDone(int taskID) {
        Task retrieved_Task = this.stored_Tasks.get(taskID);
        return retrieved_Task.getIs_Done();
    }

    public void set_Stored_Task(String task_Description) {
        Task newTask = new Task(task_Description);
        this.stored_Tasks.put(new Integer(taskID), newTask);
        taskID ++;
    }

    public void set_Stored_Task_isDone(int taskID) {
       Task retrieved_Task = this.stored_Tasks.get(taskID);
       retrieved_Task.setIs_Done(true);
    }

    // **** Method called "add" that will create a new task and add it to the task list. ****
    public void add_Task(String task_Description) {
        set_Stored_Task(task_Description);
    }


    // Defined a new "toString" method that provides a formatted string with all the tasks in the task list.
    public String toString() {
        String ans = "";

        Iterator it = stored_Tasks.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry hme = (Map.Entry)it.next();
            int i = (int)hme.getKey();
            if (get_Stored_Task_isDone(i) == false)
                ans += i + "  --  " + get_Stored_Task(i) + "\n";
            if(get_Stored_Task_isDone(i) == true)
                ans += i + "  --  " + get_Stored_Task(i) + " -- Done!\n";
        }
        return ans;
    }

    // Format: 1 line per task. Each line should start with the id number of the task, then a dash, and the task description right after that.
    // If the task is marked as done, "Done" should be included at the end of the line

    // 07.03. Defined a new method called "delete" that, given a task id, will delete the
    // corresponding task from the task list.
    public void delete(int taskID) {
        stored_Tasks.remove(taskID);
    }


    // 08.03. Define a new method called "markDone" that, given a task id, will mark the
    // corresponding task as done.
    public void markDone(int taskID) {
        set_Stored_Task_isDone(taskID);
    }

}
