package com.example.myapplication.databse;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.dao;
import com.example.myapplication.model;

@Database(entities = {model.class}, version = 1)
public abstract class data extends RoomDatabase{
        private static final  String Database="table.db";
        private static data instance;
        public static synchronized data getins(Context context){
                if(instance==null){
                        instance= Room.databaseBuilder(context.getApplicationContext(),data.class,Database).allowMainThreadQueries().build();
                }
                return instance;
        }
        public abstract dao userDao();
}
