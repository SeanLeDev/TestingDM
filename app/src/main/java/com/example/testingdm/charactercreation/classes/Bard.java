package com.example.testingdm.charactercreation.classes;

import com.google.gson.annotations.SerializedName;

public class Bard {@SerializedName("name")
    private String name = "Bard";
    @SerializedName("hit_die")
    private int hitdie = 8;
    @SerializedName("proficiency_choices")
    private String[] proficiencyChoices = new String[]{"Animal Handling","Athletics","Intimidation","Nature","Perception","Survival"};
    @SerializedName("proficiencies")
    private String[] proficiencies = new String[]{"Hand Crossbows","Light Armour","Shields","Simple Weapons","Longswords","Rapiers","Shortswords"};
    @SerializedName("saving_throws")
    private String[] classSavingThrow = new String[]{"DEX","CHA"};
    @SerializedName("subclasses")
    private String[] subclasses = new String[]{"College of Eloquence","College of Lore"};

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

