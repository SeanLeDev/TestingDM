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
    List<equipment> equipmentList;

    public adapterInventoryCardView(Context mContext, List<equipment> characterList) {
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
        equipment c = equipmentList.get(position);
        holder.textViewName.setText(c.getName());
        if(c.getDmgDice() == null){
            holder.textViewProperties.setText(c.getEquipmentCat());
        }else{
            holder.textViewProperties.setText(c.getDmgDice()+"+"+c.getDmgBonus());
        }
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