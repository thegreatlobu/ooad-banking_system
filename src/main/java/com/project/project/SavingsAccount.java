package com.project.project;

import java.sql.Date;

public class SavingsAccount extends Account {
    private float interest_rate;
    private Date DOP;
    private double min_balance = 1000.0;

    public float getInterest_rate() {
        return interest_rate;
    }
    public double getMin_balance() {
        return min_balance;
    }
    
    public Date getDOP() {
        return DOP;
    }
    public void setDOP(Date dOP) {
        this.DOP = dOP;
    }
    public void setInterest_rate(float interest_rate) {
        this.interest_rate = interest_rate;
    }
    
}
