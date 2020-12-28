package com.company;

import com.company.toolbox.FuzzyToolBox;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        FuzzyToolBox toolBox = new FuzzyToolBox(1);

        toolBox.addInputVariable("var1");

        ArrayList<Double> rangeSet1 = new ArrayList<>();
        rangeSet1.add(0.0);
        rangeSet1.add(0.0);
        rangeSet1.add(10.0);
        rangeSet1.add(30.0);
        toolBox.getInputVariable("var1").addFuzzySet("VL" , FuzzyToolBox.SET_TYPE_TRAP , rangeSet1);


        ArrayList<Double> rangeSet2 = new ArrayList<>();
        rangeSet2.add(10.0);
        rangeSet2.add(30.0);
        rangeSet2.add(40.0);
        rangeSet2.add(60.0);
        toolBox.getInputVariable("var1").addFuzzySet("L" , FuzzyToolBox.SET_TYPE_TRAP , rangeSet2);

        ArrayList<Double> rangeSet3 = new ArrayList<>();
        rangeSet3.add(40.0);
        rangeSet3.add(60.0);
        rangeSet3.add(70.0);
        rangeSet3.add(90.0);
        toolBox.getInputVariable("var1").addFuzzySet("M" , FuzzyToolBox.SET_TYPE_TRAP , rangeSet3);

        ArrayList<Double> rangeSet4 = new ArrayList<>();
        rangeSet4.add(70.0);
        rangeSet4.add(90.0);
        rangeSet4.add(100.0);
        rangeSet4.add(100.0);
        toolBox.getInputVariable("var1").addFuzzySet("H" , FuzzyToolBox.SET_TYPE_TRAP , rangeSet4);

        toolBox.getInputVariable("var1").setCrispValue(45);

        toolBox.addOutputVariable("risk");
        //he set defined for the risk is high (0,25,50), normal (25,50,75),
        //low (50,100,100).

        ArrayList<Double> rangerisk1 = new ArrayList<>();
        rangerisk1.add(0.0);
        rangerisk1.add(25.0);
        rangerisk1.add(50.0);
        ArrayList<Double> rangerisk2 = new ArrayList<>();
        rangerisk2.add(25.0);
        rangerisk2.add(50.0);
        rangerisk2.add(75.0);
        ArrayList<Double> rangerisk3 = new ArrayList<>();
        rangerisk3.add(50.0);
        rangerisk3.add(100.0);
        rangerisk3.add(100.0);

        toolBox.getOutputVariable("risk").addFuzzySet("H" , FuzzyToolBox.SET_TYPE_TRI , rangerisk1);
        toolBox.getOutputVariable("risk").addFuzzySet("N" , FuzzyToolBox.SET_TYPE_TRI , rangerisk2);
        toolBox.getOutputVariable("risk").addFuzzySet("L" , FuzzyToolBox.SET_TYPE_TRI , rangerisk3);

        /*
        ArrayList<Double> deleteME = new ArrayList<>();
        deleteME.add(0.0);
        deleteME.add(0.5);
        deleteME.add(0.5);
        toolBox.getOutputVariable("risk").setFuzzifiedValues(deleteME);//TODO: DELETE THIS LINE*/

        toolBox.run();
        System.out.println( toolBox.getInputVariable("var1").toString());
        System.out.println( toolBox.getOutputVariable("risk").toString());

    }
}
