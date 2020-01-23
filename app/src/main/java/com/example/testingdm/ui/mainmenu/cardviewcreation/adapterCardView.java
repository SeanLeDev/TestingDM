package com.example.testingdm.ui.mainmenu.cardviewcreation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;


import java.io.IOException;
import java.util.List;


import com.example.testingdm.R;
import com.example.testingdm.charactercreation.IO;
import com.example.testingdm.charactercreation.characterEdit;
import com.example.testingdm.charactercreation.characterScreen;
import com.example.testingdm.characterfiles.Character;
import com.example.testingdm.ui.mainmenu.MainActivity;

import static androidx.core.content.ContextCompat.startActivity;

public class adapterCardView extends RecyclerView.Adapter<adapterCardView.MyViewHolder> {

    Context mContext;
    List<String> characterList;
    OnCardListener mOnCardListener;

    public adapterCardView(Context mContext, List<String> characterList, OnCardListener OnCardListener) {
        this.mContext = mContext;
        this.characterList = characterList;
        this.mOnCardListener = OnCardListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.cardview, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v, mOnCardListener);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String c = characterList.get(position);
        holder.textViewName.setText(c);
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        private TextView textViewName;
        OnCardListener cardListener;

        public MyViewHolder(@NonNull View itemView, OnCardListener cardListener) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            this.cardListener = cardListener;
            itemView.setOnClickListener(this);
        }

        public String getTextViewName() {
            return textViewName.toString();
        }

        @Override
        public void onClick(View v) {
            cardListener.onCardClick(getAdapterPosition());
        }
    }

    public interface OnCardListener{
        void onCardClick(int position);
    }
}