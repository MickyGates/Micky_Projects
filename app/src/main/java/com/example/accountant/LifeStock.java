package com.example.accountant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
/*import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.VpnManager;*/
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
/*import android.view.View;

import com.google.android.material.tabs.TabLayout;*/

public class LifeStock extends AppCompatActivity {
    //DrawerLayout drawerLayout;
    /*TabLayout tabLayout;
    ViewPager viewPager;*/

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_stock);

       /* //drawerLayout = findViewById(R.id.drawer_layout);
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);

        tabLayout.addTab(tabLayout.newTab().setText("Total LiveStock"));
        *//*tabLayout.addTab(tabLayout.newTab().setText("LiveStock Sold"));
        tabLayout.addTab(tabLayout.newTab().setText("Available LiveStock"));*//*
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final  LiveStockAdapter adapter = new LiveStockAdapter(getSupportFragmentManager(), this,tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
 
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));*/

        fab = findViewById(R.id.fab_add);

        LiveStockAvailable liveStockAvailable = new LiveStockAvailable();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_container,liveStockAvailable);
        ft.commit();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(v.getContext(), TotalLivestock.class);
               startActivity(intent);

                Toast.makeText(LifeStock.this, "Add user clicked", Toast.LENGTH_SHORT).show();
            }
        });



    }
/*
    public void ClickMenu(View view){
        //open drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);

    }

    public void ClickLogo(View view){
        //close drawer
        CloseDrawer(drawerLayout);
    }

    public static void CloseDrawer(DrawerLayout drawerLayout) {
        //close drawer layout
        //check condition

        if ((drawerLayout.isDrawerOpen(GravityCompat.START))){
            //when drawer is open
            //close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickDashBoard(View view){
        //recreate activity  dashboard
        redirectActivity(this,DashBoard.class);
    }
    public  void ClickMember(View view){
        //redirect to profile activity
        redirectActivity(this,Members.class);
    }
    public void ClickProduction(View view){
        //redirect activity to customers
        redirectActivity(this,Production.class);
    }

    public void ClickFarming(View view){
        //redirect activity to vendors
        redirectActivity(this,Farming.class);
    }

    public void ClickSettings(View view){
        //redirect activity to dashboard
        redirectActivity(this,Setting.class);
    }



    public  void ClickLogout(View view){
        //close app
        logout(this);
    }

    public static void logout(Activity activity) {
        //initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //set title

        builder.setTitle("Logout");

        //set message
        builder.setMessage("Are you sure you want to logout ? ");
        //positive  yes button
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //finish activity
                activity.finishAffinity();
                //exit app
                System.exit(0);
            }
        });

        //negative no button
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //dismiss dialog
                dialog.dismiss();
            }
        });

        //show dialog
        builder.show();
    }

    public static void redirectActivity(Activity activity, Class aClass) {
        //initialize intent
        Intent intent = new Intent(activity,aClass);
        //set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start Activity
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //close drawer
        CloseDrawer(drawerLayout);
    }*/
}