package com.example.falcon.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface sDAO {
    @Insert
    void insert(student student);

    @Update
    void update(student student);

    @Delete
    void delete(student student);

    @Query("select * from student_table order by id ASC ")
    List<student> display();

}
