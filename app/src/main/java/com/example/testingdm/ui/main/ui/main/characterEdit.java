package com.example.testingdm.ui.main.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.testingdm.R;
import com.example.testingdm.ui.main.PageViewModel;


public class characterEdit extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    public int editStorage;
    public String conversion;
    public EditText strInput;
    public EditText chaInput;
    public EditText wisInput;
    public EditText conInput;
    public EditText dexInput;
    public EditText intInput;
    private TextView strBonus;
    private TextView chaBonus;
    private TextView wisBonus;
    private TextView conBonus;
    private TextView dexBonus;
    private TextView intBonus;

    public static characterEdit newInstance(int index) {
        characterEdit fragment = new characterEdit();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
        strInput = (EditText) findViewById(R.id.strInput);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_character_edit, container, false);

        return rootView;
    }

    public void bonusDisplay() {
        conversion = strInput.getText().toString();
        try {
            editStorage = Integer.parseInt(conversion);
        }
        //  Set up button
        catch (NumberFormatException nfe) {

        }

    }
}
