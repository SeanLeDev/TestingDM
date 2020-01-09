package com.example.testingdm.charactercreation.api;

import java.util.*;


public class equipment {

    private String _id;
    private String index;
    private String name;
    private String equipment_category;
    private String weapon_category;
    private String weapon_range;
    private String category_range;

    private Map<String, String> damage;
    private Map<String, String> dmgBonus;
    private Map<String, Map<String, String>> dmgType;

    private Cost cost;
    private String dmgDice;
    //private int dmgBonus;

    private Weapon_Properties properties;
    private int range;
    private int weight;

    public String get_Id() {
        return _id;
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public String getEquipmentCat() {
        return equipment_category;
    }

    public String getWeaponCat() {
        return weapon_category;
    }

    public String getWeaponRng() {
        return weapon_range;
    }

    public Weapon_Properties getWeaponProp() {
        return properties;
    }

    public String getCategoryRng() {
        return category_range;
    }

    public Map<String, String> getDamage() {
        return damage;
    }

    public Cost getCost() {
        return cost;
    }

    public String getDmgDice() {
        return dmgDice;
    }

    public int getRange() {
        return range;
    }

    public int getWeight() {
        return weight;
    }


    public class Cost {
        int quantity;
        String unit;
    }

    public class Weapon_Properties {
        String index;
        String name;
        String url;
    }

    public String get_id() {
        return _id;
    }

    public String getEquipment_category() {
        return equipment_category;
    }

    public String getWeapon_category() {
        return weapon_category;
    }

    public String getWeapon_range() {
        return weapon_range;
    }

    public String getCategory_range() {
        return category_range;
    }

    public Map<String, String> getDmgBonus() {
        return dmgBonus;
    }

    public Map<String, Map<String, String>> getDmgType() {
        return dmgType;
    }

    public Weapon_Properties getProperties() {
        return properties;
    }

    public class damageDiceBonus {
        String damage_dice;
        String damage_bonus;
    }
}
