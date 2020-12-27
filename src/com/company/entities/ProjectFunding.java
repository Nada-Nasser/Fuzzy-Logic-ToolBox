package com.company.entities;

import com.company.memberships.ProjectFundingMembership;

public class ProjectFunding {
    private int crispValue;
    private float veryLow;
    private float low;
    private float medium;
    private float high;

    public ProjectFunding(int crispValue) {
        this.crispValue = crispValue;
        ProjectFundingMembership projectFundingMembership = new ProjectFundingMembership();
        veryLow = projectFundingMembership.calculateVeryLowValue(crispValue);
        low = projectFundingMembership.calculateLowValue(crispValue);
        medium = projectFundingMembership.calculateMediumValue(crispValue);
        high = projectFundingMembership.calculateHighValue(crispValue);
    }

    public float getVeryLow() {
        return veryLow;
    }

    public void setVeryLow(float veryLow) {
        this.veryLow = veryLow;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getMedium() {
        return medium;
    }

    public void setMedium(float medium) {
        this.medium = medium;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    @Override
    public String toString() {
        return "ProjectFunding{" +
                "crispValue=" + crispValue +
                ", veryLow=" + veryLow +
                ", low=" + low +
                ", medium=" + medium +
                ", high=" + high +
                '}';
    }
}
