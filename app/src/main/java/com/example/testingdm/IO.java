package com.example.testingdm;


import static com.example.testingdm.ui.main.ui.main.characterScreen.stats;

public class IO {
    private static String FILENAME;



    public static void save(){

        int i=0;
        while(stats[i][0] != null) {
            i++;
        }
        FILENAME = stats[i][0] + ".txt";


    }

    public static void load(){

    }
}
