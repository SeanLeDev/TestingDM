package com.example.testingdm.charactercreation.classes;

import com.google.gson.annotations.SerializedName;

public class Paladin {
    private String name = "Paladin";
    @SerializedName("hit_die")
    private int hitdie = 10;
    @SerializedName("proficiency_choices")
    private String[] proficiencyChoices = new String[]{"Athletics", "Insight", "Intimidation", "Medicine", "Persuasion", "Religion"};
    @SerializedName("proficiencies")
    private String[] proficiencies = new String[]{"All Armour","Shields","Simple Weapons","Martial Weapons"};
    @SerializedName("saving_throws")
    private String[] classSavingThrow = new String[]{"WIS","CHA"};
    @SerializedName("subclasses")
    private String[] subclasses = new String[]{"Oath of Devotion","Oath of Heroism"};

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
