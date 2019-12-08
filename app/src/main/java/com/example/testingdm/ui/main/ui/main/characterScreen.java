package com.example.testingdm.ui.main.ui.main;

import android.os.Build;
import android.os.Bundle;

import com.example.testingdm.IO;
import com.example.testingdm.R;
import com.example.testingdm.ui.main.ui.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.io.BufferedReader;

import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.inputmethod.InputContentInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import static com.example.testingdm.R.id.view_pager;
import static com.example.testingdm.R.layout.activity_character_screen;
import static com.example.testingdm.R.layout.activity_main;

import com.example.testingdm.ValueCalculation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class characterScreen extends AppCompatActivity {

    public static String[][] stats = new String[100][7];

    private String name;
    public String nameLoad;
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
    public TextView nameDisplay;
    public TextView strBonus;
    public TextView chaBonus;
    public TextView wisBonus;
    public TextView conBonus;
    public TextView dexBonus;
    public TextView intBonus;
    public TextView acrobatics;
    public TextView animalHandling;
    public TextView arcana;
    public TextView athletics;
    public TextView deception;
    public TextView history;
    public TextView insight;
    public TextView intimidation;
    public TextView investigation;
    public TextView medicine;
    public TextView nature;
    public TextView perception;
    public TextView performance;
    public TextView persuasion;
    public TextView religion;
    public TextView slightOfHand;
    public TextView stealth;
    public TextView survival;

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

        acrobatics = findViewById(R.id.acrobaticsBonus);
        animalHandling = findViewById(R.id.animalHandlingBonus);
        arcana = findViewById(R.id.arcanaBonus);
        athletics = findViewById(R.id.athleticsBonus);
        deception = findViewById(R.id.deceptionBonus);
        history = findViewById(R.id.historyBonus);
        insight = findViewById(R.id.insightBonus);
        intimidation = findViewById(R.id.intimidationBonus);
        investigation = findViewById(R.id.investigationBonus);
        medicine = findViewById(R.id.medicineBonus);
        nature = findViewById(R.id.natureBonus);
        perception = findViewById(R.id.perceptionBonus);
        performance = findViewById(R.id.performanceBonus);
        persuasion = findViewById(R.id.persuasionBonus);
        religion = findViewById(R.id.religionBonus);
        slightOfHand = findViewById(R.id.slightOfHandBonus);
        stealth = findViewById(R.id.stealthBonus);
        survival = findViewById(R.id.survivalBonus);


        configureFabButton();
    }


    public void configureFabButton() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                setStatDisplay();
                setSkillsDisplay();
                asave();
                //IO.load();

            }
        });

    }

    //This method loads the character data into our array
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void asave() {
        int i = 0;
        while (stats[i][0] != null) {
            i++;
        }
        stats[i][0] = nameInput.getText().toString();
        stats[i][1] = conInput.getText().toString();
        stats[i][2] = strInput.getText().toString();
        stats[i][3] = dexInput.getText().toString();
        stats[i][4] = intInput.getText().toString();
        stats[i][5] = wisInput.getText().toString();
        stats[i][6] = chaInput.getText().toString();
        IO.save(i);
        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();

    }

    public String load() throws IOException {
        int characterRow = 0;

        BufferedReader reader = new BufferedReader(new FileReader("Name.txt"));
        for (int l = 0; l == 100; l++) {
            if (reader.readLine().equals(nameLoad)) {
                name = nameLoad;
            } else {
                continue;
            }
        }
        characterRow = IO.load(name); //Temporary before the actual name list comes
        for (int l = 0; l < 7; l++) {
            switch (l) { //Loads all the stats into the inputs
                case 0:
                    nameDisplay.setText(stats[characterRow][l]);
                    break;
                case 1:
                    conInput.setText(stats[characterRow][l]);
                    break;
                case 3:
                    strInput.setText(stats[characterRow][l]);
                    break;
                case 4:
                    dexInput.setText(stats[characterRow][l]);
                    break;
                case 5:
                    intInput.setText(stats[characterRow][l]);
                    break;
                case 6:
                    wisInput.setText(stats[characterRow][l]);
                    break;
                case 7:
                    chaInput.setText(stats[characterRow][l]);
            }
            return null;
        }
        return null; //Return statement here
    }

    public void setStatDisplay() {
            nameInput = findViewById(R.id.nameInput);
            strInput = findViewById(R.id.strInput);
            chaInput = findViewById(R.id.chaInput);
            wisInput = findViewById(R.id.wisInput);
            conInput = findViewById(R.id.conInput);
            dexInput = findViewById(R.id.dexInput);
            intInput = findViewById(R.id.intInput);
            nameDisplay = findViewById(R.id.nameDisplay);
            strBonus = findViewById(R.id.strBonus);
            chaBonus = findViewById(R.id.chaBonus);
            wisBonus = findViewById(R.id.wisBonus);
            conBonus = findViewById(R.id.conBonus);
            dexBonus = findViewById(R.id.dexBonus);
            intBonus = findViewById(R.id.intBonus);

            nameDisplay.setText(nameInput.getText().toString());
            strBonus.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(strInput.getText().toString()))));
            chaBonus.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(chaInput.getText().toString()))));
            wisBonus.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(wisInput.getText().toString()))));
            conBonus.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(conInput.getText().toString()))));
            dexBonus.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(dexInput.getText().toString()))));
            intBonus.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(intInput.getText().toString()))));
        }

    public void setSkillsDisplay() {
            strBonus = findViewById(R.id.strBonus);
            chaBonus = findViewById(R.id.chaBonus);
            wisBonus = findViewById(R.id.wisBonus);
            conBonus = findViewById(R.id.conBonus);
            dexBonus = findViewById(R.id.dexBonus);
            intBonus = findViewById(R.id.intBonus);
            acrobatics = findViewById(R.id.acrobaticsBonus);
            animalHandling = findViewById(R.id.animalHandlingBonus);
            arcana = findViewById(R.id.arcanaBonus);
            athletics = findViewById(R.id.athleticsBonus);
            deception = findViewById(R.id.deceptionBonus);
            history = findViewById(R.id.historyBonus);
            insight = findViewById(R.id.insightBonus);
            intimidation = findViewById(R.id.intimidationBonus);
            investigation = findViewById(R.id.investigationBonus);
            medicine = findViewById(R.id.medicineBonus);
            nature = findViewById(R.id.natureBonus);
            perception = findViewById(R.id.perceptionBonus);
            performance = findViewById(R.id.performanceBonus);
            persuasion = findViewById(R.id.persuasionBonus);
            religion = findViewById(R.id.religionBonus);
            slightOfHand = findViewById(R.id.slightOfHandBonus);
            stealth = findViewById(R.id.stealthBonus);
            survival = findViewById(R.id.survivalBonus);

            //Strength skills bonus
            athletics.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(strInput.getText().toString()))));
            //Dexterity skills bonus
            acrobatics.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(dexInput.getText().toString()))));
            slightOfHand.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(dexInput.getText().toString()))));
            stealth.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(dexInput.getText().toString()))));
            //Wisdom skills bonus
            animalHandling.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(wisInput.getText().toString()))));
            insight.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(wisInput.getText().toString()))));
            medicine.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(wisInput.getText().toString()))));
            perception.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(wisInput.getText().toString()))));
            survival.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(wisInput.getText().toString()))));
            //Intelligence skills bonus
            arcana.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(intInput.getText().toString()))));
            history.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(intInput.getText().toString()))));
            investigation.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(intInput.getText().toString()))));
            nature.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(intInput.getText().toString()))));
            religion.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(intInput.getText().toString()))));
            //Charisma skills bonus
            deception.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(chaInput.getText().toString()))));
            intimidation.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(chaInput.getText().toString()))));
            performance.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(chaInput.getText().toString()))));
            persuasion.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(chaInput.getText().toString()))));
        }


}