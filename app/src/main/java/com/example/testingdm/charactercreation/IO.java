package com.example.testingdm.charactercreation;


import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import static com.example.testingdm.charactercreation.characterScreen.stats;

public class IO {
    private static String FILENAME;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void save(Context con, int i) throws IOException {
        File nameList = new File(con.getFilesDir(), "Names");
        FILENAME = stats[i][0] + ".txt";
        File file = new File(con.getFilesDir(), FILENAME);
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) { //Writes to the file
            out.write(stats[i][0] + System.lineSeparator()); //Name
            out.write(stats[i][1] + System.lineSeparator());
            out.write(stats[i][2] + System.lineSeparator());
            out.write(stats[i][3] + System.lineSeparator());
            out.write(stats[i][4] + System.lineSeparator());
            out.write(stats[i][5] + System.lineSeparator());
            out.write(stats[i][6] + System.lineSeparator());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        if (!nameList.exists()) {
            nameList = new File(con.getFilesDir(), "Names");
        }
        try (BufferedWriter out = new BufferedWriter(new FileWriter(nameList, true))) {
            out.write(stats[i][0] + System.lineSeparator());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* If you wanna find the files, go to "View", "Tool Window",
    "Device File Explorer, data, data,
    com.example.testingdm
     */
    public static int load(Context con, String n) throws IOException {
        String path = con.getFilesDir().toString();
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
