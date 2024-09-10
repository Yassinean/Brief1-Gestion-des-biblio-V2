package org.example;

import org.example.config.DbConfig;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DbConfig.getInstance().getConnection();

    }
}

