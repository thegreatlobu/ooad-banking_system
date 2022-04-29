package com.project.project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
// import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

//All Database related operations happens here
public class DBService {

    private static DBService DBServiceInstance = new DBService() ;
    
    private DBService(){};
 
    public static DBService getInstance()
    {
        return DBServiceInstance;
    }
    
    public ArrayList<User> getAllUsers()
    {
        ArrayList<User> users = new ArrayList<>();
        try {
            //Establish DB connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
            //Execute SQl Query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM bank.user");
            //Add users to collection and return collection
            while(rs.next())
            {
                User user = new User();
                // String username = rs.getString("iduser");
                // String password = rs.getString("pwduser");
                user.setAccount_no(rs.getInt("accuser"));
                user.setPassword(rs.getString("pwduser"));
                user.setDOB(rs.getDate("dobuser"));
                user.setpan_no(rs.getString("panuser"));
                user.setAadhar_no(rs.getString("aadharuser"));
                user.setUsername(rs.getString("nameuser"));
                user.setPhone_no(rs.getString("phoneuser"));
                // System.out.println(username + "\t" + password + "\n");
                users.add(user);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return users;
    }

    //Get user from DB
    public User getUser(int account_no)
    {
        User user = new User();    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE accuser = " + account_no);
            // System.out.println("SELECT user FROM bank.user WHERE accuser = " + account_no);
            while(rs.next())
            {
               
                user.setAccount_no(rs.getInt("accuser"));
                user.setPassword(rs.getString("pwduser"));
                user.setDOB(rs.getDate("dobuser"));
                user.setpan_no(rs.getString("panuser"));
                user.setAadhar_no(rs.getString("aadharuser"));
                user.setUsername(rs.getString("nameuser"));
                user.setPhone_no(rs.getString("phoneuser"));

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return user;
      
    }
    
    //Add user to DB
    public void addUser(String password, Date dob, String pan, String aadhar, String phone, String name)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
            //Execute SQl Query
            PreparedStatement stmt = null;
            // System.out.println(password+dob+pan+aadhar+phone+name);
            String query = "INSERT INTO bank.user(pwduser, dobuser, panuser, aadharuser, phoneuser, nameuser) VALUES (?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, password);
            stmt.setDate(2, dob);
            stmt.setString(3, pan);
            stmt.setString(4, aadhar);
            stmt.setString(5, phone);
            stmt.setString(6, name);
            int row = stmt.executeUpdate();
            System.out.println(row);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
    

    //add account to db
    public void addAccount(int account_no, String username, String acctype, double balance)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
            //Execute SQl Query
            PreparedStatement stmt = null;
            // System.out.println(password+dob+pan+aadhar+phone+name);
            String query = "INSERT INTO bank.accounts(accuser, nameuser, acctype, balance) VALUES (?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, account_no);
            stmt.setString(2, username);
            stmt.setString(3, acctype);
            stmt.setDouble(4, balance);
            int row = stmt.executeUpdate();
            System.out.println(row);
        } catch (Exception ex) {
            System.out.println(ex);
        }
      
    }
    //Get account from DB
    public Account getAccount(int account_no)
    {
        Account account = new Account();  
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM accounts WHERE accuser = " + account_no);
            // System.out.println("SELECT user FROM bank.user WHERE accuser = " + account_no);
            while(rs.next())
            {
               
                account.setAccount_no(rs.getInt("accuser"));
                account.setUsername(rs.getString("nameuser"));
                account.setAcctype(rs.getString("acctype"));
                account.setBalance(rs.getDouble("balance"));

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return account;
      
    }

    //add fd to db
    public void addfd(int custid, int amt, int dur)
    {
        try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
                //Execute SQl Query
                PreparedStatement stmt = null;
                // System.out.println(password+dob+pan+aadhar+phone+name);
                String query = "INSERT INTO bank.fd(amt, dur, custid) VALUES (?,?,?)";
                stmt = conn.prepareStatement(query);
                stmt.setInt(1, amt);
                stmt.setInt(2, dur);
                stmt.setInt(3, custid);
                int row = stmt.executeUpdate();
                System.out.println(row);
            } 
            catch (Exception ex) {
                System.out.println(ex);
            }    
    }    

    public void addloan(int custid, int amt, int duration, int emi, double rate, String type)
{
    try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
            //Execute SQl Query
            PreparedStatement stmt = null;
            // System.out.println(password+dob+pan+aadhar+phone+name);
            String query = "INSERT INTO bank.loan(custid, amt, duration, emi, rate, type) VALUES (?,?,?,?,?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, custid);
            stmt.setInt(2, amt);
            stmt.setInt(3, duration);
            stmt.setInt(4, emi);
            stmt.setDouble(5, rate);
            stmt.setString(6, type);
            int row = stmt.executeUpdate();
            System.out.println(row);
        } 
        catch (Exception ex) {
            System.out.println(ex);
        }    
}

public Loan getloan(int account_no)
{
    Loan loan = new Loan();    
    try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM loan WHERE custid = " + account_no);
            while(rs.next())
            {  
                loan.setcustid(rs.getInt("custid"));
                loan.setamt(rs.getInt("amt"));
                loan.setduration(rs.getInt("duration"));
                loan.setemi(rs.getInt("emi"));
                loan.setrate(rs.getDouble("rate"));
                loan.settype(rs.getString("type"));
            }
        } 
    catch (Exception ex) 
        {
            System.out.println(ex);
        }
    return loan;      
}

//Get fd from DB
public FD getfd(int account_no)
{
    FD fd = new FD();    
    try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM fd WHERE custid = " + account_no);
            while(rs.next())
            {  
                fd.setamt(rs.getInt("amt"));
                fd.setduration(rs.getInt("dur"));
                fd.setcustid(rs.getInt("custid"));
            }
        } 
    catch (Exception ex) 
        {
            System.out.println(ex);
        }
    return fd;      
}

public double getBalance(int account_no,String type){
    double bal = 0.0;
    String value ="";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
        PreparedStatement stmt = null;
        String query1 = "SELECT * FROM bank.accounts where accuser=? and acctype=?";
        stmt = conn.prepareStatement(query1);
        stmt.setInt(1,account_no);
        stmt.setString(2,type);
        //System.out.println(stmt);
        ResultSet rs = stmt.executeQuery();
        //System.out.println(rs);
        rs.next();
        bal = rs.getDouble("balance");
        //System.out.println(bal);
        return bal;
    }
    catch(Exception ex){
        System.out.println(ex);
    }
    return 0.0;
}
public boolean updateBalance(int accountno_1,int accountno_2,double value,String type){
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
    PreparedStatement stmt = null;
    PreparedStatement stmt2 = null;
        double user_bal = getBalance(accountno_1,"Savings");
        
        // try{
        //     person_bal = getBalance(accountno_2,type);
        // }catch(Exception ex){
        //     user_bal = user_bal + value;
        // }
        double person_bal = getBalance(accountno_2,type);
        user_bal = user_bal - value;
        person_bal= person_bal + value;

        if(user_bal<value || user_bal<1000-value){
            System.out.println("Low Balance");
            return false;
        }
        else if(accountno_1==accountno_2){
            System.out.println("Same accounts");
        }
        else{
            String query1 = "UPDATE accounts SET balance=? where accuser=? and acctype=?";
            stmt = conn.prepareStatement(query1);
            stmt2 = conn.prepareStatement(query1);
            stmt.setDouble(1,user_bal);
            stmt.setInt(2,accountno_1);
            stmt.setString(3,"Savings");
            stmt2.setDouble(1,person_bal);
            stmt2.setInt(2,accountno_2);
            stmt2.setString(3,type);
            int rs1 = stmt.executeUpdate();
            int rs2 = stmt2.executeUpdate();
            if(rs1 == 1 && rs2 == 1){
                System.out.println("Printing...");
            }
            System.out.println(getBalance(accountno_1,"Savings"));
            System.out.println(getBalance(accountno_2,type));
            return true;
        }

    }

    catch (Exception e){
        System.out.println(e);
    }
    return true;
}
}

