package com.example.testingdm;


import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import static com.example.testingdm.ui.main.ui.main.characterScreen.stats;

public class IO {
    private static String FILENAME;



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void save(int i){
        FILENAME = stats[i][0] + ".txt";
        try (PrintWriter out = new PrintWriter(FILENAME)) {
            out.println(stats[i][0]);
            out.println(stats[i][1]);
            out.println(stats[i][2]);
            out.println(stats[i][3]);
            out.println(stats[i][4]);
            out.println(stats[i][5]);
            out.println(stats[i][6]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void load(){

    }
}
