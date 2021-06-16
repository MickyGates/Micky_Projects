package com.example.accountant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class Veterinary extends AppCompatActivity {

    FloatingActionButton fab_add;

    //DrawerLayout drawerLayout;
    /*TabLayout tabLayout;
    ViewPager2 viewPager2;
    VetAdapter adapter;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veterinary);

        fab_add=findViewById(R.id.fab_add);

       VetReport vetReport = new VetReport();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_container,vetReport);
        ft.commit();


        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Treatment.class);
                startActivity(intent);
            }
        });

       /* //assign variables
       // drawerLayout = findViewById(R.id.drawer_layout);
        tabLayout = findViewById(R.id.tab_layout_vet);
        viewPager2 = findViewById(R.id.view_pager2_vet);

        FragmentManager fm = getSupportFragmentManager();
        adapter = new VetAdapter(fm, getLifecycle());
        viewPager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Treatment"));
        tabLayout.addTab(tabLayout.newTab().setText("Veterinary Report"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });*/




    }



   /* public void ClickMenu(View view){
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
        recreate();
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