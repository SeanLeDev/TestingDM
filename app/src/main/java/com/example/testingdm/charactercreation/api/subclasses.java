package com.example.testingdm.charactercreation.api;

import java.util.List;

public class subclasses {

    private String id;
    private String index;
    private String name;
    private classType classChoice;
    private String subclassFlavour;
    private String desc;
    private List<feature> features;
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

    public classType getClassChoice() {
        return classChoice;
    }

    public String getSubclassFlavour() {
        return subclassFlavour;
    }

    public String getDesc() {
        return desc;
    }

    public List<feature> getFeatures() {
        return features;
    }

    public String getUrl() {
        return url;
    }

    public class classType {
        String index;
        String name;
        String url;
    }

    public class feature {
        String index;
        String name;
        String url;

    }
}
