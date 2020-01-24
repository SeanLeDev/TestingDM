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
        holder.textViewName.setText(c);
        String FILENAME = c+".txt";
        try {
            npcDisplaySetup(holder,FILENAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return npcList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewPersonality;
        private TextView textViewAlignment;
        private TextView textViewStatus;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.itemName);
            textViewPersonality = itemView.findViewById(R.id.npcPersonality);
            textViewAlignment = itemView.findViewById(R.id.npcAlignment);
            textViewStatus = itemView.findViewById(R.id.npcStatus);
        }
    }

    public void npcDisplaySetup(MyViewHolder holder,String file) throws IOException {
        File nameList = new File(mContext.getFilesDir(), file);
        BufferedReader E = new BufferedReader(new FileReader(mContext.getFilesDir() + "/" + file));
        for(int i = 0; i==10; i++){
            String temp = E.readLine();
            switch(i){
                case 0:
                    continue;
                case 1:
                    if(temp.equals("true")){
                        holder.textViewPersonality.append("Suspicious ");
                        System.out.println("hmhmhmhm");
                    }
                    continue;
                case 2:
                    if(temp.equals("true")){
                        holder.textViewPersonality.append("Trusted");
                        System.out.println("hmhmhmhm");
                    }
                    continue;
                case 3:
                    if(temp.equals("true")){
                        holder.textViewAlignment.append("Chaotic ");
                        System.out.println("hmhmhmhm");
                    }
                    continue;
                case 4:
                    if(temp.equals("true")){
                        holder.textViewAlignment.append("Neutral ");
                        System.out.println("hmhmhmhm");
                    }
                    continue;
                case 5:
                    if(temp.equals("true")){
                        holder.textViewAlignment.append("Good ");
                        System.out.println("hmhmhmhm");
                    }
                    continue;
                case 6:
                    if(temp.equals("true")){
                        holder.textViewAlignment.append("Evil ");
                        System.out.println("hmhmhmhm");
                    }
                    continue;
                case 7:
                    if(temp.equals("true")){
                        holder.textViewAlignment.append("Lawful ");
                        System.out.println("hmhmhmhm");
                    }
                    continue;
                case 8:
                    if(temp.equals("true")){
                        holder.textViewStatus.append("Companion ");
                        System.out.println("hmhmhmhm");
                    }
                    continue;
                case 9:
                    if(temp.equals("true")){
                        holder.textViewStatus.append("Secret ");
                        System.out.println("hmhmhmhm");
                    }
                    continue;
            }

        }
    }
}