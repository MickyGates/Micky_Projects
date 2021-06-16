package com.example.accountant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.view.View.*;
import static com.example.accountant.StaticRVAdapter.StaticRVViewHolder.*;

public class StaticRVAdapter extends RecyclerView.Adapter<StaticRVAdapter.StaticRVViewHolder> {


    private ArrayList<StaticRVModel> items;
    Context context;
    boolean check = true;
    boolean select = true;
    OnItemClickedListener listener;
    int row_index = -1;

    public StaticRVAdapter(ArrayList<StaticRVModel> items, Context mContext, OnItemClickedListener clicked) {
        this.items = items;
        context = mContext;
        listener = clicked;
    }

    @NonNull
    @Override
    public StaticRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);

        return new StaticRVViewHolder(view, listener, context);
    }

    @Override
    public void onBindViewHolder(@NonNull StaticRVViewHolder holder, int position) {
        StaticRVModel currentItem = items.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.textView.setText(currentItem.getText());

//        holder.gridLayoutManager.setOnClickListener(v -> {
//            Intent intent = new Intent(context, LifeStock.class);
//            context.startActivity(intent);
//
//            row_index = position;
//            notifyDataSetChanged();
//        });
        if (select) {
            if (position == 0) {
                holder.gridLayoutManager.setBackgroundResource(R.drawable.static_rv_selected);
            } else {
                if (row_index == position) {
                    holder.gridLayoutManager.setBackgroundResource(R.drawable.static_rv_selected);

                } else {
                    holder.gridLayoutManager.setBackgroundResource(R.drawable.static_rv);
                }
            }

        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class StaticRVViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        ImageView imageView;
        TextView textView;
        View gridLayoutManager;
        CardView cardView;
        Context context;
        OnItemClickedListener listener;

        public StaticRVViewHolder(@NonNull View itemView, OnItemClickedListener clicked, Context context) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView1);
            textView = itemView.findViewById(R.id.textView1);
            gridLayoutManager = itemView.findViewById(R.id.gridlayout);
            cardView = itemView.findViewById(R.id.card_view);
            listener = clicked;
            context = context;
            itemView.setOnClickListener(this);

            Context finalContext = context;
//            itemView.setOnClickListener(v -> {
//                finalContext.startActivity(new Intent(finalContext, Farming.class));
//            });

        }


        @Override
        public void onClick(View v) {
            listener.itemClicked(getAdapterPosition(), itemView);
        }

        interface OnItemClickedListener {
            void itemClicked(int adapterPosition, View itemView);
        }

    }

}
