package com.ase.assignment;

import java.sql.Connection;
import java.sql.DriverManager;

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

    public static Connection getDatabaseConnection() {
        String URL = "jdbc:mysql://" + DATABASE_HOST + ":" + DATABASE_PORT + "/" + DATABASE_SCHEMA;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, DATABASE_USERNAME, DATABASE_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
