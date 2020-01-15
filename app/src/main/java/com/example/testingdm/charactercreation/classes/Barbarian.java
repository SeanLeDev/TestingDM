package com.example.testingdm.charactercreation.classes;

import com.google.gson.annotations.SerializedName;

import java.text.ChoiceFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;


public class Barbarian {
    @SerializedName("name")
    private String name = "Barbarian";
    @SerializedName("hit_die")
    private int hitdie = 12;
    @SerializedName("proficiency_choices")
    private String[] proficiencyChoices = new String[]{"Animal Handling","Athletics","Intimidation","Nature","Perception","Survival"};
    @SerializedName("proficiencies")
    private String[] proficiencies = new String[]{"Light Armour","Medium Armour","Shields","Simple Weapons","Martial Weapons"};
    @SerializedName("saving_throws")
    private String[] classSavingThrow = new String[]{"STR","CON"};
    @SerializedName("subclasses")
    private String[] subclasses = new String[]{"Path of the Berserker","Path of the Wild Soul"};

    public String[] getProficiencyChoices() {
        return proficiencyChoices;
    }

    public String[] getProficiencies() {
        return proficiencies;
    }

    public String[] getClassSavingThrow() {
        return classSavingThrow;
    }

    public String[] getSubclasses() {
        return subclasses;
    }

    public String getName() {
        return name;
    }

    public int getHitdie() {
        return hitdie;
    }



}
