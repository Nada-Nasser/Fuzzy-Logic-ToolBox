package com.company.toolbox.sets;

import java.util.ArrayList;
import java.util.HashMap;

public class FuzzyRule
{
    String[] operators = {"&" , "|" , "->" , "!"};

    // len = 8
    // input_variable_name SET_NAME op input_variable_name SET_NAME -> output_variable_name SET_NAME

    // len = 5
    // !input_variable_name SET_NAME -> output_variable_name SET_NAME

    // len = 5
    // input_variable_name SET_NAME -> output_variable_name SET_NAME

    public FuzzyRule(String rule)
    {
        String[] splitRule = rule.split(" ");


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
