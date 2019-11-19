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

    public boolean proficiency;

    public static int getBonus(int stat) {
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

    void setStrBonus(int str) {
        strBonus = getBonus(str);
    }

    void setIntBonus(int Int) {
        intBonus = getBonus(Int);
    }

    void setWisBonus(int wis) {
        wisBonus = getBonus(wis);
    }

    void setDexBonus(int dex) {
        dexBonus = getBonus(dex);
    }

    void setChaBonus(int cha) {
        chaBonus = getBonus(cha);
    }

    void setConBonus(int con) {
        conBonus = getBonus(con);
    }
}
