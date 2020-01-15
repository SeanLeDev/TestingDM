package com.example.testingdm.charactercreation.classes;

import com.google.gson.annotations.SerializedName;

public class Rogue {
    @SerializedName("name")
    private String name = "Rogue";
    @SerializedName("hit_die")
    private int hitdie = 8;
    @SerializedName("proficiency_choices")
    private String[] proficiencyChoices = new String[]{"Acrobatics", "Athletics", "Deception", "Insight", "Intimidation", "Investigation", "Perception", "Performance", "Persuasion", "Sleight of Hand","Stealth"};
    @SerializedName("proficiencies")
    private String[] proficiencies = new String[]{"Light Armour","Simple Weapons","Hand Crossbows","Longswords","Rapiers","Shortswords","Thieves' Tools"};
    @SerializedName("saving_throws")
    private String[] classSavingThrow = new String[]{"INT","DEX"};
    @SerializedName("subclasses")
    private String[] subclasses = new String[]{"Thief","Soulknife","The Revived"};

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

