package com.example.testingdm.charactercreation.classes;

import com.google.gson.annotations.SerializedName;

public class Warlock {
    @SerializedName("name")
    private String name = "Warlock";
    @SerializedName("hit_die")
    private int hitdie = 8;
    @SerializedName("proficiency_choices")
    private String[] proficiencyChoices = new String[]{"Arcana","Deception","History","Intimidation","Investigation","Nature","Religion"};
    @SerializedName("proficiencies")
    private String[] proficiencies = new String[]{"Light Armour","Simple Weapons"};
    @SerializedName("saving_throws")
    private String[] classSavingThrow = new String[]{"CHA","WIS"};
    @SerializedName("subclasses")
    private String[] subclasses = new String[]{"The Fiend","The Lurker in the Deep"};

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

