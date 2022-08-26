package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface dao {
    @Insert
    void inserttable(model models);

    @Query("select * from `table`")
    List<model> list();
    @Query("select * from `table` where ngaygio like '%'||:time||'%'")
    List<model> calender(String time);
}