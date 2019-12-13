package com.example.testingdm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;


import java.util.List;


import com.example.testingdm.ui.main.ui.main.characterScreen;

public class adapterCardView extends RecyclerView.Adapter<adapterCardView.characterViewHolder> {

    private Context mCtx;

    //Array
    private List<Character> characterList;

    //getting the context and product list with constructor
    public adapterCardView(Context mCtx, List<Character> characterList) {
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
        Character c = characterList.get(position);
        //binding the data with the viewholder views
        holder.textViewName.setText(c.getName());
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    class characterViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewLevel;

        public characterViewHolder(View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
        }
    }
}
