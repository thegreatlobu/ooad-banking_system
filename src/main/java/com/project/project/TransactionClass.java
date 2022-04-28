package com.project.project;

public class TransactionClass {
    private int accountno;
    private int accountno_user;
    private String username;
    private double value;
    private boolean type = true;

    public void setAccount(int accno){this.accountno = accno;}
    public int getAccount(){return this.accountno;}
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public double getValue(){return this.value;}
    public void setValue(int value){this.value = value;}
    public void setType(boolean type){this.type = type;}

    public void setAccountno_user(int acc_user){this.accountno_user = acc_user;}
    public int getAccountno_user(){return this.accountno_user;}
    public boolean gettype(){return this.type;}

}
