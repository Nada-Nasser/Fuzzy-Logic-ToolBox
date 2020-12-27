package com.company.toolbox.sets;

import java.util.ArrayList;

abstract public class FuzzySet {
    private String name;
    private ArrayList<Double> range;

    public FuzzySet(String name, ArrayList<Double> range) {
        this.name = name;
        this.range = range;
    }
}
