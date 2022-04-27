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

    public ArrayList<User> getAllUsers()
    {
        ArrayList<User> users = new ArrayList<User>();
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
                user.setPan_no(rs.getString("panuser"));
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
                user.setPan_no(rs.getString("panuser"));
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
}
