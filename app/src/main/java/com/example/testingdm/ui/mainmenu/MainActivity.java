package com.example.testingdm.ui.mainmenu;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.example.testingdm.R;
import com.example.testingdm.charactercreation.IO;
import com.example.testingdm.characterfiles.Character;
import com.example.testingdm.npc.npcView;
import com.example.testingdm.ui.mainmenu.cardviewcreation.ArrayToList;
import com.example.testingdm.ui.mainmenu.cardviewcreation.adapterCardView;
import com.example.testingdm.charactercreation.characterScreen;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.testingdm.ui.mainmenu.characterFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.testingdm.charactercreation.characterScreen.stats;


public class MainActivity extends AppCompatActivity {

    List<String> characterList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private int STORAGE_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabLayout);
        tabs.setupWithViewPager(viewPager);



        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        recyclerView = findViewById(R.id.characterList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        characterList = new ArrayList<>();
        try {
            System.out.println("YESSSSSSSSS");
            characterList = ArrayToList.convertFileToList(this);
            System.out.println(characterList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(stats[1][0] + "**************");
            IO.load(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        adapterCardView mAdapter = new adapterCardView(this, characterList); //Need to get Character Data
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) rv.getTag();
                int position = viewHolder.getAdapterPosition();
                System.out.println("onTouchEvent");
                startActivity(new Intent(MainActivity.this, characterScreen.class));
                System.out.println("onIntTouchEvent");
                return false;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) rv.getTag();
                int position = viewHolder.getAdapterPosition();
                System.out.println("onTouchEvent");
                startActivity(new Intent(MainActivity.this, characterScreen.class));
                try {
                    characterScreen.load(characterList.get(position));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                System.out.println("onRequestTouchEvent");
            }
        });

        System.out.println(characterList.isEmpty());
        configureFabButton();

    }

    private void configureFabButton() {
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

    public void storageRequest() {
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


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Welcome to the DM's Assistant!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "YOU SHALL NOT PASS!", Toast.LENGTH_SHORT);

            }

        }
    }

    public void onTouchEvent(View view) {
        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag();
        int position = viewHolder.getAdapterPosition();
        System.out.println("onTouchEvent");
        startActivity(new Intent(MainActivity.this, characterScreen.class));
        try {
            characterScreen.load(characterList.get(position));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
