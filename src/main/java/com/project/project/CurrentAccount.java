package com.project.project;

import java.sql.Date;

public class CurrentAccount extends Account{
    private Date DOP;
    private double min_balance = 5000.0;
    public double getMin_balance() {
        return min_balance;
    }
    public Date getDOP() {
        return DOP;
    }
    public void setDOP(Date dOP) {
        this.DOP = dOP;
    }
}
