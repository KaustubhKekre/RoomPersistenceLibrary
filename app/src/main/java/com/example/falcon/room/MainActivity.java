package com.example.falcon.room;

import android.arch.persistence.room.Room;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
  public static FragmentManager fm;
  public static studentDB studentDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        studentDB= Room.databaseBuilder(getApplicationContext(),studentDB.class,"studentDb").build();
        if (findViewById(R.id.frag1) != null) {
            if (savedInstanceState != null) {
                return;
            }
            fm.beginTransaction().add(R.id.frag1, new frag2()).commit();
        }
    }
}
