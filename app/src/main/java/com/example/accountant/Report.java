package com.example.accountant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class Report extends AppCompatActivity {
    //DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

       // drawerLayout =findViewById(R.id.drawer_layout);
    }

    /*public void ClickMenu(View view){
        //open drawer
        DashBoard.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view){
        //close drawer
        DashBoard.CloseDrawer(drawerLayout);
    }

    public void ClickDashBoard(View view){
        //redirect to dashboard activity
        DashBoard.redirectActivity(this,DashBoard.class);

    }

    public  void ClickMember(View view){
        //redirect to profile activity
        DashBoard.redirectActivity(this,Members.class);

    }

    public void ClickProduction(View view){
        //redirect to customers activity
        DashBoard.redirectActivity(this,Production.class);
    }

    public void ClickFarming(View view){
        //redirect to calendar activity
        DashBoard.redirectActivity(this,Farming.class);
    }

    public void ClickReport(View view){
        //recreate report activity
       recreate();

    }

    public void ClickSettings(View view){
        //redirect to settings activity
        DashBoard.redirectActivity(this,Setting.class);

    }

    public void ClickLogout(View view){
        //close app
        DashBoard.logout(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        DashBoard.CloseDrawer(drawerLayout);
    }*/

}