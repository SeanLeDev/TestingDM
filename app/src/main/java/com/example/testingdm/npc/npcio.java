package com.example.testingdm.npc;

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

import static com.example.testingdm.npc.npcView.npc;


public class npcio
{
    private static String FILE;
    private static int aa = 0;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void nsave(Context con, int i) throws IOException {
        System.out.println(npc[i][0]);
        File nameList = new File(con.getFilesDir(), "npcNames.txt");
        FILE = npc[i][0] + ".txt";
        File file = new File(con.getFilesDir(), FILE);
        try (BufferedWriter out = new BufferedWriter(new FileWriter(file))) { //Writes to the file
            out.write(npc[i][0] + System.lineSeparator()); //Name
            out.write(npc[i][1] + System.lineSeparator());
            out.write(npc[i][2] + System.lineSeparator());
            out.write(npc[i][3] + System.lineSeparator());
            out.write(npc[i][4] + System.lineSeparator());
            out.write(npc[i][5] + System.lineSeparator());
            out.write(npc[i][6] + System.lineSeparator());
            out.write(npc[i][7] + System.lineSeparator());
            out.write(npc[i][8] + System.lineSeparator());
            out.write(npc[i][9] + System.lineSeparator());
            out.write(npc[i][10] + System.lineSeparator());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        if (!nameList.exists()) {
            nameList = new File(con.getFilesDir(), "npcNames.txt");
        }
        try (BufferedWriter out = new BufferedWriter(new FileWriter(nameList,true))) {
            out.write(npc[i][0] + System.lineSeparator());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* If you wanna find the files, go to "View", "Tool Window",
    "Device File Explorer, data, data,
    com.example.testingdm
     */
    public static void nload(Context con) throws IOException {
        File nameList = new File(con.getFilesDir(), "npcNames.txt");
        BufferedReader reader = new BufferedReader(new FileReader(nameList));
        int i =  aa;
        while (i != 99) {
            String a = reader.readLine();
            if(a != null) {
                BufferedReader B = new BufferedReader(new FileReader(con.getFilesDir() + "/" + a + ".txt"));
                System.out.println(i);
                npc[i][0] = B.readLine();
                npc[i][1] = B.readLine();
                npc[i][2] = B.readLine();
                npc[i][3] = B.readLine();
                npc[i][4] = B.readLine();
                npc[i][5] = B.readLine();
                npc[i][6] = B.readLine();
                npc[i][7] = B.readLine();
                npc[i][8] = B.readLine();
                npc[i][9] = B.readLine();
                npc[i][10] = B.readLine();
                B.close();
                aa++;
            } else {
                break;
            }
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void ndelete(Context con, String n ) throws IOException {
        File nameList = new File(con.getFilesDir(), "npcNames.txt");
        File tempList = new File(con.getFilesDir(), "temp.txt");
        BufferedReader E = new BufferedReader(new FileReader(nameList));
        BufferedWriter out = new BufferedWriter(new FileWriter(tempList));
        String a = "a";
        while (a != null) {
            a = E.readLine();
            if (a != n) {
                out.write(a);
                out.write(System.lineSeparator());
            }//End of If

        }//End of while
        nameList.delete();
        tempList.renameTo(nameList);

    }
}
