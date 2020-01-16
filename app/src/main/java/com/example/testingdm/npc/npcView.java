package com.example.testingdm.npc;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import com.example.testingdm.R;

import java.io.IOException;

public class npcView extends AppCompatActivity {

    public static String[][] npc = new String[100][10];

    public Switch sus;
    public Switch trust;
    public Switch chaos;
    public Switch neutral;
    public Switch law;
    public Switch good;
    public Switch evil;
    public Switch companion;
    public Switch secret;
    public EditText name;
    public EditText background;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npc_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getIDchips();
        getIDtextFields();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                nsave();
            }
        });
    }

    private void getIDchips() {
        Switch sus = findViewById(R.id.suspicious);
        Switch trust = findViewById(R.id.trusted);
        Switch chaos = findViewById(R.id.chaotic);
        Switch neutral = findViewById(R.id.neutral);
        Switch law = findViewById(R.id.lawful);
        Switch good = findViewById(R.id.good);
        Switch evil = findViewById(R.id.evil);
        Switch companion = findViewById(R.id.companion);
        Switch secret = findViewById(R.id.secret);
    }

    private void getIDtextFields() {
        EditText name = findViewById(R.id.NPCname);
        EditText background = findViewById(R.id.background);
    }

    private void getChipsChecked() {
        getIDchips();
        sus.isChecked();
        trust.isChecked();
        chaos.isChecked();
        neutral.isChecked();
        law.isChecked();
        good.isChecked();
        evil.isChecked();
        companion.isChecked();
        secret.isChecked();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void nsave(){
        getIDtextFields();
        getIDchips();
        getChipsChecked();
        int i = 0;
        while (npc [i][0] != null) {
            i++;
        }
        npc [i][0] = name.getText().toString();
        npc [i][1] = sus.toString();
        npc [i][2] = trust.toString();
        npc [i][3] = chaos.toString();
        npc [i][4] = neutral.toString();
        npc [i][5] = law.toString();
        npc [i][6] = good.toString();
        npc [i][7] = evil.toString();
        npc [i][8] = companion.toString();
        npc [i][9] = secret.toString();
        npc [i][10] = background.getText().toString();

        try {
            npcio.nsave(this,i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
