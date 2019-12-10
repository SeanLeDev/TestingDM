package com.example.testingdm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import static com.example.testingdm.ui.main.ui.main.characterScreen.stats;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


import com.example.testingdm.ui.main.ui.main.characterScreen;

public class adapterCardView extends RecyclerView.Adapter<adapterCardView.characterViewHolder> {
    //this context we will use to inflate the layout
    private Context mCtx;

    //Array
    List<Character> characterList;

    //getting the context and product list with constructor
    public adapterCardView(MainActivity mainActivity, List<Character> characterList) {
        this.mCtx = mCtx;
        this.characterList = characterList;
    }

    @Override
    public characterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.cardview, null);
        return new characterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(characterViewHolder holder, int position) {
        //getting the product of the specified position
        Character c = characterList.get(position);

        //binding the data with the viewholder views


    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class characterViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
        ImageView imageView;

        public characterViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
