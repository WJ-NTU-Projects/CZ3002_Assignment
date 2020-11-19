package com.ase.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseController {
    /* MySQL Server Parameters
     * ===== IMPORTANT! =====
     * If using docker-for-windows or docker-for-mac, host should be "host.docker.internal"!
     * Otherwise, it should be whatever IP address your host machine is.
     */
    private static final String DATABASE_HOST = "host.docker.internal";
    private static final String DATABASE_PORT = "3306";
    private static final String DATABASE_SCHEMA = "ase";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "12345678";

    public static boolean login(String username, String password) {
        Connection connection = null;
        boolean ret = false;

        try {
            String URL = "jdbc:mysql://" + DATABASE_HOST + ":" + DATABASE_PORT + "/" + DATABASE_SCHEMA;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, DATABASE_USERNAME, DATABASE_PASSWORD);

            // Table name: users
            // Columns: username, password
            String query = "SELECT `username` FROM `users` WHERE `username` = ? AND `password` = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (result.next()) ret = true;
        } catch (Exception e) {
            // Will output to docker log. Not sure for other hosts.
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
