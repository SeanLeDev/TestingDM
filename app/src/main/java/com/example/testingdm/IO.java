package com.example.testingdm;


import android.content.Context;
import android.os.Build;
import android.os.Environment;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import static com.example.testingdm.ui.main.ui.main.characterScreen.stats;

public class IO {
    private static String FILENAME;
    private File nameList;
    static  String path = Environment.getDataDirectory().toString();




    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void save(int i) throws IOException {
        File nameList = new File(Environment.getExternalStorageDirectory(), "Names");
        FILENAME = stats[i][0] + ".txt";
        String dir = Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(dir + "/" + FILENAME);
        try (PrintWriter out = new PrintWriter(file)) {
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
        if (!nameList.exists()) {
            nameList.mkdirs();
        }
        try (PrintWriter out = new PrintWriter(nameList)) {
            out.println(stats[i][0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //The following code is to test to ensure our file save function works correclty



    }

    public static int load(String n) throws IOException {
        String path = Environment.getDataDirectory().toString();

        BufferedReader inputStream = null;
        String file;
        int row = 0;
        for (int counter = 0; counter == stats.length; counter++) {
            if (stats[counter][0].equals(n)) {
                row = counter;
                break;
            } else {
                continue;
            }
        }
        file = path +"/"+ n + ".txt";

        inputStream = new BufferedReader(new FileReader(file));
        return row;
    }

}
