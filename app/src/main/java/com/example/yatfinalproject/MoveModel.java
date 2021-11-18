package com.example.yatfinalproject;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "moves")
public class MoveModel {
    @PrimaryKey(autoGenerate = true)
    int id;
    private String name,imageurl,bio;
    private boolean isfavor=false;


    public MoveModel() {
    }

    public MoveModel(String name, String imageurl) {
        this.name = name;
        this.imageurl = imageurl;
    }

    public MoveModel(String name, String imageurl, boolean isfavor) {
        this.name = name;
        this.imageurl = imageurl;
        this.isfavor = isfavor;
    }



    public boolean getIsfavor() {
        return isfavor;
    }

    public void setIsfavor(boolean isfavor) {
        this.isfavor = isfavor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
