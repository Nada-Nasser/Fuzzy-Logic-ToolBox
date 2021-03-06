package com.company.toolbox.variables;

import com.company.toolbox.FuzzyToolBox;
import com.company.toolbox.sets.FuzzySet;
import com.company.toolbox.sets.TrapezoidalFuzzySet;
import com.company.toolbox.sets.TriangularFuzzySet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FuzzyVariable {

    private String name;
    private ArrayList<FuzzySet> fuzzySets;
    private double crispValue;

    private HashMap<String,Double> fuzzifiedValues = new HashMap<>(); // result from rules (output variables)

    public FuzzyVariable(String name) {
        this.name = name;
        fuzzySets = new ArrayList<>();
    }

    public void addFuzzySet(String name , int type , ArrayList<Double> range)
    {
        if(type == FuzzyToolBox.SET_TYPE_TRAP)
        {
            fuzzySets.add(new TrapezoidalFuzzySet(name , range));
        }
        else if(type == FuzzyToolBox.SET_TYPE_TRI)
        {
            fuzzySets.add(new TriangularFuzzySet(name , range));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<FuzzySet> getFuzzySets() {
        return fuzzySets;
    }

    public void setFuzzySets(ArrayList<FuzzySet> fuzzySets) {
        this.fuzzySets = fuzzySets;
    }

    public double getCrispValue() {
        return crispValue;
    }

    public void setCrispValue(double crispValue) {
        this.crispValue = crispValue;
    }

    public void setMembershipDegree(String set,Double fuzz){
        this.fuzzifiedValues.put(set,fuzz);
    }

    public double getMembershipDegree(String setName){
        if(fuzzifiedValues.get(setName)!= null) return fuzzifiedValues.get(setName); else return -1;
    }

    public void fuzzifyCrispValue()
    {
        fuzzifiedValues = new HashMap<>();

        for (FuzzySet fuzzySet : fuzzySets) {
            double fuzzifiedValue = fuzzySet.getMembershipValue(crispValue);
            //   System.out.println(fuzzySets.get(i).getName() + " " + fuzzifiedValue);
            fuzzifiedValues.put(fuzzySet.getName(),fuzzifiedValue);
        }

    }


    public double defuzzifyCrispValue()
    {
        //ArrayList <Double> centroids = new ArrayList<>();
        HashMap<String,Double> centroids = new HashMap<>();
        for (FuzzySet fuzzySet : fuzzySets) {
            //centroids.add(fuzzySet.getCentroid());
            centroids.put(fuzzySet.getName() , fuzzySet.getCentroid());
        }

        double sumFuzzifiedValues = 0.0 , numer = 0.0 ;

        for (Map.Entry<String,Double> entry : fuzzifiedValues.entrySet())
        {
            double fuzzifiedValue = entry.getValue();
            sumFuzzifiedValues+= fuzzifiedValue ;
            numer += fuzzifiedValue * centroids.get(entry.getKey());
        }

        crispValue = numer / sumFuzzifiedValues;

        return crispValue;
    }

    @Override
    public String toString() {
        return "FuzzyVariable\n{" + "\n"+
                "  name = '" + name + '\'' + ", \n"+
                "  fuzzySets = " + fuzzySets +", \n"+
                "  crispValue = " + crispValue +", \n"+
                "  fuzzifiedValues = " + fuzzifiedValues + "\n"+
                '}';
    }
}
