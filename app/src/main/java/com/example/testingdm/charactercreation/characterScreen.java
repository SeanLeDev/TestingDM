package com.example.testingdm.charactercreation;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.example.testingdm.R;
import com.example.testingdm.charactercreation.api.Features;
import com.example.testingdm.charactercreation.api.apio;
import com.example.testingdm.charactercreation.api.classes;
import com.example.testingdm.charactercreation.api.dnd5eapi;
import com.example.testingdm.charactercreation.api.equipment;
import com.example.testingdm.charactercreation.api.levels;
import com.example.testingdm.charactercreation.api.proficiencies;
import com.example.testingdm.charactercreation.api.skills;
import com.example.testingdm.characterfiles.Skills;
import com.example.testingdm.ui.mainmenu.MainActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.io.BufferedReader;

import androidx.annotation.RequiresApi;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static androidx.core.content.ContextCompat.startActivity;
import static com.example.testingdm.R.id.view_pager;
import static com.example.testingdm.R.layout.activity_character_screen;
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
//TODO Lots of redunt

public class characterScreen extends AppCompatActivity {

    public static String[][] stats = new String[100][7];
    private PagerAdapter pagerAdapter;
    private TabLayout tabs;
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
        //SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        ViewPager viewPager = findViewById(view_pager);
        tabs = findViewById(R.id.tabLayout);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new characterEdit(), "Stats");
        adapter.AddFragment(new inventory(), "Inventory");
        adapter.AddFragment(new com.example.testingdm.charactercreation.skills(), "Skills");
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
        //Inputs
        getIDinput();
        //Bonus View
        getIDBonus();
        getIDSkills();
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
                features("i");//TODO Replace i with user input and give this its independent save button
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

    public void getIDinput() {
        nameInput = findViewById(R.id.nameInput);
        strInput = findViewById(R.id.strInput);
        chaInput = findViewById(R.id.chaInput);
        wisInput = findViewById(R.id.wisInput);
        conInput = findViewById(R.id.conInput);
        dexInput = findViewById(R.id.dexInput);
        intInput = findViewById(R.id.intInput);
    }

    public void getIDBonus() {
        nameDisplay = findViewById(R.id.nameDisplay);
        strBonus = findViewById(R.id.strBonus);
        chaBonus = findViewById(R.id.chaBonus);
        wisBonus = findViewById(R.id.wisBonus);
        conBonus = findViewById(R.id.conBonus);
        dexBonus = findViewById(R.id.dexBonus);
        intBonus = findViewById(R.id.intBonus);
    }

    public void getIDSkills() {
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


    //Beginning of the api interaction
    //TODO Lots of redundant code here need to clean up

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void features(String k) {
        Retrofit retrofit = new Retrofit.Builder() //Need this to access the api
                .baseUrl("http://dnd5eapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final dnd5eapi dnd5eapi = retrofit.create(dnd5eapi.class);
        final String[][] f = new String[1][6];
        int i = 0;
        while (i < 7) {
            f[0][i] = null;
        }
        Call<com.example.testingdm.charactercreation.api.Features> call = dnd5eapi.getFeatures(k); //Unsure what to put here

        call.enqueue(new Callback<Features>() {
            @Override
            public void onResponse(Call<Features> call, Response<Features> response) { //Connection to api is succesful

                if (!response.isSuccessful()) {
                    System.out.println("Code: " + response.code());
                    return;
                }
                Features feature = response.body(); //response.body is the object you get from api
                String cont = ""; //console testing
                cont += "ID: " + response.body().getId() + "\n";
                f[0][0] = response.body().getId();
                cont += "Index: " + response.body().getIndex() + "\n";
                f[0][1] = response.body().getIndex();
                cont += "Name: " + response.body().getName() + "\n";
                f[0][2] = response.body().getName();
                cont += "Level: " + response.body().getLevel() + "\n";
                f[0][3] = Integer.toString(response.body().getLevel());
                cont += "Description: " + response.body().getDesc() + "\n";
                f[0][4] = response.body().getDesc().toString();
                cont += "URL: " + response.body().getUrl() + "\n";
                f[0][5] = response.body().getUrl();
                //apiTest = findViewById(R.id.testAPI);
                System.out.println(cont + "testing this shit");
            }

            @Override
            public void onFailure(Call<Features> call, Throwable t) {
                //TextView apiTest = findViewById(R.id.testAPI);
                String message = t.getMessage();
                System.out.println(message + "&&&&&&&&&&&&&&&&&&&&&"); //bug output
                //apiTest.setText(message);
            }


        });
        try {
            apio.apisave(this, nameInput.getText().toString(), "-f", f);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void classes(String k) {
        Retrofit retrofit = new Retrofit.Builder() //Need this to access the api
                .baseUrl("http://dnd5eapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final dnd5eapi dnd5eapi = retrofit.create(dnd5eapi.class);
        final String[][] f = new String[1][12];
        int i = 0;
        while (i < 12) {
            f[0][i] = null;
        }
        Call<com.example.testingdm.charactercreation.api.classes> call = dnd5eapi.getclasses(k); //Unsure what to put here

        call.enqueue(new Callback<classes>() {
            @Override
            public void onResponse(Call<classes> call, Response<classes> response) { //Connection to api is succesful

                if (!response.isSuccessful()) {
                    System.out.println("Code: " + response.code());
                    return;
                }
                classes classes = response.body(); //response.body is the object you get from api
                String cont = ""; //console testing
                cont += "ID: " + response.body().getId() + "\n";
                f[0][0] = response.body().getId();
                cont += "Index: " + response.body().getIndex() + "\n";
                f[0][1] = response.body().getIndex();
                cont += "Name: " + response.body().getName() + "\n";
                f[0][2] = response.body().getName();
                cont += "Hit Die: " + response.body().getHitdie() + "\n";
                f[0][3] = Integer.toString(response.body().getHitdie());
                cont += "Choice: " + response.body().getChoice() + "\n";
                f[0][4] = String.valueOf(response.body().getChoice());
                cont += "Proficiencies" + response.body().getProficiencies() + "\n";
                f[0][5] = String.valueOf(response.body().getProficiencies());
                cont += "Class Saving Throw" + response.body().getClassSavingThrow() + "\n";
                f[0][6] = String.valueOf(response.body().getClassSavingThrow());
                cont += "Starting Gear" + response.body().getStartingGear() + "\n";
                f[0][7] = String.valueOf(response.body().getStartingGear());
                cont += "Class Levels" + response.body().getClassLevels() + "\n";
                f[0][8] = String.valueOf(response.body().getClassLevels());
                cont += "Subclasses " + response.body().getSubclasses() + "\n";
                f[0][9] = String.valueOf(response.body().getSubclasses());
                cont += "Spell Casting " + response.body().getSpellcasting() + "\n";
                f[0][10] = String.valueOf(response.body().getSpellcasting());
                cont += "Url " + response.body().getUrl() + "\n";
                f[0][11] = response.body().getUrl();
                //apiTest = findViewById(R.id.testAPI);
                System.out.println(cont + "testing this shit");
            }

            @Override
            public void onFailure(Call<classes> call, Throwable t) {
                //TextView apiTest = findViewById(R.id.testAPI);
                String message = t.getMessage();
                System.out.println(message + "&&&&&&&&&&&&&&&&&&&&&"); //bug output
                //apiTest.setText(message);
            }

        });
        try {
            apio.apisave(this, nameInput.getText().toString(), "-c", f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void proficiencies(String k) {
        Retrofit retrofit = new Retrofit.Builder() //Need this to access the api
                .baseUrl("http://dnd5eapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final dnd5eapi dnd5eapi = retrofit.create(dnd5eapi.class);
        final String[][] f = new String[1][7];
        int i = 0;
        while (i < 7) {
            f[0][i] = null;
        }
        Call<com.example.testingdm.charactercreation.api.proficiencies> call = dnd5eapi.getproficiency(k); //Unsure what to put here

        call.enqueue(new Callback<proficiencies>() {
            @Override
            public void onResponse(Call<proficiencies> call, Response<proficiencies> response) { //Connection to api is succesful

                if (!response.isSuccessful()) {
                    System.out.println("Code: " + response.code());
                    return;
                }
                proficiencies proficiencies = response.body(); //response.body is the object you get from api
                String cont = ""; //console testing
                f[0][0] = response.body().getId();
                f[0][1] = response.body().getIndex();
                f[0][2] = response.body().getType();
                f[0][3] = response.body().getName();
                f[0][4] = String.valueOf(response.body().getProficiencyClass());
                f[0][5] = String.valueOf(response.body().getRace());
                f[0][6] = response.body().getUrl();
            }

            @Override
            public void onFailure(Call<proficiencies> call, Throwable t) {
                //TextView apiTest = findViewById(R.id.testAPI);
                String message = t.getMessage();
                System.out.println(message + "&&&&&&&&&&&&&&&&&&&&&"); //bug output
                //apiTest.setText(message);
            }


        });
        try {
            apio.apisave(this, nameInput.getText().toString(), "-p", f);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void skills(String k) {
        Retrofit retrofit = new Retrofit.Builder() //Need this to access the api
                .baseUrl("http://dnd5eapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final dnd5eapi dnd5eapi = retrofit.create(dnd5eapi.class);
        final String[][] f = new String[1][6];
        int i = 0;
        while (i < 6) {
            f[0][i] = null;
        }
        Call<com.example.testingdm.charactercreation.api.skills> call = dnd5eapi.getskill(k); //Unsure what to put here

        call.enqueue(new Callback<skills>() {
            @Override
            public void onResponse(Call<skills> call, Response<skills> response) { //Connection to api is succesful

                if (!response.isSuccessful()) {
                    System.out.println("Code: " + response.code());
                    return;
                }
                skills skills = response.body(); //response.body is the object you get from api
                f[0][0] = response.body().getId();
                f[0][1] = response.body().getIndex();
                f[0][2] = response.body().getName();
                f[0][3] = String.valueOf(response.body().getDesc());
                f[0][4] = String.valueOf(response.body().getAbility_score());
                f[0][5] = String.valueOf(response.body().getUrl());
            }

            @Override
            public void onFailure(Call<skills> call, Throwable t) {
                //TextView apiTest = findViewById(R.id.testAPI);
                String message = t.getMessage();
                System.out.println(message + "&&&&&&&&&&&&&&&&&&&&&"); //bug output
                //apiTest.setText(message);
            }


        });
        try {
            apio.apisave(this, nameInput.getText().toString(), "-s", f);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void equipment(String k) {
        Retrofit retrofit = new Retrofit.Builder() //Need this to access the api
                .baseUrl("http://dnd5eapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final dnd5eapi dnd5eapi = retrofit.create(dnd5eapi.class);
        final String[][] f = new String[1][15];
        int i = 0;
        while (i < 15) {
            f[0][i] = null;
        }
        Call<com.example.testingdm.charactercreation.api.equipment> call = dnd5eapi.getEquipment(k); //Unsure what to put here

        call.enqueue(new Callback<equipment>() {
            @Override
            public void onResponse(Call<equipment> call, Response<equipment> response) { //Connection to api is succesful

                if (!response.isSuccessful()) {
                    System.out.println("Code: " + response.code());
                    return;
                }
                equipment equipment = response.body(); //response.body is the object you get from api
                f[0][0] = response.body().get_Id();
                f[0][1] = response.body().getIndex();
                f[0][2] = response.body().getName();
                f[0][3] = String.valueOf(response.body().getEquipmentCat());
                f[0][4] = String.valueOf(response.body().getWeaponCat());
                f[0][5] = String.valueOf(response.body().getWeaponRng());
                f[0][6] = response.body().getCategoryRng();
                f[0][7] = String.valueOf(response.body().getDamage());
                f[0][8] = String.valueOf(response.body().getCost());
                f[0][9] = String.valueOf(response.body().getDmgType());
                f[0][10] = String.valueOf(response.body().getDmgDice());
                f[0][11] = String.valueOf(response.body().getDmgBonus());
                f[0][12] = String.valueOf(response.body().getWeaponProp());
                f[0][13] = String.valueOf(response.body().getRange());
                f[0][14] = String.valueOf(response.body().getWeight());
            }

            @Override
            public void onFailure(Call<equipment> call, Throwable t) {
                //TextView apiTest = findViewById(R.id.testAPI);
                String message = t.getMessage();
                System.out.println(message + "&&&&&&&&&&&&&&&&&&&&&"); //bug output
                //apiTest.setText(message);
            }


        });
        try {
            apio.apisave(this, nameInput.getText().toString(), "-e", f);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void levels(String k) {
        Retrofit retrofit = new Retrofit.Builder() //Need this to access the api
                .baseUrl("http://dnd5eapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final dnd5eapi dnd5eapi = retrofit.create(dnd5eapi.class);
        final String[][] f = new String[1][11];
        int i = 0;
        while (i < 11) {
            f[0][i] = null;
        }
        Call<com.example.testingdm.charactercreation.api.levels> call = dnd5eapi.getlevels(k); //Unsure what to put here

        call.enqueue(new Callback<levels>() {
            @Override
            public void onResponse(Call<levels> call, Response<levels> response) { //Connection to api is succesful

                if (!response.isSuccessful()) {
                    System.out.println("Code: " + response.code());
                    return;
                }
                levels levels = response.body(); //response.body is the object you get from api
                f[0][0] = response.body().getId();
                f[0][1] = response.body().getIndex();
                f[0][2] = String.valueOf(response.body().getLevel());
                f[0][3] = String.valueOf(response.body().getAbilityScoreBonus());
                f[0][4] = String.valueOf(response.body().getProfBonus());
                f[0][5] = String.valueOf(response.body().getFeatureChoices());
                f[0][0] = String.valueOf(response.body().getFeatures());
                f[0][1] = (String) response.body().getSpellcasting();
                f[0][2] = String.valueOf(response.body().getClassSpecific());
                f[0][3] = String.valueOf(response.body().getCharacterClass());
                f[0][4] = String.valueOf(response.body().getUrl());
            }


            @Override
            public void onFailure(Call<levels> call, Throwable t) {
                //TextView apiTest = findViewById(R.id.testAPI);
                String message = t.getMessage();
                System.out.println(message + "&&&&&&&&&&&&&&&&&&&&&"); //bug output
                //apiTest.setText(message);
            }


        });
        try {
            apio.apisave(this, nameInput.getText().toString(), "-l", f);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}