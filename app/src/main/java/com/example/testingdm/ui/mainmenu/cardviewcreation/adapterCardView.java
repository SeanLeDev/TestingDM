package com.example.testingdm.ui.mainmenu.cardviewcreation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

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

public class adapterCardView extends RecyclerView.Adapter<adapterCardView.characterViewHolder> {

    private Context mCtx;

    //Array
    private List<String> characterList;
    private CardView card;
    public TextView textViewName;
    private View.OnClickListener onItemClickListener;

    //getting the context and character list with constructor
    public adapterCardView(Context mCtx, List<String> characterList) {
        this.mCtx = mCtx;
        this.characterList = characterList;
    }

    @Override
    public characterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.cardview, null); //SETUP
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                System.out.println("Pussy");
                clickActivity();
            }
        });
        return new characterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(characterViewHolder holder, int position) {
        //getting the character
        String c = characterList.get(position);
        //binding the data with the viewholder views
        holder.textViewName.setText(c);
    }

    public void setItemClickListener(View.OnClickListener clickListener) {
        onItemClickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    class characterViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewLevel;

        public characterViewHolder(View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.card);
            textViewName = itemView.findViewById(R.id.textViewName);
            itemView.setTag(this);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    //OnClickListener for the CardView*****
                    clickActivity();
                }
            });
        }
    }

    public void clickActivity() {
        characterScreen characterScreen = new characterScreen();
        characterScreen.loadDataActivity(textViewName.toString());
    }
}

