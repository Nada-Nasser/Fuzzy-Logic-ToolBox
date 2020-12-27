package com.company.entities;

import com.company.memberships.TeamExperienceLevelMembership;

public class TeamExperienceLevel {
    private int crispValue;
    private double beginner;
    private double intermediate;
    private double expert;

    public TeamExperienceLevel(int crispValue) {
        this.crispValue = crispValue;
        TeamExperienceLevelMembership teamExperienceLevelMembership = new TeamExperienceLevelMembership();
        beginner = teamExperienceLevelMembership.calculateBeginnerValue(crispValue);
        intermediate = teamExperienceLevelMembership.calculateIntermediateValue(crispValue);
        expert = teamExperienceLevelMembership.calculateExpertValue(crispValue);
    }

    public double getBeginner() {
        return beginner;
    }

    public void setBeginner(float beginner) {
        this.beginner = beginner;
    }

    public double getIntermediate() {
        return intermediate;
    }

    public void setIntermediate(float intermediate) {
        this.intermediate = intermediate;
    }

    public double getExpert() {
        return expert;
    }

    public void setExpert(float expert) {
        this.expert = expert;
    }

    @Override
    public String toString() {
        return "TeamExperienceLevel{" +
                "crispValue=" + crispValue +
                ", beginner=" + beginner +
                ", intermediate=" + intermediate +
                ", expert=" + expert +
                '}';
    }
}
