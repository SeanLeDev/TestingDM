package com.example.testingdm.npc;

import android.content.Intent;
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
import android.widget.Toast;

import com.example.testingdm.R;

import java.io.IOException;

public class npcView extends AppCompatActivity {

    public static String[][] npc = new String[100][11];

    public Switch sus;
    public Switch trust;
    public Switch chaos;
    public Switch neutral;
    public Switch law;
    public Switch good;
    public Switch evil;
    public Switch companion;
    public Switch secret;
    public EditText nameInput;
    public EditText background;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npc_view);
        nameInput = findViewById(R.id.NPCname);
        background = findViewById(R.id.background);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getIDchips();
        getIDtextFields();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                getIDtextFields();
                getIDchips();
                getChipsChecked();
                nsave();
                restartApp();

            }
        });
    }

    public void restartApp() { //Restart app Intent
        Intent restartIntent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
        restartIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(restartIntent);
    }

    private void getIDchips() { //Gets id for usage
        sus = new Switch(this);
        trust = new Switch(this);
        chaos = new Switch(this);
        neutral = new Switch(this);
        law = new Switch(this);
        good = new Switch(this);
        evil = new Switch(this);
        companion = new Switch(this);
        secret = new Switch(this);
        sus = findViewById(R.id.suspicious);
        trust = findViewById(R.id.trusted);
        chaos = findViewById(R.id.chaotic);
        neutral = findViewById(R.id.neutral);
        law = findViewById(R.id.lawful);
        good = findViewById(R.id.good);
        evil = findViewById(R.id.evil);
        companion = findViewById(R.id.companion);
        secret = findViewById(R.id.secret);
    }

    private void getIDtextFields() { //Gets textfield ids
        nameInput = findViewById(R.id.NPCname);
        background = findViewById(R.id.background);
    }

    private void getChipsChecked() { //Checks if chips are checked
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
    public void nsave(){ //Save method

        int i = 0;
        while (npc [i][0] != null) {
            i++;
        }
        npc[i][0] = nameInput.getText().toString();
        npc[i][1] = String.valueOf(sus.isChecked());
        npc[i][2] = String.valueOf(trust.isChecked());
        npc[i][3] = String.valueOf(chaos.isChecked());
        npc[i][4] = String.valueOf(neutral.isChecked());
        npc[i][5] = String.valueOf(law.isChecked());
        npc[i][6] = String.valueOf(good.isChecked());
        npc[i][7] = String.valueOf(evil.isChecked());
        npc[i][8] = String.valueOf(companion.isChecked());
        npc[i][9] = String.valueOf(secret.isChecked());
        npc [i][10] = background.getText().toString();
        try {
            npcio.nsave(this,i);
            Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
