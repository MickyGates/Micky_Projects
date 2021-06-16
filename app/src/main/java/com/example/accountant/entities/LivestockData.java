package com.example.accountant.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "livestock")
public class LivestockData implements Serializable {
    @NonNull
    @PrimaryKey(autoGenerate = false)
    private String livestockID;

    @ColumnInfo(name = "Number of Males")
    private int number_of_male;

    @ColumnInfo(name = "Number of Female")
    private int number_of_female;

    @ColumnInfo(name = "Total Number of Livestock")
    private int total_livestock;

    @NonNull
    public String getLivestockID() {
        return livestockID;
    }

    public void setLivestockID(@NonNull String livestockID) {
        this.livestockID = livestockID;
    }

    public int getNumber_of_male() {
        return number_of_male;
    }

    public void setNumber_of_male(int number_of_male) {
        this.number_of_male = number_of_male;
    }

    public int getNumber_of_female() {
        return number_of_female;
    }

    public void setNumber_of_female(int number_of_female) {
        this.number_of_female = number_of_female;
    }

    public int getTotal_livestock() {
        return total_livestock;
    }

    public void setTotal_livestock(int total_livestock) {
        this.total_livestock = total_livestock;
    }
}
