package com.example.accountant.production;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.accountant.R;
import com.example.accountant.entities.MainData;
import com.example.accountant.entities.RoomDB;

import java.util.List;

public class SeasonsAdapter extends RecyclerView.Adapter<SeasonsAdapter.ViewHolder> {

    //initialize variables
    private List<MainData> dataList;
    private RoomDB database;
    private Activity context;

    public SeasonsAdapter(List<MainData> dataList, Activity context) {
        this.dataList = dataList;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        //initialize view
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.record_view,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeasonsAdapter.ViewHolder holder, int position) {

        //initialize main data
        MainData data = dataList.get(position);
        //initialize database
        database = RoomDB.getInstance(context);
        //set text on text view
        holder.pdtID_textView.setText(data.getProductID());
        holder.milk_textView.setText(data.getMilk());
        holder.meat_textView.setText(data.getMeat());
        holder.egg_textView.setText(data.getEggs());
        holder.other_textView.setText(data.getOthers());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //initialize variable

        TextView pdtID_textView,milk_textView,meat_textView,egg_textView,other_textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //assign variables
            pdtID_textView=itemView.findViewById(R.id.pdt_titleText);
            milk_textView=itemView.findViewById(R.id.milk_pdt_text);
            meat_textView=itemView.findViewById(R.id.meat_pdt_Text);
            egg_textView=itemView.findViewById(R.id.egg_pdt_text);
            other_textView=itemView.findViewById(R.id.other_pdt_Text);
        }
    }
}
