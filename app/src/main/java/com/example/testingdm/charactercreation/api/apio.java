package com.example.testingdm.charactercreation.api;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.example.testingdm.charactercreation.characterScreen.stats;

public class apio {

    private static String FILENAME;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void apisave(Context con, String n, String i, String [][] a) throws IOException {
        FILENAME = n + i +".txt";
        File file = new File(con.getFilesDir(), FILENAME);
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) { //Writes to the file

            int m = 0;
            while(m<a.length) {
                out.write(a[0][m] + System.lineSeparator());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!file.exists()) {
            file.createNewFile();
        }

    }

    /* If you wanna find the files, go to "View", "Tool Window",
    "Device File Explorer, data, data,
    com.example.testingdm
     */

    //TODO
    public static String[][] apiload(Context con, String fname) throws IOException {
       File name = new File(con.getFilesDir(), fname+".txt");
        BufferedReader reader = new BufferedReader(new FileReader(name));
        String [][] stat = new String[0][20];
        int i =  0;
        while (i < 20) {
            String a = reader.readLine();
            if(a != null) {
                System.out.println(a); //For debugging
                stat[0][i] = a;
                i++;
            } else {
                break;
            }//Else
        }//While loop
        reader.close();
        return stat;
    }

}
