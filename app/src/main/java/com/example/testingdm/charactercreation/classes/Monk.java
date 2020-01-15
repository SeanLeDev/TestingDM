package com.example.testingdm.charactercreation.classes;

import com.google.gson.annotations.SerializedName;

public class Monk {
    private String name = "Monk";
    @SerializedName("hit_die")
    private int hitdie = 8;
    @SerializedName("proficiency_choices")
    private String[] proficiencyChoices = new String[]{"Acrobatics", "Athletics", "History", "Insight", "Religion", "Stealth","Artisan's Tools"};
    @SerializedName("proficiencies")
    private String[] proficiencies = new String[]{"Simple Weapons","Shortswords"};
    @SerializedName("saving_throws")
    private String[] classSavingThrow = new String[]{"STR", "DEX"};
    @SerializedName("subclasses")
    private String[] subclasses = new String[]{"Way of the Open Hand", "Way of the Astral Self"};

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
