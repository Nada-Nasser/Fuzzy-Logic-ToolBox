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
        toolBox.getVariable("var1").addFuzzySet("set1" , FuzzyToolBox.SET_TYPE_TRI , rangeSet1);

        ArrayList<Double> rangeSet2 = new ArrayList<>();
        rangeSet2.add(0.0);
        rangeSet2.add(10.0);
        rangeSet2.add(20.0);
        toolBox.getVariable("var1").addFuzzySet("set2" , FuzzyToolBox.SET_TYPE_TRI , rangeSet2);

        ArrayList<Double> rangeSet3 = new ArrayList<>();
        rangeSet3.add(10.0);
        rangeSet3.add(30.0);
        rangeSet3.add(30.0);
        toolBox.getVariable("var1").addFuzzySet("set3" , FuzzyToolBox.SET_TYPE_TRI , rangeSet3);

        toolBox.getVariable("var1").setCrispValue(5);

        toolBox.run();
        System.out.println( toolBox.getVariable("var1").toString());

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
