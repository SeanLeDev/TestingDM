package com.example.testingdm.ui.main;

import android.content.Intent;
import android.os.Bundle;


import com.example.testingdm.MainActivity;
import com.example.testingdm.R;
import com.example.testingdm.characterEdit;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.testingdm.ui.main.ui.main.SectionsPagerAdapter;


public class characterScreen extends AppCompatActivity {

    private String name;
    private int strength;
    private int intelligence;
    private int wisdom;
    private int dexterity;
    private int charisma;
    private int constitution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_screen);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        TabLayout tabs = findViewById(R.id.tabs);
        FloatingActionButton fab = findViewById(R.id.fab);

    }


    private void configureFabButton() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}