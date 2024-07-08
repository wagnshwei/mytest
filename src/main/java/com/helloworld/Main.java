package com.helloworld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://10.0.7.9:3397/examination" +
                "?autoReconnect=true&useUnicode=true"
                +
                "&characterEncoding=utf8" +
                "&zeroDateTimeBehavior=convertToNull" +
                "&useSSL=false" +
                "&useTimezone=true" +
                "&serverTimezone=GMT%2B8" +
                "&allowMultiQueries=true" +
                "&rewriteBatchedStatements=true";
        String user = "root";
        String password = "root";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database");
        } catch (SQLException ex) {
            System.err.println("Error connecting to the database:");
            while (ex != null) {
                System.err.println("\t" + ex.getMessage());
                ex = ex.getNextException();
            }
        }
    }
}
