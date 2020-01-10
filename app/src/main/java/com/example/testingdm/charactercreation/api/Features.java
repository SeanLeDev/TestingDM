package com.example.testingdm.charactercreation.api;

import java.util.List;

public class Features {
    private String id;
    private String index;
    private String name;
    private int level;
    private List<String> desc;
    private String url;
    public classType featureClass;
    public subclassType featureSubclass;


    public String getId(){return id;}

    public String getIndex(){return index;}

    public String getName(){return name;}

    public int getLevel(){return level;}

    public List<String> getDesc() {
        return desc;
    }

    public String getUrl(){return url;}

    public classType getFeatureClass() {
        return featureClass;
    }

    public subclassType getFeatureSubclass() {
        return featureSubclass;
    }

    public class classType {
        String index;
        String name;
        String url;
    }

    public class subclassType {
        String index;
        String name;
        String url;
    }


}
