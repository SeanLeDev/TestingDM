package com.example.testingdm.ui.mainmenu.cardviewcreation;

import android.content.Context;


import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayToList {
    private static String FILENAME;

    public static List<String> convertFileToList(Context con) throws IOException {
        Scanner s = new Scanner(new File(con.getFilesDir(), "Names.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNextLine()) {
            list.add(s.nextLine());
        }
        s.close();
        // Return the converted List
        return list;
    }
    public static List<String> convertNPCFileToList(Context con) throws IOException {
        Scanner s = new Scanner(new File(con.getFilesDir(), "npcNames.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNextLine()) {
            list.add(s.nextLine());
        }
        s.close();
        // Return the converted List
        return list;
    }

    public static List<String> convertFileToListInventory(Context con, String n) throws IOException {
        FILENAME = n+"-e.txt";
        Scanner s = new Scanner(new File(con.getFilesDir(), FILENAME));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNextLine()) {
            list.add(s.nextLine());
        }
        s.close();
        // Return the converted List
        return list;
    }
}
