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
    public void setStr(int str) {
        Str = str;
    }
    public void setInt(int Intel) {
        Int = Intel;
    }
    public void setWis(int wis) {
        Wis = wis;
    }
    public void setDex(int dex) {
        Dex = dex;
    }
    public void setCha(int cha) {
        Cha = cha;
    }
    public void setCon(int con) {
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

        strBonus=Str-10;
        if(strBonus%2==0){
            return;}
        else{
            strBonus--;}
    }
}