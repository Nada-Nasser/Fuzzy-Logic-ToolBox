package com.company;

import com.company.process.TeamFormationSupportSystem;
import com.company.toolbox.FuzzyToolBox;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        FuzzyToolBox toolBox = new FuzzyToolBox(1);

        toolBox.addInputVariable("var1");

        ArrayList<Double> rangeSet1 = new ArrayList<>();
        rangeSet1.add(0.0);
        rangeSet1.add(0.0);
        rangeSet1.add(10.0);
        rangeSet1.add(30.0);
        toolBox.getVariable("var1").addFuzzySet("VL" , FuzzyToolBox.SET_TYPE_TRAP , rangeSet1);

        ArrayList<Double> rangeSet2 = new ArrayList<>();
        rangeSet2.add(10.0);
        rangeSet2.add(30.0);
        rangeSet2.add(40.0);
        rangeSet2.add(60.0);
        toolBox.getVariable("var1").addFuzzySet("L" , FuzzyToolBox.SET_TYPE_TRAP , rangeSet2);

        ArrayList<Double> rangeSet3 = new ArrayList<>();
        rangeSet3.add(40.0);
        rangeSet3.add(60.0);
        rangeSet3.add(70.0);
        rangeSet3.add(90.0);
        toolBox.getVariable("var1").addFuzzySet("M" , FuzzyToolBox.SET_TYPE_TRAP , rangeSet3);

        ArrayList<Double> rangeSet4 = new ArrayList<>();
        rangeSet4.add(70.0);
        rangeSet4.add(90.0);
        rangeSet4.add(100.0);
        rangeSet4.add(100.0);
        toolBox.getVariable("var1").addFuzzySet("H" , FuzzyToolBox.SET_TYPE_TRAP , rangeSet4);

        toolBox.getVariable("var1").setCrispValue(45);

        toolBox.run();
        System.out.println( toolBox.getVariable("var1").toString());
    }
}
