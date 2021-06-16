package com.example.accountant.production;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.accountant.R;
import com.example.accountant.entities.MainData;
import com.example.accountant.entities.RoomDB;

import java.util.ArrayList;
import java.util.List;

public class ProductsFragment extends Fragment {
    EditText pdt_ID,milk_pdt,meat_pdt,eggs_pdt,other_pdt ;
    Button button;
    LinearLayoutManager linearLayoutManager;
    RecyclerView recyclerView;
    List<MainData> da = new ArrayList<>();
    RoomDB database;
    SeasonsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_products, container, false);

        pdt_ID = root.findViewById(R.id.pdt_ID);
        milk_pdt = root.findViewById(R.id.milk_pdt);
        meat_pdt = root.findViewById(R.id.meat_pdt);
        eggs_pdt = root.findViewById(R.id.eggs_pdt);
        other_pdt = root.findViewById(R.id.other_pdt);
        button = root.findViewById(R.id.save_record);

        //initialize database
        database= RoomDB.getInstance(getContext());
        //store records
        da = database.mainDao().getAll();

        //initialize linear layout manager
        linearLayoutManager = new LinearLayoutManager(getContext());
        //set layout manager
        recyclerView.setLayoutManager(linearLayoutManager);

        //initialize adapter
        adapter = new SeasonsAdapter(ProductsFragment.this,da);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveRecords();
            }
        });

        return root;
    }

    private void saveRecords() {
        final String s_livestock = pdt_ID.getText().toString().trim();
        final String s_milkProducts = milk_pdt.getText().toString().trim();
        final String s_meatProducts = meat_pdt.getText().toString().trim();
        final String s_eggsProducts = eggs_pdt.getText().toString().trim();
        final String s_otherProducts = other_pdt.getText().toString().trim();


        if(!s_livestock.equals("")){
            //when text is not empty
            //initialize main data
            MainData md = new MainData();
            //set text in main data
            md.setProductID(s_livestock);
            //insert text in database
            database.mainDao().insertMainData(md);
            //clear edit text
            pdt_ID.setText("");
            //notify when data is inserted
            da.clear();
            da.addAll(database.mainDao().getAll());
            adapter.notifyDataSetChanged();

        }else {
                pdt_ID.setError("Record Required");
                pdt_ID.requestFocus();
                return;

        }
        if(!s_milkProducts.equals("")){
            //when text is not empty
            //initialize main data
            MainData md = new MainData();
            //set text in main data
            md.setMilk(s_milkProducts);
            //insert text in database
            database.mainDao().insertMainData(md);
            //clear edit text
            milk_pdt.setText("");
            //notify when data is inserted
            da.clear();
            da.addAll(database.mainDao().getAll());
            adapter.notifyDataSetChanged();

        }

        if(!s_meatProducts.equals("")) {
            //when text is not empty
            //initialize main data
            MainData md = new MainData();
            //set text in main data
            md.setMeat(s_meatProducts);
            //insert text in database
            database.mainDao().insertMainData(md);
            //clear edit text
            meat_pdt.setText("");
            //notify when data is inserted
            da.clear();
            da.addAll(database.mainDao().getAll());
            adapter.notifyDataSetChanged();
        }
        else {
            meat_pdt.setError("Record Required");
            meat_pdt.requestFocus();
            return;
        }
        if(!s_eggsProducts.equals("")) {
            //when text is not empty
            //initialize main data
            MainData md = new MainData();
            //set text in main data
            md.setEggs(s_eggsProducts);
            //insert text in database
            database.mainDao().insertMainData(md);
            //clear edit text
            eggs_pdt.setText("");
            //notify when data is inserted
            da.clear();
            da.addAll(database.mainDao().getAll());
            adapter.notifyDataSetChanged();
        }
        else {
            eggs_pdt.setError("Record Required");
            eggs_pdt.requestFocus();
            return;
        }
        if(!s_otherProducts.equals("")) {
            //when text is not empty
            //initialize main data
            MainData md = new MainData();
            //set text in main data
            md.setOthers(s_meatProducts);
            //insert text in database
            database.mainDao().insertMainData(md);
            //clear edit text
            other_pdt.setText("");
            //notify when data is inserted
            da.clear();
            da.addAll(database.mainDao().getAll());
            adapter.notifyDataSetChanged();
        }
        else {
            other_pdt.setError("Record Required");
            other_pdt.requestFocus();
            return;
        }
        class SaveTask extends AsyncTask<Void, Void, Void>{
            @Override
            protected Void doInBackground(Void... voids) {
                //creating a records
                MainData mainData = new MainData();
                mainData.setProductID(s_livestock);
                mainData.setMilk(s_milkProducts);
                mainData.setMeat(s_meatProducts);
                mainData.setEggs(s_eggsProducts);
                mainData.setOthers(s_otherProducts);

                //adding to database
                RoomDB.getInstance(getContext().getApplicationContext())
                        .mainDao()
                        .insertMainData(mainData);

                return null;
            }

            @Override
            protected void onPostExecute(Void unused) {
                super.onPostExecute(unused);
                Toast.makeText(getContext(),"Saved",Toast.LENGTH_LONG).show();
            }
        }

        SaveTask saveTask = new SaveTask();
        saveTask.execute();

    }
}