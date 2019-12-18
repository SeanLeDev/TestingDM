package com.example.testingdm.ui.mainmenu.cardviewcreation;

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
import com.example.testingdm.charactercreation.characterScreen;
import com.example.testingdm.characterfiles.Character;
import com.example.testingdm.ui.mainmenu.MainActivity;

import static androidx.core.content.ContextCompat.startActivity;

public class adapterCardView extends RecyclerView.Adapter<adapterCardView.characterViewHolder> {

    private Context mCtx;

    //Array
    private List<String> characterList;
    private CardView card;

    //getting the context and product list with constructor
    public adapterCardView(Context mCtx, List<String> characterList) {
        this.mCtx = mCtx;
        this.characterList = characterList;
    }

    @Override
    public characterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.cardview, null); //SETUP

        return new characterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(characterViewHolder holder, int position) {
        //getting the character
        String c = characterList.get(position);
        //binding the data with the viewholder views
        holder.textViewName.setText(c);

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
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        //startActivity(new Intent(MainActivity.this, characterScreen.class)); //Take a look
                        characterScreen.load(textViewName.toString());  //setup
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        public String getCharacterName() {
            String s = textViewName.toString();
            return s;
        }
    }
}
