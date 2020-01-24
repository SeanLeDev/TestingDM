package com.example.testingdm.charactercreation;


import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import static com.example.testingdm.charactercreation.characterScreen.stats;

public class
IO {
    private static String[][] nam = new String [100][1];
    private static String FILENAME;
    private static int aa = 0;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void save(Context con, int i) throws IOException {
        File nameList = new File(con.getFilesDir(), "Names.txt");
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
            out.write(stats[i][7] + System.lineSeparator());
            out.write(stats[i][8] + System.lineSeparator());
            out.write(stats[i][9] + System.lineSeparator());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!file.exists()) {
            file.createNewFile();
        }
        if (!nameList.exists()) {
            nameList = new File(con.getFilesDir(), "Names.txt");
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
    public static void load(Context con) throws IOException {
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
                stats[i][7] = E.readLine();
                stats[i][8] = E.readLine();
                stats[i][9] = E.readLine();
                E.close();
                aa++;
            } else {
                break;
            }
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void delete(Context con, String n ) throws IOException {
        File nameList = new File(con.getFilesDir(), "Names.txt");
      //  File tempList = new File(con.getFilesDir(), "temp.txt");
        BufferedReader E = new BufferedReader(new FileReader(nameList));
      //  BufferedWriter out = new BufferedWriter(new FileWriter(tempList));
        String a = "a";
        int i = 0;
        while (a != "b"){
            a = E.readLine();
            System.out.println(a);
            if(a == null){
               a = "b";
            }
            if(a != n) {
            nam[i][0] = a;
            i++;
            //  out.write(a);
            //  out.write(System.lineSeparator());
            }//End of If

        }//End of while
        nameList.delete();
        File na = new File(con.getFilesDir(), "Names.txt");
        BufferedWriter out = new BufferedWriter(new FileWriter(na));
        while(i>=0)
        {
            if(nam[i][0] == null){
                nam[i][0] = " ";
            }
            System.out.println(nam[i][0]);
            out.write(nam[i][0]+ System.lineSeparator()) ;
            i--;
        }
        out.close();



        File name = new File((con.getFilesDir()), n + ".txt");
        name.delete();
        File namec = new File((con.getFilesDir()), n + "-c" + ".txt");
        namec.delete();
        File namee = new File((con.getFilesDir()), n + "-e" + ".txt");
        namee.delete();
        File namef = new File((con.getFilesDir()), n + "-f" + ".txt");
        namef.delete();
        File namel = new File((con.getFilesDir()), n + "-l" + ".txt");
        namel.delete();
        File namep = new File((con.getFilesDir()), n + "-p" + ".txt");
        namep.delete();
        File namer = new File((con.getFilesDir()), n + "-r" + ".txt");
        namer.delete();
        File names = new File((con.getFilesDir()), n + "-s" + ".txt");
        names.delete();
        File namesub = new File((con.getFilesDir()), n + "-sub" + ".txt");
        namesub.delete();
    }
}
