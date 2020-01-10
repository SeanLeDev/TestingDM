package com.example.testingdm.charactercreation.api;

import java.util.List;

public class races {

    private String id;
    private String index;
    private String name;
    private int speed;
    private int[] bonuses = new int[6];
    private String alignment;
    private String age;
    private String size;
    private String sizeDesc;
    private List<raceProficiencies> proficiencies;
    private List<languages> savingThrows;
    private String languageDesc;
    private List<trait> traits;
    private subrace subraces;
    private String url;

    public String getId() {
        return id;
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public int[] getBonuses() {
        return bonuses;
    }

    public String getAlignment() {
        return alignment;
    }

    public String getAge() {
        return age;
    }

    public String getSize() {
        return size;
    }

    public String getSizeDesc() {
        return sizeDesc;
    }

    public List<raceProficiencies> getProficiencies() {
        return proficiencies;
    }

    public List<languages> getSavingThrows() {
        return savingThrows;
    }

    public String getLanguageDesc() {
        return languageDesc;
    }

    public List<trait> getTraits() {
        return traits;
    }

    public subrace getSubraces() {
        return subraces;
    }

    public String getUrl() {
        return url;
    }

    public class raceProficiencies {
        String index;
        String name;
        String url;
    }

    public class languages {
        String index;
        String name;
        String url;
    }

    public class trait {
        String index;
        String classType;
        String url;
    }

    public class subrace {
        String index;
        String name;
        String url;
    }

}
