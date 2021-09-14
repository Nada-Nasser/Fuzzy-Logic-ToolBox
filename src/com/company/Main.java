package com.company;

import com.company.toolbox.FuzzyToolBox;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        /**
         * Steps
         *  1- Build the input variables
         *  2- Build the output variable
         *  3- Add the rules
         *  4- Set the crisp value of the input variables
         *  5- run the tool box with function toolBox.run()
         *  6- print the results in the output variable
         * */

        FuzzyToolBox toolBox = new FuzzyToolBox(); // initialize the Fuzzy logic toolbox
        /**
         * Build the first input variable
         * name = var1
         * Fuzzy Sets:
         *  Very Low    (VL): [0,0,10,30]      => Trapezoid set
         *  Low         (L) : [10,30,40,60]    => Trapezoid set
         *  Medium      (M) : [40,60,70,90]    => Trapezoid set
         *  High        (H) : [70,90,100,100]  => Trapezoid set
         */
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

        /**
         * Build the Second input variable
         * name = var2
         * Fuzzy Sets:
         *  Low       (L) : [0,15,30]   => Triangular set
         *  Medium    (M) : [15,30,45]  => Triangular set
         *  High      (H) : [40,60,60]  => Triangular set
         */
        toolBox.addInputVariable("var2");
        ArrayList<Double> rangeSet5 = new ArrayList<>();
        rangeSet5.add(0.0);
        rangeSet5.add(15.0);
        rangeSet5.add(30.0);
        toolBox.getInputVariable("var2").addFuzzySet("L" , FuzzyToolBox.SET_TYPE_TRI , rangeSet5);

        ArrayList<Double> rangeSet6 = new ArrayList<>();
        rangeSet6.add(15.0);
        rangeSet6.add(30.0);
        rangeSet6.add(45.0);
        toolBox.getInputVariable("var2").addFuzzySet("M" , FuzzyToolBox.SET_TYPE_TRI , rangeSet6);

        ArrayList<Double> rangeSet7 = new ArrayList<>();
        rangeSet7.add(30.0);
        rangeSet7.add(60.0);
        rangeSet7.add(60.0);
        toolBox.getInputVariable("var2").addFuzzySet("H" , FuzzyToolBox.SET_TYPE_TRI , rangeSet7);


        /**
         * Build Output variable
         * name = var2
         * Fuzzy Sets:
         *  high   : [0,25,50]     => Triangular set
         *  normal : [25,50,75]    => Triangular set
         *  low    : [50,100,100]  => Triangular set
         */
        toolBox.addOutputVariable("risk");

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

        toolBox.getOutputVariable("risk").addFuzzySet("High" , FuzzyToolBox.SET_TYPE_TRI , rangerisk1);
        toolBox.getOutputVariable("risk").addFuzzySet("Normal" , FuzzyToolBox.SET_TYPE_TRI , rangerisk2);
        toolBox.getOutputVariable("risk").addFuzzySet("Low" , FuzzyToolBox.SET_TYPE_TRI , rangerisk3);

        toolBox.addRule("var1 H or var2 E -> risk Low");
        toolBox.addRule("var1 M and var2 I or var2 B -> risk Normal");
        toolBox.addRule("var1 VL -> risk High");
        toolBox.addRule("var1 L and var2 B -> risk High");

        toolBox.getInputVariable("var1").setCrispValue(10);
        toolBox.getInputVariable("var2").setCrispValue(40);

        toolBox.run();
        //System.out.println( toolBox.getInputVariable("var1").toString());
        //System.out.println( toolBox.getInputVariable("var2").toString());
        System.out.println(toolBox.getOutputVariable("risk").toString());
    }
}
