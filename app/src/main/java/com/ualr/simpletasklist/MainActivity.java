package com.ualr.simpletasklist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.ualr.simpletasklist.databinding.ActivityMainBinding;
import com.ualr.simpletasklist.model.TaskList;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    // **** Added a TaskList member to the MainActivity ****
    private TaskList taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // **** Initialized ****
        taskList = new TaskList();


        // 06.02 Bound the onAddBtnClicked method to the add button, so the onAddBtnClicked is
        // triggered whenever the user clicks on that button
        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddBtnClicked();
            }
        });

        // 07.02 Bind the onDeleteBtnClicked method to the delete button, so that method is
        // triggered whenever the user clicks on that button
        binding.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeleteBtnClicked();
            }
        });

        // 08.02 Bind the onDoneBtnClicked method to the done button, so the onDoneBtnClicked method is
        // triggered whenever the user clicks on that button
        binding.clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDoneBtnClicked();
            }
        });


        //TODO 08.02 Bind the onDoneBtnClicked method to the done button, so the onDoneBtnClicked method is
        // triggered whenever the user clicks on that button
    }


    // 06.01. Created a new method called onAddBtnClicked.
    private void onAddBtnClicked()
    {
        // 06.05. Invoked TaskList class' add method to ask the TaskList to
        //  add a new Task with the description provided through the text field.
        String task = binding.editTextTextPersonName.getText().toString();
        taskList.add_Task(task);

        // 06.06. Use TaskList class' toString method to get a string with the formatted task list
        // and display it on screen in the TextView with the id "textView"
        String textView = taskList.toString();
        binding.taskList.setText(textView);

        //Cleans up the screen
        binding.editTextTextPersonName.setText("");
    }

    // 07.01. Created a new method called onDeleteBtnClicked
    private void onDeleteBtnClicked()
    {
        //convert from string to int
        String taskID_string = binding.editTextTaskId.getText().toString();
        int taskID = Integer.parseInt(taskID_string);

        // 07.04. Invoke TaskList class' delete method to ask the TaskList to
        // delete a Task given the id provided through the text field on the bottom.
        taskList.delete(taskID);

        // 07.05. Use TaskList class' toString method to get a string with the formatted task list
        // and display it on screen in the TextView with the id "textView"
        String textView = taskList.toString();
        binding.taskList.setText(textView);

        //Cleans up the screen
        binding.editTextTaskId.setText("");
    }

    // 08.01. Create a new method called onDoneBtnClicked
    private void onDoneBtnClicked()
    {
        //convert from string to int
        String taskID_string = binding.editTextTaskId.getText().toString();
        int taskID = Integer.parseInt(taskID_string);

        taskList.markDone(taskID);

        String textView = taskList.toString();
        binding.taskList.setText(textView);

        //Cleans up the screen
        binding.editTextTaskId.setText("");
    }

    // TODO 08.04. Invoke TaskList class' markDone method to ask the TaskList to
    //  mark a Task given the id provided through the text field on the bottom.

    // TODO 08.05. Use TaskList class' toString method to get a string with the formatted task list
    //  and display it on screen in the TextView with the id "textView"

}