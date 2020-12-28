package com.company.toolbox.sets;

import java.util.ArrayList;

abstract public class FuzzySet {
    protected String name;
    protected double centroid;
    protected ArrayList<Double> range;

    public FuzzySet(String name, ArrayList<Double> range) {
        this.name = name;
        this.range = range;
    }


    @Override
    public String toString() {
        return "FuzzySet{" +
                "name='" + name + '\'' +
                ", centroid=" + centroid +
                ", range=" + range +
                '}';
    }

    public String getName() {
        return name;
    }

    public abstract double getCentroid();
    public abstract double getMembershipValue(double crispValue);
}
