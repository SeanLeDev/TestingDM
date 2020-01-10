package com.example.testingdm.charactercreation.api;

import java.util.List;

public class levels {
    private String id;
    private String index;
    private int level;
    private int abilityScoreBonus;
    private int profBonus;
    private List<featureChoices> featureChoices;
    private List<features> features;
    private Object spellcasting;
    private Object classSpecific;
    private classChoice characterClass;
    private String url;

    public String getId() {
        return id;
    }

    public String getIndex() {
        return index;
    }

    public int getLevel() {
        return level;
    }

    public int getAbilityScoreBonus() {
        return abilityScoreBonus;
    }

    public int getProfBonus() {
        return profBonus;
    }

    public List<levels.featureChoices> getFeatureChoices() {
        return featureChoices;
    }

    public List<levels.features> getFeatures() {
        return features;
    }

    public Object getSpellcasting() {
        return spellcasting;
    }

    public Object getClassSpecific() {
        return classSpecific;
    }

    public classChoice getCharacterClass() {
        return characterClass;
    }

    public String getUrl() {
        return url;
    }

    public class classChoice {
        String index;
        String name;
        String url;
    }

    public class featureChoices {
        String index;
        String name;
        String url;
    }

    public class features {
        String index;
        String name;
        String url;
    }
}
