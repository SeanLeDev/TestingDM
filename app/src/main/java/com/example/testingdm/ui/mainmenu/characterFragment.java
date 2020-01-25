package com.example.testingdm.ui.mainmenu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testingdm.R;
import com.example.testingdm.charactercreation.IO;
import com.example.testingdm.charactercreation.characterScreen;
import com.example.testingdm.ui.mainmenu.cardviewcreation.ArrayToList;
import com.example.testingdm.ui.mainmenu.cardviewcreation.adapterCardView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.testingdm.charactercreation.characterScreen.stats;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link characterFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link characterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class characterFragment extends Fragment implements adapterCardView.OnCardListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    View rootView;
    private FragmentListener listener;
    private RecyclerView recyclerView;
    private OnFragmentInteractionListener mListener;
    private List<String> characterList;

    @Override
    public void onCardClick(int position) {
        Intent intent = new Intent(getContext(), characterScreen.class);
        String nameSend = characterList.get(position);
        intent.putExtra("Test",characterList.get(position));
        startActivity(intent);
    }

    public interface FragmentListener{
        void inputPress(boolean pressed);
    }

    public characterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment characterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static characterFragment newInstance() {
        characterFragment fragment = new characterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapterCardView mAdapter = new adapterCardView(getContext(), characterList, this);//Need to get Character Data
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_character, container, false);
        recyclerView = rootview.findViewById(R.id.characterRecyclerList);
        adapterCardView mAdapter = new adapterCardView(getContext(), characterList, this);//Need to get Character Data
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);

        return rootview;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        characterList = new ArrayList<>();
        try {
            characterList = ArrayToList.convertFileToList(getContext());
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);

    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
