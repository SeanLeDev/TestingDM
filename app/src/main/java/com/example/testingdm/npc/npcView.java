package com.example.testingdm.npc;

import android.os.Bundle;

import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

import com.example.testingdm.R;

public class npcView extends AppCompatActivity {

    public Chip sus;
    public Chip trust;
    public Chip chaos;
    public Chip neutral;
    public Chip law;
    public Chip good;
    public Chip evil;
    public Chip companion;
    public Chip secret;
    public EditText name;
    public EditText background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_npc_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getIDchips();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void getIDchips() {
        Chip sus = findViewById(R.id.suspicious);
        Chip trust = findViewById(R.id.trusted);
        Chip chaos = findViewById(R.id.chaotic);
        Chip neutral = findViewById(R.id.neutral);
        Chip law = findViewById(R.id.lawful);
        Chip good = findViewById(R.id.good);
        Chip evil = findViewById(R.id.evil);
        Chip companion = findViewById(R.id.companion);
        Chip secret = findViewById(R.id.secret);
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

}
