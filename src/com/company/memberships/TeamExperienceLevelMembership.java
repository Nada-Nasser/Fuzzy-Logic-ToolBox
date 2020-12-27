package com.company.memberships;

public class TeamExperienceLevelMembership {

    // Lines Equations
    public double calculateBeginnerValue(int inputValue){
        if(inputValue>=0 && inputValue <= 15)
        {
            return (1.0/15.0)*(inputValue);
        }
        else if(inputValue>=15 && inputValue <= 30)
        {
            return (-1.0/15.0)*(inputValue) + 2;
        }
        else
            return 0;
    }

    public double calculateIntermediateValue(int inputValue){

        if(inputValue>=15 && inputValue <= 30)
        {
            return (1.0/15.0)*(inputValue) - 1;
        }
        else if(inputValue >= 30 && inputValue <= 45)
        {
            return (-1.0/15.0)*(inputValue) + 3;
        }
        else
            return 0;
    }

    public double calculateExpertValue(int inputValue){

        if(inputValue >= 30 && inputValue <= 60)
        {
            return (1.0/30.0)*(inputValue) - 1;
        }
        else
            return 0;
    }
}
