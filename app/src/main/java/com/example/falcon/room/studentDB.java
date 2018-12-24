package com.example.falcon.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;



@Database(entities = student.class,version = 1)



public abstract class studentDB extends RoomDatabase {

    public abstract sDAO sDAO();



}
