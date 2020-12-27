package com.company.memberships;

import java.util.ArrayList;

public class ProjectFundingMembership {

    // Lines Equations
    public float calculateVeryLowValue(int inputValue){
        if(inputValue>=0 && inputValue <=10)
        {
            return 1;
        }
        else if(inputValue>=10 && inputValue <=30){
            return -0.05f*(inputValue)+1.5f;
        }
        else
            return 0;
    }

    public float calculateLowValue(int inputValue){
        if (inputValue >= 10 && inputValue < 30)
        {
            return 0.05f * (inputValue) - 0.5f;
        }
        else if(inputValue >= 30 && inputValue < 40)
        {
            return 1;
        }
        else if (inputValue >= 40 && inputValue <= 60)
        {
            return -0.05f * (inputValue) + 3f;
        }
        else
            return 0;
    }

    public float calculateMediumValue(int inputValue){
        if (inputValue >= 40 && inputValue < 60)
        {
            return 0.05f * (inputValue) - 2f;
        }
        else if(inputValue >= 60 && inputValue < 70)
        {
            return 1;
        }
        else if (inputValue >= 70 && inputValue <= 90)
        {
            return -0.05f * (inputValue) + 4.5f;
        }
        else
            return 0;
    }

    public float calculateHighValue(int inputValue){
        if(inputValue >= 90 && inputValue <= 100) {
            return 1;
        }
        else if((inputValue >= 70 && inputValue <= 90)){
            return 0.05f*(inputValue) + 3.5f;
        }
        else
            return 0;
    }
}
