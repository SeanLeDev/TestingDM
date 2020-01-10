package com.example.testingdm.charactercreation.api;

import java.text.ChoiceFormat;
import java.util.List;


public class classes {
    private String id;
    private String Index;
    private String name;
    private int hitdie;
    private List<choices> choice;
    private classProficiencies proficiencies;
    private savingThrows classSavingThrow;
    private startingEquipment startingGear;
    private List<levels> classLevels;
    private List<subclass> subclasses;
    private spells spellcasting;
    private String url;

    public String getId() {
        return id;
    }

    public String getIndex() {
        return Index;
    }

    public String getName() {
        return name;
    }

    public int getHitdie() {
        return hitdie;
    }

    public List<choices> getChoice() {
        return choice;
    }

    public classProficiencies getProficiencies() {
        return proficiencies;
    }

    public savingThrows getClassSavingThrow() {
        return classSavingThrow;
    }

    public startingEquipment getStartingGear() {
        return startingGear;
    }

    public List<levels> getClassLevels() {
        return classLevels;
    }

    public List<subclass> getSubclasses() {
        return subclasses;
    }

    public spells getSpellcasting() {
        return spellcasting;
    }

    public String getUrl() {
        return url;
    }


    public class classProficiencies {
        String index;
        String name;
        String url;
    }

    public class savingThrows {
        String index;
        String name;
        String url;
    }

    public class startingEquipment {
        String index;
        String classType;
        String url;
    }

    public class subclass {
        String index;
        String name;
        String url;
    }

    public class spells {
        String index;
        String classType;
        String url;
    }
}
