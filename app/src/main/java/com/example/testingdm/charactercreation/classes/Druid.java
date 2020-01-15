package com.example.testingdm.charactercreation.classes;

import com.google.gson.annotations.SerializedName;

public class Druid {
    private String name = "Druid";
    @SerializedName("hit_die")
    private int hitdie = 8;
    @SerializedName("proficiency_choices")
    private String[] proficiencyChoices = new String[]{"Arcana", "Animal Handling", "Insight", "Medicine", "Nature", "Perception", "Religion", "Survival"};
    @SerializedName("proficiencies")
    private String[] proficiencies = new String[]{"Light Armor", "Medium Armor", "Shields","Clubs", "Daggers", "Darts", "Javelins", "Maces", "Quarterstaves", "Scimitars", "Sickles", "Slings", "Spears","Herbalism kit"};
    @SerializedName("saving_throws")
    private String[] classSavingThrow = new String[]{"INT", "WIS"};
    @SerializedName("subclasses")
    private String[] subclasses = new String[]{"Circle of Land", "Circle of Wildfire"};

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
