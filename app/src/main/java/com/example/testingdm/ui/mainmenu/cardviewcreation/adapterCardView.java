package com.example.testingdm.ui.mainmenu.cardviewcreation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


import com.example.testingdm.R;

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
        String FILENAME = c + ".txt";
        try {
            setUpStatView(holder, FILENAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        private TextView textViewName;
        private TextView textViewClass;
        private TextView textViewRace;
        private TextView textViewLvl;
        private TextView textViewStr;
        private TextView textViewCon;
        private TextView textViewInt;
        private TextView textViewDex;
        private TextView textViewCha;
        private TextView textViewWis;

        OnCardListener cardListener;

        public MyViewHolder(@NonNull View itemView, OnCardListener cardListener) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewRace = itemView.findViewById(R.id.textViewRace);
            textViewClass = itemView.findViewById(R.id.textViewClass);
            textViewLvl = itemView.findViewById(R.id.textViewLvl);
            textViewStr = itemView.findViewById(R.id.textViewStr);
            textViewCon = itemView.findViewById(R.id.textViewCon);
            textViewInt = itemView.findViewById(R.id.textViewInt);
            textViewDex = itemView.findViewById(R.id.textViewDex);
            textViewCha = itemView.findViewById(R.id.textViewCha);
            textViewWis = itemView.findViewById(R.id.textViewWis);
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

    public void setUpStatView(MyViewHolder holder, String file) throws IOException {
        File nameList = new File(mContext.getFilesDir(), file);
        BufferedReader E = new BufferedReader(new FileReader(mContext.getFilesDir() + "/" + file));
        holder.textViewName.setText(E.readLine());
        holder.textViewClass.setText(E.readLine());
        holder.textViewRace.setText(E.readLine());
        holder.textViewLvl.setText("Level "+E.readLine());
        holder.textViewStr.setText(E.readLine());
        holder.textViewCon.setText(E.readLine());
        holder.textViewInt.setText(E.readLine());
        holder.textViewDex.setText(E.readLine());
        holder.textViewCha.setText(E.readLine());
        holder.textViewWis.setText(E.readLine());
        E.close();
    }
}