package com.example.yatfinalproject;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MoveModel.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase instance;
    public abstract MoveDao moveDao();
    public static synchronized AppDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context,AppDatabase.class,"move_database")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }
}
