package com.example.accountant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.accountant.production.Production;

import java.util.ArrayList;

public class DashBoard extends AppCompatActivity implements StaticRVAdapter.StaticRVViewHolder.OnItemClickedListener {
    private RecyclerView recyclerView;
    private StaticRVAdapter staticRVAdapter;
    private ArrayList<StaticRVModel> item;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        //initialize variables
        //drawerLayout = findViewById(R.id.dashBordDrawer);

        item = new ArrayList<>();
        item.add(new StaticRVModel(R.drawable.ic_veterinay, "Veterinary"));
        item.add(new StaticRVModel(R.drawable.ic_livestock, "LifeStock"));
        item.add(new StaticRVModel(R.drawable.ic_product, "Production"));
        item.add(new StaticRVModel(R.drawable.ic_expenditure, "Expenditure"));
        item.add(new StaticRVModel(R.drawable.ic_sales, "Sales"));
        item.add(new StaticRVModel(R.drawable.ic_calendar, "Calendar"));

        recyclerView = findViewById(R.id.recyclerviewDashBoard);

        staticRVAdapter = new StaticRVAdapter(item, this, this);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        recyclerView.setAdapter(staticRVAdapter);


    }

   /* public void ClickMenu(View view) {
        //open drawer
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {
        //open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);

    }

    public void ClickLogo(View view) {
        //close drawer
        CloseDrawer(drawerLayout);
    }

    public static void CloseDrawer(DrawerLayout drawerLayout) {
        //close drawer layout
        //check condition

        if ((drawerLayout.isDrawerOpen(GravityCompat.START))) {
            //when drawer is open
            //close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickDashBoard(View view) {
        //recreate activity  dashboard
        recreate();
    }

    public void ClickMember(View view) {
        //redirect to profile activity
        redirectActivity(this, Members.class);
    }

    public void ClickProduction(View view) {
        //redirect activity to customers
        redirectActivity(this, Production.class);
    }

    public void ClickFarming(View view) {
        //redirect activity to vendors
        redirectActivity(this, Farming.class);
    }

    public void ClickSettings(View view) {
        //redirect activity to dashboard
        redirectActivity(this, Setting.class);
    }


    public void ClickLogout(View view) {
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
        Intent intent = new Intent(activity, aClass);
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

    @Override
    public void itemClicked(int adapterPosition, View view) {
        StaticRVModel model = item.get(adapterPosition);
        if (model.getText().equals("LifeStock")) {
            startActivity(new Intent(this, LifeStock.class));

        } else if (model.getText().equals("Veterinary")) {
            startActivity(new Intent(this, Veterinary.class));

        } else if (model.getText().equals("Calendar")) {
            startActivity(new Intent(this, Calendar.class));

        } else if (model.getText().equals("Production")) {
            startActivity(new Intent(this, Production.class));

        } else if (model.getText().equals("Expenditure")) {
            startActivity(new Intent(this, Expenditure.class));

        } else if (model.getText().equals("Sales")) {
            startActivity(new Intent(this, Sales.class));

        } else {
            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
        }
    }
}