package com.company.entities;

public class Risk {

    private int crispValue;
    private double low;
    private double normal;
    private double high;

    public Risk(double low, double normal, double high) {
        this.low = low;
        this.normal = normal;
        this.high = high;
    }

    public int getCrispValue() {
        return crispValue;
    }

    public void setCrispValue(int crispValue) {
        this.crispValue = crispValue;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getNormal() {
        return normal;
    }

    public void setNormal(double normal) {
        this.normal = normal;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }
}
