package com.project.project;

public class Account {
    private int account_no;
    private double balance=1000.0;
    private String username;
    private String acctype;
    public int getAccount_no() {
        return account_no;
    }
    public String getAcctype() {
        return acctype;
    }
    public void setAcctype(String acctype) {
        this.acctype = acctype;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setAccount_no(int account_no) {
        this.account_no = account_no;
    }
}
