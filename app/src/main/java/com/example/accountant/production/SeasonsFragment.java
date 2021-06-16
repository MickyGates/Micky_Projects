package com.example.accountant.production;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.accountant.R;
import com.example.accountant.entities.MainData;
import com.example.accountant.entities.RoomDB;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class SeasonsFragment extends Fragment {

    RecyclerView recyclerView;
    FloatingActionButton fab;
    List<MainData> record = new ArrayList<>();

    LinearLayoutManager linearLayoutManager;
    RoomDB database;
    SeasonsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_seasons, container, false);

        recyclerView = root.findViewById(R.id.animalRP_RV);
        fab = root.findViewById(R.id.fab_add);

        //initialize database
        database = RoomDB.getInstance(getContext());
        //store database value in data list
        record=database.mainDao().getAll();

        //initialize linear layout manager
        linearLayoutManager = new LinearLayoutManager(getContext());
        //set layout manager
        recyclerView.setLayoutManager(linearLayoutManager);

        //initialize adapter
        adapter=new SeasonsAdapter(SeasonsFragment.this,record);
        //set adapter
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),AnimalProduct.class);
                startActivity(intent);
            }
        });

        return root;
    }

}