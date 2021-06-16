package com.example.accountant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.accountant.entities.RoomDB;
import com.example.accountant.entities.VeterinaryData;

import java.util.ArrayList;
import java.util.List;

public class Treatment extends AppCompatActivity {
    EditText animalID,disease,medicine,price;
    Button bt_save;
    List<VeterinaryData> vet_da = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment);

        animalID = findViewById(R.id.treatmentID);
        disease = findViewById(R.id.disease_name);
        medicine=findViewById(R.id.medicine_name);
        price=findViewById(R.id.price);
        bt_save=findViewById(R.id.save_tr);

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveRecords();


            }
        });


    }

    private void saveRecords() {
        final String s_animalID = animalID.getText().toString().trim();
        final String s_disease = disease.getText().toString().trim();
        final String s_medicine = medicine.getText().toString().trim();
        final String s_price = price.getText().toString().trim();

        if (s_animalID.isEmpty()){
            animalID.setError("Record Required");
            animalID.requestFocus();
            return;
        }

        if (s_disease.isEmpty()){
            disease.setError("Record Required");
            disease.requestFocus();
            return;
        }
        if (s_medicine.isEmpty()){
            medicine.setError("Record Required");
            medicine.requestFocus();
            return;
        }
        if (s_price.isEmpty()){
            price.setError("Record Required");
            price.requestFocus();
            return;
        }

        class SaveTask extends AsyncTask<Void,Void,Void>{

            @Override
            protected Void doInBackground(Void... voids) {
                //create records
                VeterinaryData veterinaryData = new VeterinaryData();
                veterinaryData.setAnimalID(s_animalID);
                veterinaryData.setDisease(s_disease);
                veterinaryData.setMedication(s_medicine);
                veterinaryData.setPrice(s_price);

                //adding to database
                RoomDB.getInstance(getApplicationContext())
                        .mainDao()
                        .insertVeterinaryData(veterinaryData);


                return  null;
            }

            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                Toast.makeText(Treatment.this, "Record Saved", Toast.LENGTH_SHORT).show();
            }

        }
        SaveTask saveTask = new SaveTask();
        saveTask.execute();
        }


}