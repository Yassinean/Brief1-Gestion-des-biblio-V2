package org.example;

import config.DbConfig;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DbConfig.getConnection();
            if (connection != null) {
                System.out.println("Connected to the database successfully!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while trying to connect to the database.");
            e.printStackTrace();
        }
    }
}
