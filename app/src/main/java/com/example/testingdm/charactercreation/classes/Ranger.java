package com.example.testingdm.charactercreation.classes;

import com.google.gson.annotations.SerializedName;

public class Ranger {
    private String name = "Ranger";
    @SerializedName("hit_die")
    private int hitdie = 10;
    @SerializedName("proficiency_choices")
    private String[] proficiencyChoices = new String[]{"Animal Handling","Athletics","Insight","Investigation","Nature","Perception","Stealth","Survival"};
    @SerializedName("proficiencies")
    private String[] proficiencies = new String[]{"Light Armour","Medium Armour","Shields","Simple Weapons","Martial Weapons"};
    @SerializedName("saving_throws")
    private String[] classSavingThrow = new String[]{"STR","DEX"};
    @SerializedName("subclasses")
    private String[] subclasses = new String[]{"Hunter","Swarmkeeper"};

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

