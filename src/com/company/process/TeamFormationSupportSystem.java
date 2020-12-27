package com.company.process;

import com.company.entities.ProjectFunding;
import com.company.entities.Risk;
import com.company.entities.TeamExperienceLevel;

public class TeamFormationSupportSystem
{
    private Risk risk;
    private ProjectFunding projectFunding;
    private TeamExperienceLevel teamExperienceLevel;

    //1- Fuzzifying the inputs
    public void readInputs(int projectFund , int experienceLevel){
        projectFunding = new ProjectFunding(projectFund);
        teamExperienceLevel = new TeamExperienceLevel(experienceLevel);

        System.out.println(projectFunding.toString());
        System.out.println(teamExperienceLevel.toString());
    }

    public void evaluateTeam()
    {
        //2- Inference of rules
        rulesInference();
        //3- Defuzzification output
        defuzzification();
    }

    public double getPredictedRiskValue()
    {
        return risk.getCrispValue();
    }

    public String getPredictedRiskCategory()
    {
        // TODO: identify if the risk is high/normal/low
        return "NULL";
    }

    // apply any defuzzification to risk object to calculate its crispValue
    private void defuzzification() {
        // TODO
    }

    /**
     * 1. If project_funding is high or team_experience_level is expert then risk is
     * low.
     *
     * 2. If project_funding is medium and team_experience_level is intermediate
     * or team_experience_level is beginner then risk is normal.
     *
     * 3. If project_funding is very low then risk is high.
     *
     * 4. If project_funding is low and team_experience_level is beginner then risk
     * is high.
     * */
    private void rulesInference() {
        double riskLow = Math.max(projectFunding.getHigh() , teamExperienceLevel.getExpert());
        double riskNormal = Math.min(projectFunding.getMedium(), teamExperienceLevel.getIntermediate());
        double riskHigh = Math.max(projectFunding.getVeryLow() ,
                Math.min(projectFunding.getLow(), teamExperienceLevel.getBeginner()));

        risk = new Risk(riskLow,riskNormal,riskHigh);
    }
}
