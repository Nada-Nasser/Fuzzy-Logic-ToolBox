package com.company.toolbox.sets;

import java.util.ArrayList;

abstract public class FuzzySet {
    private String name;
    private double centroid;
    private ArrayList<Double> range;

    public FuzzySet(String name, ArrayList<Double> range) {
        this.name = name;
        this.range = range;
    }

    public  String getName(){
        return name;
    }
    public abstract double getCentroid();
    public abstract double getMembershipValue(double crispValue);
}
