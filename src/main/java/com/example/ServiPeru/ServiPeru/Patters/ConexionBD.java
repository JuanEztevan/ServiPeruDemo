package com.example.ServiPeru.ServiPeru.Patters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static String url="jdbc:sqlserver://localhost:1521;databaseName=ServiPeru;TrustServerCertificate=true";
    private static String userName = "Administrador";
    private static String password = "8326";
    private static Connection con;

    public static Connection getConexion() throws SQLException {

        con = DriverManager.getConnection(url,userName, password);

        return con;
    }

}
