package com.example.accountant.production;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.accountant.R;
import com.example.accountant.entities.MainDao;
import com.example.accountant.entities.MainData;
import com.example.accountant.entities.RoomDB;
import com.example.accountant.entities.RoomDB_Impl;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Production extends AppCompatActivity {
/*
    //DrawerLayout drawerLayout;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ProductionAdapter adapter;*/

    FloatingActionButton fab_add;
    SeasonsAdapter seasonsAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production);

        fab_add=findViewById(R.id.fab_add);

        SeasonsFragment seasonsFragment = new SeasonsFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_container,seasonsFragment);
        ft.commit();

        /*fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),AnimalProduct.class);
                startActivity(intent);
                Toast.makeText(Production.this, "Add Products Clicked", Toast.LENGTH_SHORT).show();
            }
        });*/
        


    }



}