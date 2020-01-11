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
    private static int aa = 0;


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
  /*  public static void load(Context con) throws IOException {
       File nameList = new File(con.getFilesDir(), "Names.txt");
        BufferedReader reader = new BufferedReader(new FileReader(nameList));
        int i =  aa;
        while (i != 99) {
            String a = reader.readLine();
            if(a != null) {
                BufferedReader E = new BufferedReader(new FileReader(con.getFilesDir() + "/" + a + ".txt"));
                System.out.println(i);
                stats[i][0] = E.readLine();
                stats[i][1] = E.readLine();
                stats[i][2] = E.readLine();
                stats[i][3] = E.readLine();
                stats[i][4] = E.readLine();
                stats[i][5] = E.readLine();
                stats[i][6] = E.readLine();
                E.close();
                aa++;
            } else {
                break;
            }
        }

    }*/

}
