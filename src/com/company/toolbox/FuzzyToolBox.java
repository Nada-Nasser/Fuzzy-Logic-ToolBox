package com.company.toolbox;

import com.company.toolbox.sets.FuzzyRule;
import com.company.toolbox.variables.FuzzyVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FuzzyToolBox
{
    public final static int SET_TYPE_TRI = 0;
    public final static int SET_TYPE_TRAP = 1;

    int nVariables;
    HashMap<String,FuzzyVariable> inputFuzzyVariables;
    HashMap<String,FuzzyVariable> outputFuzzyVariable;

    ArrayList<FuzzyRule> fuzzyRules;

    public FuzzyToolBox(int nVariables) {
        this.nVariables = nVariables;
        inputFuzzyVariables = new HashMap<>();
        fuzzyRules = new ArrayList<>();

        outputFuzzyVariable = new HashMap<>();
    }

    public void addInputVariable(String name)
    {
        FuzzyVariable fuzzyVariable = new FuzzyVariable(name);
        inputFuzzyVariables.put(name , fuzzyVariable);
    }

    public void addOutputVariable(String name)
    {
        FuzzyVariable fuzzyVariable = new FuzzyVariable(name);
        outputFuzzyVariable.put(name , fuzzyVariable);
    }


    public FuzzyVariable getVariable(String name)
    {
        return inputFuzzyVariables.get(name);
    }

    public void addRule(String rule)
    {
        fuzzyRules.add(new FuzzyRule(rule));
    }

    public void run()
    {
        // 1- fuzzification
        fuzzification();

        // 2- rules
        applyRules();
        // 3- defuzzification
        /*
        defuzzification();*/
    }

    private void defuzzification()
    {
        for (Map.Entry<String,FuzzyVariable> entry : outputFuzzyVariable.entrySet())
        {
            entry.getValue().defuzzifyCrispValue();
        }
    }

    private void applyRules() {
        // TODO FARAH
        // calculate fuzzified values in outputFuzzyVariable
    }

    private void fuzzification() {
        for (Map.Entry<String,FuzzyVariable> entry : inputFuzzyVariables.entrySet())
            entry.getValue().fuzzifyCrispValue();
    }

}
