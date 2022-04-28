package com.project.project;

public class Loan
{
    private int custid;
    private int amt;
    private int duration;
    private int emi;
    private double rate;
    private String type;

    public int getcustid() {
        return custid;
    }
    public int getamt() {
        return amt;
    }
    public int getduration() {
        return duration;
    }
    public int getemi() {
        return emi;
    }
    public double getrate() {
        return rate;
    }
    public String gettype() {
        return type;
    }
/////////////////////////////////////////////////////////////////////////
    public void setcustid(int custid) {
        this.custid = custid;
    }
    public void setamt(int amt) {
        this.amt = amt;
    }
    public void setduration(int duration) {
        this.duration = duration;
    }    
    public void setemi(int emi) {
        this.emi = emi;
    }
    public void setrate(double rate) {
        this.rate = rate;
    }
    public void settype(String type) {
        this.type = type;
    }

}
