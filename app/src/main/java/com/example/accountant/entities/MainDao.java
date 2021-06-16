package com.example.accountant.entities;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface MainDao {
    //insert query
    @Insert(onConflict = REPLACE)
    void insertMainData(MainData mainData);

    @Insert(onConflict = REPLACE)
    void insertVeterinaryData(VeterinaryData veterinaryData);


    //get all the data query
    @Query("SELECT * FROM production WHERE productID = productID")
    List<MainData> getAll();

    @Query("SELECT * FROM veterinary WHERE animalID = animalID")
    List<VeterinaryData> getVeterinary();




}
