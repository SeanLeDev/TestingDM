package com.example.testingdm.charactercreation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testingdm.R;
import com.example.testingdm.charactercreation.api.equipment;

import java.util.List;

public class adapterInventoryCardView extends RecyclerView.Adapter<adapterInventoryCardView.MyViewHolder> {

    Context mContext;
    List<String> equipmentList;

    public adapterInventoryCardView(Context mContext, List<String> equipmentList) {
        this.mContext = mContext;
        this.equipmentList = equipmentList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.inventorycardview, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String c = equipmentList.get(position);
        holder.textViewName.setText(equipmentList.get(position));
        holder.textViewProperties.setText(equipmentList.get(position+1));


    }

    @Override
    public int getItemCount() {
        return equipmentList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewProperties;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.itemName);
            textViewProperties = itemView.findViewById(R.id.attributes);
        }
    }
}