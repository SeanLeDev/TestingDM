package com.example.testingdm;



public class Character extends ValueCalculation{

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

    public Character(){
        setStr(10);
        setInt(10);
        setWis(10);
        setDex(10);
        setCha(10);
        setCon(10);
    }
    public Character(int s, int i, int w, int d, int c, int con) {
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

    }
}