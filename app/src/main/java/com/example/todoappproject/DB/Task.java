package com.example.todoappproject.DB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task_table")
public class Task {

    @PrimaryKey(autoGenerate = true)
    public long task_id;

    @ColumnInfo(name = "Todo Task Title")
    public String title;

    @ColumnInfo(name = "Task Description")
    public String description;

}
