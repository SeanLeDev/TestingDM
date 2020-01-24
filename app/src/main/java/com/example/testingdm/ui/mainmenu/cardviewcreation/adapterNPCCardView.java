package com.example.testingdm.ui.mainmenu.cardviewcreation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testingdm.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class adapterNPCCardView extends RecyclerView.Adapter<adapterNPCCardView.MyViewHolder> {

    Context mContext;
    List<String> npcList;

    public adapterNPCCardView(Context mContext, List<String> npcList) {
        this.mContext = mContext;
        this.npcList = npcList;
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
        String c = npcList.get(position);
        holder.textViewName.setText(npcList.get(position));
    }

    @Override
    public int getItemCount() {
        return npcList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.itemName);
        }
    }

    public void npcDisplaySetup(MyViewHolder holder,String file) throws IOException {
        File nameList = new File(mContext.getFilesDir(), file);
        BufferedReader E = new BufferedReader(new FileReader(mContext.getFilesDir() + "/" + file));
    }
}