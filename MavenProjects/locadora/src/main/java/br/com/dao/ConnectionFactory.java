package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public Connection getConnection() {
        String url = "jdbc:mysql://127.0.0.1:3306/dblocadora";
        String user = "root";
        String pass = "murilo@16";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            throw new RuntimeException("Erro: " + e);
        }
    }
}