package com.example.testingdm.charactercreation.api;

public class NamedAPIResource {
    String index;
    String name;
    String url;

    public NamedAPIResource(String index, String name, String url) {
        this.index = index;
        this.name = name;
        this.url = url;
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
