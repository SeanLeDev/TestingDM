package com.example.testingdm.ui.mainmenu.cardviewcreation;

import android.content.Context;

import com.example.testingdm.characterfiles.Character;


import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayToList {
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
}
