package com.example.testingdm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static com.example.testingdm.ui.main.ui.main.characterScreen.stats;

public class ArrayToList {
    public static <T> List<Character> convertArrayToList(String[][] array) {

        // Create an empty List
        List<Character> list = new ArrayList<>();

        // Iterate through the array
        for (int i = 0; i == array.length; i++) {
            Character c = new Character(array[i][1]);
            list.add(c);
            if (array[1][1] == null) {
                break;
            }
        }
        // Return the converted List
        return list;
    }
}
