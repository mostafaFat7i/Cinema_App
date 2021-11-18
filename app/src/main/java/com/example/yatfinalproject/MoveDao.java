package com.example.yatfinalproject;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MoveDao {
    @Insert
    void insert(MoveModel student);

    @Update
    void updateStudent(MoveModel student);

    @Delete
    void deleteStudent(MoveModel student);

    @Query("SELECT * FROM moves")
    List<MoveModel> getAll();


}
