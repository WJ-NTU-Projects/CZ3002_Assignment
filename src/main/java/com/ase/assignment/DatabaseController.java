package com.ase.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseController {
    public static boolean login(String username, String password) {
        Connection connection = null;
        boolean ret = false;

        try {
            // jdbc:mysql://localhost/<DB_NAME>, change accordingly.
            String URL = "jdbc:mysql://localhost/ase";
            Class.forName("com.mysql.jdbc.Driver");

            // SQL server username and password, change accordingly.
            connection = DriverManager.getConnection(URL, "root", "12345678");

            // Table name: users
            // Columns: username and password
            String query = "SELECT `username` FROM `users` WHERE `username` = ? AND `password` = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (result.next()) ret = true;
        } catch (Exception e) {
            // Can we actually print to console like this?
            System.out.println("Exception:");
            e.printStackTrace();
            ret = false; // just in case
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Exception:");
                    e.printStackTrace();
                }
            }
        }

        return ret;
    }
}
