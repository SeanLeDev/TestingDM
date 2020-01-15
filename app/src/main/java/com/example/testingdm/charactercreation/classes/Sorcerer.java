package com.example.testingdm.charactercreation.classes;

import com.google.gson.annotations.SerializedName;

public class Sorcerer {
    @SerializedName("name")
    private String name = "Sorcerer";
    @SerializedName("hit_die")
    private int hitdie = 6;
    @SerializedName("proficiency_choices")
    private String[] proficiencyChoices = new String[]{"Arcana", "Deception", "Insight", "Intimidation", "Persuasion", "Religion"};
    @SerializedName("proficiencies")
    private String[] proficiencies = new String[]{"Darts","Daggers","Slings","Quarterstaves","Light Crossbows"};
    @SerializedName("saving_throws")
    private String[] classSavingThrow = new String[]{"CON","CHA"};
    @SerializedName("subclasses")
    private String[] subclasses = new String[]{"Draconic Bloodline","Aberrant Mind"};

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
