package com.example.testingdm.ui.mainmenu;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.example.testingdm.R;

import com.example.testingdm.charactercreation.ViewPagerAdapter;
import com.example.testingdm.charactercreation.characterScreen;
import com.example.testingdm.npc.npcView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import static com.example.testingdm.charactercreation.IO.*;


public class MainActivity extends FragmentActivity implements dialogClass.deleteDialogListener{


    private int STORAGE_PERMISSION_CODE = 1;
    private int numPages = 3;
    private TabLayout tabs;
    public ImageButton deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.view_pager);
        tabs = findViewById(R.id.tabLayout);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.AddFragment(new characterFragment(), "Characters");
        adapter.AddFragment(new npcFragment(), "NPCs");
        adapter.AddFragment(new fragment_table(), "Table"); //Setting tab names
        try {
            load(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        viewPager.setAdapter(adapter);
        tabs.setupWithViewPager(viewPager);
        deleteButtonConfig();
        configureFabButton();
    }

    public void openDialog(){
        dialogClass dialog = new dialogClass();
        dialog.show(getSupportFragmentManager(),"dialog delete");
    }

    private void configureFabButton() { //Sets up Floating Action Button
        FloatingActionButton fab;
        final TabLayout tabs = findViewById(R.id.tabLayout);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                int position = tabs.getSelectedTabPosition();
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "Storage Permission has already been granted.", Toast.LENGTH_SHORT).show();
                    switch (position) {
                        case 0:
                            startActivity(new Intent(MainActivity.this, characterScreen.class));
                            break;
                        case 1:
                            startActivity(new Intent(MainActivity.this, npcView.class));
                            break;
                        case 2:
                            // third tab is selected
                            break;
                    }

                } else {
                    storageRequest();
                }

            }
        });

    }

    public void storageRequest() { //Storage Request Pop up
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            new AlertDialog.Builder(this)
                    .setTitle("Storage Required")
                    .setMessage("DM's Assistant requires storage space to store Player Characters")
                    .setPositiveButton("Ay!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this, (new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}), STORAGE_PERMISSION_CODE);
                            startActivity(new Intent(MainActivity.this, characterScreen.class));
                        }
                    })
                    .setNegativeButton("Nay!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(this, (new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}), STORAGE_PERMISSION_CODE);
        }
    }

    public void deleteButtonConfig(){ //Hooking up Delete Button
        deleteButton = findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) { //Connected to the Storage Request
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Welcome to the DM's Assistant!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "YOU SHALL NOT PASS!", Toast.LENGTH_SHORT);

            }

        }
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void applyTexts(String characterDeleteName) { //Gets String from Delete popup
        try {
            delete(this,characterDeleteName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
