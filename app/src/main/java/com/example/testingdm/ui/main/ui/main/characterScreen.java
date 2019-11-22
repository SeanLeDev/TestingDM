package com.example.testingdm.ui.main.ui.main;

import android.os.Bundle;

import com.example.testingdm.R;
import com.example.testingdm.ui.main.ui.main.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class characterScreen extends AppCompatActivity {

    private static String FILENAME;


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


    public void save(View v) {
        String text = nameInput.getText().toString();
        FileOutputStream fos = null;
        FILENAME = text + ".txt";
        try {
            fos = openFileOutput(FILENAME, MODE_PRIVATE);
            fos.write(text.getBytes());

            nameInput.getText().clear();

            Toast.makeText(this, "Saved to " + getFilesDir() + "/" + FILENAME, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void load(View v) {

        FileInputStream fis = null;

        try {
            fis = openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void configureFabButton() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(v);
                System.out.println(strInput.getText());
                strength = Integer.valueOf(strInput.getText().toString());
                strBonus.setText(ValueCalculation.getBonus(strength));
                chaBonus.setText(ValueCalculation.getBonus(Integer.valueOf(chaInput.getText().toString())));
                wisBonus.setText(ValueCalculation.getBonus(Integer.valueOf(wisInput.getText().toString())));
                conBonus.setText(ValueCalculation.getBonus(Integer.valueOf(conInput.getText().toString())));
                dexBonus.setText(ValueCalculation.getBonus(Integer.valueOf(dexInput.getText().toString())));
                intBonus.setText(ValueCalculation.getBonus(Integer.valueOf(intInput.getText().toString())));
                //Setting up Name
                nameDisplay.setText(nameInput.getText().toString());
                //Strength skills bonus
                athletics.setText(ValueCalculation.getBonus(Integer.valueOf(strInput.getText().toString())));
                //Dexterity skills bonus
                acrobatics.setText(ValueCalculation.getBonus(Integer.valueOf(dexInput.getText().toString())));
                slightOfHand.setText(ValueCalculation.getBonus(Integer.valueOf(dexInput.getText().toString())));
                stealth.setText(ValueCalculation.getBonus(Integer.valueOf(dexInput.getText().toString())));
                //Wisdom skills bonus
                animalHandling.setText(ValueCalculation.getBonus(Integer.valueOf(wisInput.getText().toString())));
                insight.setText(ValueCalculation.getBonus(Integer.valueOf(wisInput.getText().toString())));
                medicine.setText(ValueCalculation.getBonus(Integer.valueOf(wisInput.getText().toString())));
                perception.setText(ValueCalculation.getBonus(Integer.valueOf(wisInput.getText().toString())));
                survival.setText(ValueCalculation.getBonus(Integer.valueOf(wisInput.getText().toString())));
                //Intelligence skills bonus
                arcana.setText(ValueCalculation.getBonus(Integer.valueOf(intInput.getText().toString())));
                history.setText(ValueCalculation.getBonus(Integer.valueOf(intInput.getText().toString())));
                investigation.setText(ValueCalculation.getBonus(Integer.valueOf(intInput.getText().toString())));
                nature.setText(ValueCalculation.getBonus(Integer.valueOf(intInput.getText().toString())));
                religion.setText(ValueCalculation.getBonus(Integer.valueOf(intInput.getText().toString())));
                //Charisma skills bonus
                deception.setText(ValueCalculation.getBonus(Integer.valueOf(chaInput.getText().toString())));
                intimidation.setText(ValueCalculation.getBonus(Integer.valueOf(chaInput.getText().toString())));
                performance.setText(ValueCalculation.getBonus(Integer.valueOf(chaInput.getText().toString())));
                persuasion.setText(ValueCalculation.getBonus(Integer.valueOf(chaInput.getText().toString())));
                load(v);

            }
        });
    }
}