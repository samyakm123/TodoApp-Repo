package com.example.todoappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.todoappproject.DB.AppDatabase;
import com.example.todoappproject.DB.Task;

public class CreateTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        final EditText taskText = findViewById(R.id.taskText);
        final EditText descriptionText = findViewById(R.id.descriptionText);
        ImageButton newTask = findViewById(R.id.new_taskBtn);
        newTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNewTask(taskText.getText().toString(), descriptionText.getText().toString());
            }
        });


    }

    private void saveNewTask(String title, String description){
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        Task task = new Task();
        task.title = title;
        task.description = description;
        db.Dao().insertTask(task);

        finish();
    }
}