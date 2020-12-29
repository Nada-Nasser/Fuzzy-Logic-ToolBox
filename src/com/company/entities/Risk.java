package com.company.entities;

public class Risk {

    private double crispValue;
    private double low;
    private double normal;
    private double high;

    public Risk(double low, double normal, double high) {
        this.low = low;
        this.normal = normal;
        this.high = high;
    }

    @Override
    public String toString() {
        return "Risk{" +
                "crispValue=" + crispValue +
                ", low=" + low +
                ", normal=" + normal +
                ", high=" + high +
                '}';
    }

    public double getCrispValue() {
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

    public void defuzzify()
    {
        this.crispValue  = ((high*25)+(normal*50)+(low*83.3))/(low+high+normal);
    }

}
