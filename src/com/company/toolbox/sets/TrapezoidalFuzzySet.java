package com.company.toolbox.sets;

import java.util.ArrayList;

public class TrapezoidalFuzzySet extends FuzzySet{

    private double slop1 , slop2, term1, term2;
    private double a,b,c,d;
    private double ya,yb,yc,yd;

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

        ya = getMembershipValue(a);
        yb = getMembershipValue(b);
        yc = getMembershipValue(c);
        yd = getMembershipValue(d);

        calculateCentroid();
    }


    @Override
    public double getCentroid() {
        return centroid;
    }

    // area = 𝟏/𝟐 ∑ (𝒙𝒊 * 𝒚𝒊+𝟏 − 𝒙𝒊+𝟏 * 𝒚𝒊)
    private void calculateCentroid() // (1/6A) ∑ 𝒙𝒊 + 𝒙𝒊+𝟏(𝒙𝒊 𝒚𝒊+𝟏 − 𝒙𝒊+𝟏 𝒚𝒊)
    {
        double A = getArea();

        this.centroid =
                (1.0 / (6.0 * A))*
                (((a + b) * (a * yb - b * ya))+
                 ((b + c) * (b * yc - c * yb))+
                 ((c + d) * (c * yd - d * yc)));
/*
        System.out.println(A);
        System.out.println(
                ((a + b*(a*yb - b*ya))+
                (b + c*(b*yc - c*yb))+
                (c + d*(c*yd - d*yc)))
        );
        System.out.println(centroid);*/
    }

    //range=[0.0, 0.0, 10.0, 30.0]
    // y   =[1 ,   1 ,   1 ,  0  ]

    // area = 𝟏/𝟐 ∑ (𝒙𝒊 * 𝒚𝒊+𝟏 − 𝒙𝒊+𝟏 * 𝒚𝒊)
    private double getArea() {
        double sum =  (a*yb - b*ya)
                    + (b*yc - c*yb)
                    + (c*yd - d*yc);

        return (1.0/2.0) * sum;
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
