package com.example.testingdm;

public class Skills extends ValueCalculation
{
    int l;
    String name;
    boolean p;

    //Constructor Method
    public Skills (String skillName,int level, boolean proficient)
    {
        name = skillName;
        l = level;
        p = proficient;
       l=p();
    }

    //if proficient it adds 2 to the level
    private int p()
    {
        if(p==true)
        {
            return l+2;
        }
        return l;
    }

}
