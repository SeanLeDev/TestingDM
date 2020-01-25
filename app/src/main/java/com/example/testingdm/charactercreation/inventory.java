package com.example.testingdm.charactercreation;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.testingdm.R;
import com.example.testingdm.charactercreation.api.apio;
import com.example.testingdm.charactercreation.api.dnd5eapi;
import com.example.testingdm.charactercreation.api.equipment;
import com.example.testingdm.ui.mainmenu.cardviewcreation.ArrayToList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link inventory.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link inventory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class inventory extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private List<String> equipmentList;
    private EditText itemEnter;

    private OnFragmentInteractionListener mListener;

    public inventory() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment inventory.
     */
    // TODO: Rename and change types and number of parameters
    public static inventory newInstance(String param1, String param2) {
        inventory fragment = new inventory();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        equipmentList = new ArrayList<>();
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button itemAdd;
        itemEnter = new EditText(getContext());
        itemAdd = view.findViewById(R.id.itemAddInventory);
        itemEnter = view.findViewById(R.id.itemInput);
        itemAdd.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                String c = itemEnter.getText().toString();
                saveMethod(c);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_inventory, container, false);
        recyclerView = rootview.findViewById(R.id.itemRecyclerList);
        adapterInventoryCardView mAdapter = new adapterInventoryCardView(getContext(), equipmentList);//Need to get Character Data
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);
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

    public void saveMethod(String c){
        final String[][] f = new String[1][3];
        int i = 0;
        while (i < 1) {
            f[i][0] = null;
        }
        f[0][i] = c;
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                apio.apisave(getActivity(), characterScreen.nameInput.getText().toString(), "-e", f);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
