package com.company.toolbox.sets;

import com.company.toolbox.variables.FuzzyVariable;

import java.util.ArrayList;
import java.util.HashMap;

public class FuzzyRule {
    String[] operators = {"&", "|", "->", "!"};
    static String[] Parsed;
    // len = 8
    // input_variable_name SET_NAME op input_variable_name SET_NAME -> output_variable_name SET_NAME

    public FuzzyRule(String rule)//, HashMap<String,FuzzyVariable> FV)
    {
        Parsed = rule.split(" ");
    }


    public static HashMap<String, FuzzyVariable> getInference(ArrayList<FuzzyRule> fuzzyRules, HashMap<String, FuzzyVariable> inputFuzzyVariables) {

        HashMap<String, FuzzyVariable> OutputFuzzyVariables = new HashMap<>();
        for(int j = 0;j < fuzzyRules.size();j++) {
            double OutMembership = 0;

            int i = 0;
            FuzzyVariable FV = inputFuzzyVariables.get(Parsed[i++]); // getting the input_variable_name
            double MembershipSet = getMInMembership(FV, Parsed[i++]);

            String operator = Parsed[i++];

            FuzzyVariable FV2 = inputFuzzyVariables.get(Parsed[i++]); // getting the input_variable_name
            double MembershipSet2 = getMInMembership(FV, Parsed[i++]);

            double OutputMembership = calculateMemberShip(MembershipSet, MembershipSet2, operator);
            while (!Parsed[i].equals("->")) {
                operator = Parsed[i++];

                FuzzyVariable FV3 = inputFuzzyVariables.get(Parsed[i++]); // getting the input_variable_name
                double MembershipSet3 = getMInMembership(FV, Parsed[i++]);

                OutMembership = calculateMemberShip(OutMembership, MembershipSet3, operator);
            }

            String OutVariableName = Parsed[++i];
            String SetName = Parsed[i++];

            if(OutputFuzzyVariables.get(OutVariableName) == null) {
                FuzzyVariable FuzzyOut = new FuzzyVariable(OutVariableName);
                FuzzyOut.setMembership(SetName, OutMembership);
                OutputFuzzyVariables.put(OutVariableName,FuzzyOut);
            }
            else{
                FuzzyVariable FuzzyOut = OutputFuzzyVariables.get(OutVariableName);
                if(FuzzyOut.getMembership(SetName) == -1) {
                    OutputFuzzyVariables.get(OutVariableName).setMembership(SetName,OutMembership);
                }
                else{
                    OutputFuzzyVariables.get(OutVariableName).setMembership(SetName,Math.min(FuzzyOut.getMembership(SetName),OutMembership));
                }
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

    private static double getMInMembership(FuzzyVariable FV, String SetName){
        if (SetName.charAt(0) == '!')
            return  1 - FV.getMembership(SetName); //getting the input membership using SET_NAME
        else
            return FV.getMembership(SetName); //getting the input membership using SET_NAME
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
