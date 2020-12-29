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


        toolBox.addInputVariable("var2");
        ArrayList<Double> rangeSet5 = new ArrayList<>();
        rangeSet5.add(0.0);
        rangeSet5.add(15.0);
        rangeSet5.add(30.0);
        toolBox.getInputVariable("var2").addFuzzySet("B" , FuzzyToolBox.SET_TYPE_TRI , rangeSet5);

        ArrayList<Double> rangeSet6 = new ArrayList<>();
        rangeSet6.add(15.0);
        rangeSet6.add(30.0);
        rangeSet6.add(45.0);
        toolBox.getInputVariable("var2").addFuzzySet("I" , FuzzyToolBox.SET_TYPE_TRI , rangeSet6);

        ArrayList<Double> rangeSet7 = new ArrayList<>();
        rangeSet7.add(30.0);
        rangeSet7.add(60.0);
        rangeSet7.add(60.0);
        toolBox.getInputVariable("var2").addFuzzySet("E" , FuzzyToolBox.SET_TYPE_TRI , rangeSet7);


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
        System.out.println( toolBox.getInputVariable("var1").toString());
        System.out.println( toolBox.getInputVariable("var2").toString());
        System.out.println( toolBox.getOutputVariable("risk").toString());

        /*
        Scanner in = new Scanner(System.in);
        TeamFormationSupportSystem teamFormationSupportSystem;

        int projectFund, experienceLevel;
        System.out.print("Project Fund: ");
        projectFund = in.nextInt();
        System.out.print("Experience Level: ");
        experienceLevel = in.nextInt();

        teamFormationSupportSystem = new TeamFormationSupportSystem();
        teamFormationSupportSystem.readInputs(projectFund, experienceLevel);
        teamFormationSupportSystem.evaluateTeam();

        System.out.println("Predicted Value (Risk) = " + teamFormationSupportSystem.getPredictedRiskValue());
        System.out.println("Risk will be " + teamFormationSupportSystem.getPredictedRiskCategory());*/
    }
}
