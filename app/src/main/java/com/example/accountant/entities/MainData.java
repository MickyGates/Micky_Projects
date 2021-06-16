package com.example.accountant.entities;


import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

//Define table names
@Entity(tableName = "production")
public class MainData implements Serializable  {
    //create id column
    @NonNull
    @PrimaryKey(autoGenerate = false)
    private String productID;

    @ColumnInfo(name = "Milk/day")
    private String milk;

    @ColumnInfo(name = "meat/day")
    private String meat;

    @ColumnInfo(name = "eggs/day")
    private String eggs;

    @ColumnInfo(name = "others")
    private String others;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getMilk() {
        return milk;
    }

    public void setMilk(String milk) {
        this.milk = milk;
    }

    public String getMeat() {
        return meat;
    }

    public void setMeat(String meat) {
        this.meat = meat;
    }

    public String getEggs() {
        return eggs;
    }

    public void setEggs(String eggs) {
        this.eggs = eggs;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }
}
