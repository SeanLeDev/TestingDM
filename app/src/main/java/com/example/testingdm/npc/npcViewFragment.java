package com.example.testingdm.npc;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testingdm.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class npcViewFragment extends Fragment {

    public npcViewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_npc_view, container, false);
    }
}
