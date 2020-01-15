package com.example.testingdm.charactercreation.classes;

import com.google.gson.annotations.SerializedName;

public class Fighter {@SerializedName("name")
private String name = "Fighter";
    @SerializedName("hit_die")
    private int hitdie = 10;
    @SerializedName("proficiency_choices")
    private String[] proficiencyChoices = new String[]{"Acrobatics","Animal Handling","Athletics","History","Insight","Intimidation","Perception","Survival"};
    @SerializedName("proficiencies")
    private String[] proficiencies = new String[]{"All Armour","Shields","Simple Weapons","Martial Weapons"};
    @SerializedName("saving_throws")
    private String[] classSavingThrow = new String[]{"STR","CON"};
    @SerializedName("subclasses")
    private String[] subclasses = new String[]{"Champion","Gunslinger","Psychic Warrior","Rune Knight","Eldritch Knight"};

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

