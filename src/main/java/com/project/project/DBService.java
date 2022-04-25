package com.project.project;

import java.sql.Connection;
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
                user.setUsername(rs.getString("iduser"));
                user.setPassword(rs.getString("pwduser"));
                // System.out.println(username + "\t" + password + "\n");
                users.add(user);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return users;
    }

    //Add user to DB
    public void addUser(String username, String password)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
            //Execute SQl Query
            PreparedStatement stmt = null;
            String query = "INSERT INTO bank.user(iduser, pwduser) VALUES (?,?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            int row = stmt.executeUpdate();
            System.out.println(row);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
