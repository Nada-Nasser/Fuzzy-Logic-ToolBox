package com.company.toolbox.sets;

import java.util.ArrayList;

public class TrapezoidalFuzzySet extends FuzzySet{
    public TrapezoidalFuzzySet(String name, ArrayList<Double> range) {
        super(name, range);
    }

    @Override
    public double getCentroid() {
        // TODO FARAH
        return 0;
    }


    @Override
    public double getMembershipValue(double crispValue) {
        // TODO : fuzzification NADA
        return 0;
    }
}
