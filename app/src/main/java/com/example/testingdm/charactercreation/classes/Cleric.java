package com.example.testingdm.charactercreation.classes;

import com.google.gson.annotations.SerializedName;

public class Cleric {
    private String name = "Cleric";
    @SerializedName("hit_die")
    private int hitdie = 8;
    @SerializedName("proficiency_choices")
    private String[] proficiencyChoices = new String[]{"History", "Insight", "Medicine", "Persuasion", "Religion"};
    @SerializedName("proficiencies")
    private String[] proficiencies = new String[]{"Light Armour", "Medium Armour", "Shields","Simple Weapons"};
    @SerializedName("saving_throws")
    private String[] classSavingThrow = new String[]{"WIS", "CHA"};
    @SerializedName("subclasses")
    private String[] subclasses = new String[]{"Life Domain", "Twilight Domain"};

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



