package com.example.testingdm.charactercreation.api;

import java.util.List;

public class skills {

    private String _id;
    private String index;
    private String name;
    private List<String> desc;
    private ability_scores ability_score;
    private String url;

    public String getId() {
        return _id;
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public List<String> getDesc() {
        return desc;
    }

    public ability_scores getAbility_score() {
        return ability_score;
    }

    public String getUrl() {
        return url;
    }

    public class ability_scores {
        String name;
        String url;
    }
}
