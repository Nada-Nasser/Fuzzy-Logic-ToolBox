package com.company.toolbox.sets;

import java.util.ArrayList;

public class TriangularFuzzySet extends FuzzySet
{
    private double slop1 , slop2, term1, term2;
    private double a,b,c;

    public TriangularFuzzySet(String name, ArrayList<Double> range) {
        super(name, range);

        if (range.size() != 3)
            throw new IllegalArgumentException();

        a = range.get(0);
        b = range.get(1);
        c = range.get(2);

        if((b-a) == 0)
        {
            slop1 = 0;
            term1 = 1;
        }else{
            slop1 = 1.0 / (b-a);
            term1 = -1*(slop1)*(a);
        }

        if((b-c) == 0)
        {
            slop2 = 0;
            term2 = 1;
        }else{
            slop2 = 1.0 / (b-c);
            term2 = -1*(slop2)*(c);
        }
    }

    @Override
    public double getCentroid() {
        // TODO FARAH
        return 0;
    }

    @Override
    public double getMembershipValue(double crispValue) {
        if(crispValue >= a && crispValue <= b)
        {
            return (slop1*crispValue) + term1;
        }
        else if(crispValue >= b && crispValue <= c)
        {
            return (slop2*crispValue) + term2;
        }
        else
            return 0;
    }
}
