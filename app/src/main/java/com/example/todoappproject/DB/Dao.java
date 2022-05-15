package com.example.todoappproject.DB;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {

    @Query("SELECT * FROM task_table")
    List<Task> getAllTask();

    @Insert
    void insertTask(Task... tasks);

    @Update
    void update(Task task);

    @Delete
    void delete (Task task);
}
