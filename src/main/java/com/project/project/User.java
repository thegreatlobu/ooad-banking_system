package com.project.project;

import java.sql.Date;

public class User {
    private int account_no;
    private String username;
    private String password;
    private Date DOB;
    private String pan_no;
    private String aadhar_no;
    private String phone_no;

    public String getUsername() {
        return username;
    }
    public int getAccount_no() {
        return account_no;
    }
    public void setAccount_no(int account_no) {
        this.account_no = account_no;
    }
    public String getPhone_no() {
        return phone_no;
    }
    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }
    public String getAadhar_no() {
        return aadhar_no;
    }
    public void setAadhar_no(String aadhar_no) {
        this.aadhar_no = aadhar_no;
    }
    public String getpan_no() {
        return pan_no;
    }
    public void setpan_no(String pan_no) {
        this.pan_no = pan_no;
    }
    public Date getDOB() {
        return DOB;
    }
    public void setDOB(Date dOB) {
        this.DOB = dOB;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String toString() {
        
        return this.username + this.password;
    }
    
}
