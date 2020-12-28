package com.company.toolbox.sets;

import com.company.toolbox.variables.FuzzyVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FuzzyRule {
    String[] operators = {"&", "|", "->", "!"};
       // len = 8
    // input_variable_name SET_NAME op input_variable_name SET_NAME -> output_variable_name SET_NAME


    public static HashMap<String, FuzzyVariable> getInference(ArrayList<String> fuzzyRules, HashMap<String, FuzzyVariable> inputFuzzyVariables, HashMap<String, FuzzyVariable> OutputFuzzyVariables) {

        for(int j = 0;j < fuzzyRules.size();j++) {
            String[] Parsed = fuzzyRules.get(j).split(" ");

            double OutMembership = 1e7;
            String operator;
            int i = 0;

            FuzzyVariable FV = inputFuzzyVariables.get(Parsed[i++]); // getting the input_variable_name
            OutMembership = getInMembership(FV, Parsed[i++]);

            while (!Parsed[i].equals("->")) {
                operator = Parsed[i++];

                FuzzyVariable FV3 = inputFuzzyVariables.get(Parsed[i++]); // getting the input_variable_name
                double MembershipSet3 = getInMembership(FV3, Parsed[i++]);

                OutMembership = calculateMemberShip(OutMembership, MembershipSet3, operator);
            }

            String OutVariableName = Parsed[++i];
            String SetName = Parsed[++i];

            FuzzyVariable FuzzyOut = OutputFuzzyVariables.get(OutVariableName);
            if (FuzzyOut.getMembershipDegree(SetName) == -1.0) {
                OutputFuzzyVariables.get(OutVariableName).setMembershipDegree(SetName, OutMembership);
            } else {
                OutputFuzzyVariables.get(OutVariableName).setMembershipDegree(SetName, Math.min(FuzzyOut.getMembershipDegree(SetName), OutMembership));
            }

        }
        return OutputFuzzyVariables;
    }
    private static double calculateMemberShip(double num1, double num2, String op) {
        if (op.equals("or")) {
            return Math.max(num1,num2);
        }
        else if (op.equals("and")) {
            return Math.min(num1,num2);
        }
        else return 0.0;
    }

    private static double getInMembership(FuzzyVariable FV, String SetName){
        if (SetName.charAt(0) == '!') {

            return 1 - FV.getMembershipDegree(SetName.substring(1)); //getting the input membership using SET_NAME
        }
        else
            return FV.getMembershipDegree(SetName); //getting the input membership using SET_NAME
    }
    /**
     *  op
     *  &  -> Math.min
     *  |  -> Math.max
     *  -> -> equal
     *  !  -> 1 - x
     * **/

    // input_variable_name SET_NAME op
    // input_variable_name SET_NAME

    // len = 5
    // !input_variable_name SET_NAME op
    // input_variable_name SET_NAME

}
