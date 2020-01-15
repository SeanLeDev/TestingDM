package com.example.testingdm.charactercreation.classes;

import com.google.gson.annotations.SerializedName;

public class Wizard {@SerializedName("name")
private String name = "Wizard";
    @SerializedName("hit_die")
    private int hitdie = 6;
    @SerializedName("proficiency_choices")
    private String[] proficiencyChoices = new String[]{"Arcana","History","Insight","Investigation","Medicine","Religion"};
    @SerializedName("proficiencies")
    private String[] proficiencies = new String[]{"Darts","Daggers","Slings","Quarterstaves","Light Crossbows"};
    @SerializedName("saving_throws")
    private String[] classSavingThrow = new String[]{"INT","WIS"};
    @SerializedName("subclasses")
    private String[] subclasses = new String[]{"Onomancy","Psionics","Evocation"};

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
