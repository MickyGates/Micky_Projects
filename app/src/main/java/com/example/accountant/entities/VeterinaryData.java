package com.example.accountant.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "veterinary")
public class VeterinaryData implements Serializable {
    @NonNull
    @PrimaryKey(autoGenerate = false)
    private String animalID;

    @ColumnInfo(name = "disease")
    private String disease;

    @ColumnInfo(name = "medication")
    private String medication;

    @ColumnInfo(name = "price")
    private String price;

    public String getAnimalID() {
        return animalID;
    }

    public void setAnimalID(String animalID) {
        this.animalID = animalID;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
