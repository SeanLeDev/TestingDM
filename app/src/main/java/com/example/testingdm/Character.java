package com.example.testingdm;


import android.widget.Toast;

public abstract class Character extends ValueCalculation{



    private String Name;
    private int Str;
    private int Int;
    private int Wis;
    private int Dex;
    private int Cha;
    private int Con;

    //Getter Methods
    public int getStr() {
        return Str;
    }
    public int getInt() {
        return Int;
    }
    public int getWis() {
        return Wis;
    }
    public int getDex() {
        return Dex;
    }
    public int getCha() {
        return Cha;
    }
    public int getCon() {
        return Con;
    }

    public String getName() {
        return Name;
    }

    //Setter Methods
    private void setStr(int str) {
        Str = str;
    }

    private void setInt(int Intel) {
        Int = Intel;
    }

    private void setWis(int wis) {
        Wis = wis;
    }

    private void setDex(int dex) {
        Dex = dex;
    }

    private void setCha(int cha) {
        Cha = cha;
    }

    private void setCon(int con) {
        Con = con;
    }

    private void setName(String name) {
        Name = name;
    }

    public Character(){
        setStr(10);
        setInt(10);
        setWis(10);
        setDex(10);
        setCha(10);
        setCon(10);
    }

    public Character(String name, int s, int i, int w, int d, int c, int con) {
        setName(name);
        setStr(s);
        setInt(i);
        setWis(w);
        setDex(d);
        setCha(c);
        setCon(con);
        setStrBonus(s);
        setIntBonus(i);
        setWisBonus(w);
        setDexBonus(d);
        setChaBonus(c);
        setConBonus(con);
        //Instantiating all of the skills
        Skills atheletics = new Skills("Athletics", dexBonus, false);
        Skills arcana = new Skills("Arcana",intBonus, false);
        Skills acrobatics = new Skills("Acrobatics", dexBonus, false);
        Skills animalHandling = new Skills("Animal Handling", wisBonus, false);
        Skills athletics = new Skills("Athletics", strBonus, false);
        Skills sleightOfHand = new Skills("Sleight of Hand", dexBonus, false);
        Skills stealth = new Skills("Stealth", dexBonus, false);
        Skills history = new Skills("History", intBonus, false);
        Skills investigation = new Skills ("Investigation", intBonus, false);
        Skills nature = new Skills("Nature", intBonus,false);
        Skills religion = new Skills ("Religion", intBonus, false);
        Skills insight = new Skills ("Insight", wisBonus, false);
        Skills medicine = new Skills ("Medicine", wisBonus, false);
        Skills perception = new Skills ("Perception", wisBonus, false);
        Skills survival = new Skills ("Survival", wisBonus, false);
        Skills deception = new Skills ("Deception", chaBonus, false);
        Skills intimidation = new Skills ("Intimidation", chaBonus, false);
        Skills performance = new Skills ("Performance", chaBonus , false);
        Skills persuasion = new Skills ("Persuasion", chaBonus, false);


    }
//TODO: Fix this cluster fuck
 //   private void toastMessage(String message)
  //  {
  //      Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  //  }

}