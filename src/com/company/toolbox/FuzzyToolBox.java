package com.company.toolbox;

import com.company.toolbox.sets.FuzzyRule;
import com.company.toolbox.variables.FuzzyVariable;

import java.util.ArrayList;
import java.util.HashMap;

public class FuzzyToolBox
{
    int nVariables;
    HashMap<String,FuzzyVariable> fuzzyVariables;
    ArrayList<FuzzyRule> fuzzyRules;

    public FuzzyToolBox(int nVariables) {
        this.nVariables = nVariables;
        fuzzyVariables = new HashMap<>();
        fuzzyRules = new ArrayList<>();
    }

    public FuzzyVariable addVariable(String name)
    {
        return null;
    }

    public FuzzyVariable getVariable(String name)
    {
        return null;
    }

}
