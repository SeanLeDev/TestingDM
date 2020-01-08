package com.example.testingdm.charactercreation;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.testingdm.R;
import com.example.testingdm.ui.mainmenu.MainActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.io.BufferedReader;

import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static androidx.core.content.ContextCompat.startActivity;
import static com.example.testingdm.R.id.view_pager;
import static com.example.testingdm.R.layout.activity_main;

import com.example.testingdm.characterfiles.ValueCalculation;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


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
    public EditText nameInput;
    public static EditText strInput;
    public static EditText chaInput;
    public static EditText wisInput;
    public static EditText conInput;
    public static EditText dexInput;
    public static EditText intInput;
    public static TextView nameDisplay;
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
        TabLayout tabs = findViewById(R.id.tabLayout);
        tabs.setupWithViewPager(viewPager);
        //Inputs
        getIDinput();
        //Bonus View
        getIDBonus();
        getIDSkills();
        configureFabButton();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dnd5eapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        dnd5eapi dnd5eapi = retrofit.create(dnd5eapi.class);

        Call<List<equipment>> call = dnd5eapi.getEquipment();

        call.enqueue(new Callback<List<equipment>>() {
            @Override
            public void onResponse(Call<List<equipment>> call, Response<List<equipment>> response) {

            }

            @Override
            public void onFailure(Call<List<equipment>> call, Throwable t) {

            }
        });
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
        try {
            IO.save(this, i);
        } catch (IOException e) {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
    }

    public static void load(String n) throws IOException {
        int characterRow = 0;
        for (int l = 0; l == 100; l++) {
            if (n.equals(stats[l][0])) {
                characterRow = l;
                break;
            } else
                continue;
            }
        //Temporary before the actual name list comes
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
        }
    }

    public void setStatDisplay() {
        getIDBonus();
        getIDinput();
        nameDisplay.setText(nameInput.getText().toString());
        strBonus.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(strInput.getText().toString()))));
        chaBonus.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(chaInput.getText().toString()))));
        wisBonus.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(wisInput.getText().toString()))));
        conBonus.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(conInput.getText().toString()))));
        dexBonus.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(dexInput.getText().toString()))));
        intBonus.setText(String.valueOf(ValueCalculation.getBonus(Integer.valueOf(intInput.getText().toString()))));
    }

    public void setSkillsDisplay() {
        getIDBonus();
        getIDSkills();
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

    public void getIDinput(){
        nameInput = findViewById(R.id.nameInput);
        strInput = findViewById(R.id.strInput);
        chaInput = findViewById(R.id.chaInput);
        wisInput = findViewById(R.id.wisInput);
        conInput = findViewById(R.id.conInput);
        dexInput = findViewById(R.id.dexInput);
        intInput = findViewById(R.id.intInput);
    }

    public void getIDBonus(){
        nameDisplay = findViewById(R.id.nameDisplay);
        strBonus = findViewById(R.id.strBonus);
        chaBonus = findViewById(R.id.chaBonus);
        wisBonus = findViewById(R.id.wisBonus);
        conBonus = findViewById(R.id.conBonus);
        dexBonus = findViewById(R.id.dexBonus);
        intBonus = findViewById(R.id.intBonus);
    }
    public void getIDSkills(){
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
    }

    public void loadDataActivity(String n) {
        Intent i = new Intent(characterScreen.this, MainActivity.class);
        startActivity(i);
        try {
            characterScreen.load(n);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}