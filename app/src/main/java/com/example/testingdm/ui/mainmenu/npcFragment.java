package com.example.testingdm.ui.mainmenu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testingdm.R;
import com.example.testingdm.ui.mainmenu.cardviewcreation.ArrayToList;
import com.example.testingdm.ui.mainmenu.cardviewcreation.adapterCardView;
import com.example.testingdm.ui.mainmenu.cardviewcreation.adapterNPCCardView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link npcFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link npcFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class npcFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private RecyclerView recyclerView;
    private List<String> npcList;


    private OnFragmentInteractionListener mListener;

    public npcFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment npcFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static npcFragment newInstance() {
        npcFragment fragment = new npcFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        npcList = new ArrayList<>();
        try {
            npcList = ArrayToList.convertNPCFileToList(getContext());
            System.out.println(npcList);
            System.out.println("success");
        } catch (IOException e) {
            System.out.println("Fail" + e);
            e.printStackTrace();
        }
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_npc, container, false);
        recyclerView = rootview.findViewById(R.id.npcRecyclerList);
        System.out.println("AAAAAAAAAAAAAAAAAAAAAA");
        adapterNPCCardView mAdapter = new adapterNPCCardView(getContext(), npcList);//Need to get Character Data
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        System.out.println(npcList.isEmpty() + ".....");
        recyclerView.setAdapter(mAdapter);
        System.out.println(npcList);
        System.out.println(npcList.isEmpty());
        return rootview;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
