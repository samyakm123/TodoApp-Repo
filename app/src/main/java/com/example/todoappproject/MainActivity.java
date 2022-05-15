package com.example.todoappproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.todoappproject.DB.AppDatabase;
import com.example.todoappproject.DB.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AdapterClass recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //RecyclerView todolist = (RecyclerView) findViewById(R.id.todolist);
        //todolist.setAdapter(new AdapterClass(recyclerViewAdapter));

        FloatingActionButton addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(view -> startActivityForResult(new Intent(MainActivity.this, CreateTask.class), 100));

                initRecyclerView();
                loadTaskList();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.todolist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerViewAdapter = new AdapterClass(this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private void loadTaskList(){
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        List<Task> taskList = db.Dao().getAllTask();
        recyclerViewAdapter.setData(taskList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == 100){
            loadTaskList();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}