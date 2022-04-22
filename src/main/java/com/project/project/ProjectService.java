package com.project.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
// import java.sql.SQLException;
import java.sql.Statement;
// import java.sql.PreparedStatement;


//All Database related operations happen under this class
public class ProjectService {

    public void getAllUsers()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");
            while(rs.next())
            {
                String username = rs.getString("iduser");
                String password = rs.getString("pwduser");
                System.out.println(username + "\t" + password + "\n");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
