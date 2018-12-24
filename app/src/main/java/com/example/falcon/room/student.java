package com.example.falcon.room;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "student_table")
public class student {
    @PrimaryKey
    private int id;

    private String name;

    private String branch_name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBranch_name() {
        return branch_name;
    }
}
