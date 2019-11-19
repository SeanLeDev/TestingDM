package com.example.testingdm.ui.main.ui.main;

import android.os.Bundle;

import com.example.testingdm.R;
import com.example.testingdm.ui.main.ui.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.testingdm.R.id.view_pager;
import static com.example.testingdm.R.layout.activity_character_screen;
import static com.example.testingdm.R.layout.activity_main;

import com.example.testingdm.ValueCalculation;


public class characterScreen extends AppCompatActivity {

    private String name;
    private int strength;
    private int intelligence;
    private int wisdom;
    private int dexterity;
    private int charisma;
    private int constitution;
    public int editStorage;
    public String conversion;
    public Button saveButton;
    public EditText nameInput;
    public EditText strInput;
    public EditText chaInput;
    public EditText wisInput;
    public EditText conInput;
    public EditText dexInput;
    public EditText intInput;
    public TextView strBonus;
    public TextView chaBonus;
    public TextView wisBonus;
    public TextView conBonus;
    public TextView dexBonus;
    public TextView intBonus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        //Inputs
        nameInput = findViewById(R.id.nameInput);
        strInput = findViewById(R.id.strInput);
        chaInput = findViewById(R.id.chaInput);
        wisInput = findViewById(R.id.wisInput);
        conInput = findViewById(R.id.conInput);
        dexInput = findViewById(R.id.dexInput);
        intInput = findViewById(R.id.intInput);
        //Save Button
        saveButtonClicked c = new saveButtonClicked();
        //Bonus View
        strBonus = findViewById(R.id.strBonus);
        chaBonus = findViewById(R.id.chaBonus);
        wisBonus = findViewById(R.id.wisBonus);
        conBonus = findViewById(R.id.conBonus);
        dexBonus = findViewById(R.id.dexBonus);
        intBonus = findViewById(R.id.intBonus);

        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strBonus.setText(ValueCalculation.getBonus(Integer.valueOf(strInput.getText().toString())));
                chaBonus.setText(ValueCalculation.getBonus(Integer.valueOf(chaInput.getText().toString())));
                wisBonus.setText(ValueCalculation.getBonus(Integer.valueOf(wisInput.getText().toString())));
                conBonus.setText(ValueCalculation.getBonus(Integer.valueOf(conInput.getText().toString())));
                dexBonus.setText(ValueCalculation.getBonus(Integer.valueOf(dexInput.getText().toString())));
                intBonus.setText(ValueCalculation.getBonus(Integer.valueOf(intInput.getText().toString())));
            }
        });


        //configureFabButton();
    }




}