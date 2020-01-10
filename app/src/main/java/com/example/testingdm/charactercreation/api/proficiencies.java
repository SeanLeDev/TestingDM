package com.example.testingdm.charactercreation.api;

import java.util.List;

public class proficiencies {

    private String id;
    private String index;
    private String type;
    private String name;
    private List<classType> proficiencyClass;
    private List<race> race;
    private String url;

    public String getId() {
        return id;
    }

    public String getIndex() {
        return index;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public List<classType> getProficiencyClass() {
        return proficiencyClass;
    }

    public List<proficiencies.race> getRace() {
        return race;
    }

    public String getUrl() {
        return url;
    }

    public class classType {
        String index;
        String name;
        String url;
    }

    public class race {
        String index;
        String name;
        String url;
    }

}
