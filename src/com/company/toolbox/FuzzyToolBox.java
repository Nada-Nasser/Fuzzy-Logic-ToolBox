package com.company.toolbox;

import com.company.toolbox.rules.FuzzyRule;
import com.company.toolbox.variables.FuzzyVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FuzzyToolBox
{
    public final static int SET_TYPE_TRI = 0;
    public final static int SET_TYPE_TRAP = 1;

    HashMap<String,FuzzyVariable> inputFuzzyVariables;
    HashMap<String,FuzzyVariable> outputFuzzyVariables;

    ArrayList<String> fuzzyRules;

    public FuzzyToolBox() {
        inputFuzzyVariables = new HashMap<>();
        fuzzyRules = new ArrayList<>();

        outputFuzzyVariables = new HashMap<>();
    }

    public void addInputVariable(String name)
    {
        FuzzyVariable fuzzyVariable = new FuzzyVariable(name);
        inputFuzzyVariables.put(name , fuzzyVariable);
    }

    public void addOutputVariable(String name)
    {
        FuzzyVariable fuzzyVariable = new FuzzyVariable(name);
        outputFuzzyVariables.put(name , fuzzyVariable);
    }


    public FuzzyVariable getInputVariable(String name)
    {
        return inputFuzzyVariables.get(name);
    }

    public FuzzyVariable getOutputVariable(String name)
    {
        return outputFuzzyVariables.get(name);
    }


    public void addRule(String rule)
    {
        fuzzyRules.add(rule);
    }

    public void run()
    {
        // 1- fuzzification
        fuzzification();

        // 2- rules
        applyRules();

        // 3- defuzzification
        defuzzification();
    }

    private void defuzzification()
    {
        for (Map.Entry<String,FuzzyVariable> entry : outputFuzzyVariables.entrySet())
        {
            System.out.println(entry.getValue().toString());

            entry.getValue().defuzzifyCrispValue();
        }
    }

    private void applyRules() {
        outputFuzzyVariables = FuzzyRule.getInference(fuzzyRules , inputFuzzyVariables , outputFuzzyVariables);
        // calculate fuzzified values in outputFuzzyVariable
    }

    private void fuzzification() {
        for (Map.Entry<String,FuzzyVariable> entry : inputFuzzyVariables.entrySet())
            entry.getValue().fuzzifyCrispValue();
    }

}
