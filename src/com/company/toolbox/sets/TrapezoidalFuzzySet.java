package com.company.toolbox.sets;

import java.util.ArrayList;

public class TrapezoidalFuzzySet extends FuzzySet{

    private double slop1 , slop2, term1, term2;
    private double a,b,c,d;

    public TrapezoidalFuzzySet(String name, ArrayList<Double> range) {
        super(name, range);
        if (range.size() != 4)
            throw new IllegalArgumentException();

        a = range.get(0);
        b = range.get(1);
        c = range.get(2);
        d = range.get(3);

        if((b-a) == 0)
        {
            slop1 = 0;
            term1 = 1;
        }else{
            slop1 = 1.0 / (b-a);
            term1 = -1*(slop1)*(a);
        }

        if((c-d) == 0)
        {
            slop2 = 0;
            term2 = 1;
        }else{
            slop2 = 1.0 / (c-d);
            term2 = -1*(slop2)*(d);
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
            return 1;
        }
        else if(crispValue >= c && crispValue <= d)
        {
            return (slop2*crispValue) + term2;
        }
        else
            return 0;
    }
}
