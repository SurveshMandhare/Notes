package com.example.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ExampleViewHolder> {

    ArrayList<ArrayFormat> arrayList;

    public AdapterClass(ArrayList<ArrayFormat> exampleList) {
        this.arrayList = exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carditemlayout, parent, false);
        ExampleViewHolder viewHolder = new ExampleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ArrayFormat currentView = arrayList.get(position);
        holder.mDate.setText(currentView.getDate());
        holder.mTitle.setText(currentView.getTitle());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {
        TextView mDate, mTitle;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mDate = itemView.findViewById(R.id.date);
            this.mTitle = itemView.findViewById(R.id.title);
        }
    }
}
