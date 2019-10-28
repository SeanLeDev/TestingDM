package com.example.testingdm;

public class ValueCalculation{
    //Stat Bonuses
    public int strBonus;
    public int dexBonus;
    public int conBonus;
    public int intBonus;
    public int wisBonus;
    public int chaBonus;
    //Skills
    public int acrobatics;
    public int animalHandling;
    public int arcana;
    public int athletics;
    public int deception;
    public int history;
    public int insight;
    public int intimidation;
    public int investigation;
    public int medicine;
    public int nature;
    public int perception;
    public int performance;
    public int persuasion;
    public int religion;
    public int slightHand;
    public int stealth;
    public int survival;
    public boolean proficiency;

    public int getBonus(int stat) {
        int bonus;
        bonus = stat - 10;
        if (bonus % 2 == 0) {
            bonus = bonus / 2;
            return bonus;
        } else {
            bonus--;
            bonus = bonus / 2;
            return bonus;
        }
    }

    public void setStrBonus(int str) {
        strBonus = getBonus(str);
    }

    public void setIntBonus(int Int) {
        intBonus = getBonus(Int);
    }

    public void setWisBonus(int wis) {
        wisBonus = getBonus(wis);
    }

    public void setDexBonus(int dex) {
        dexBonus = getBonus(dex);
    }

    public void setChaBonus(int cha) {
        chaBonus = getBonus(cha);
    }

    public void setConBonus(int con) {
        conBonus = getBonus(con);
    }
}
