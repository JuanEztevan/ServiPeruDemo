//package com.example.ServiPeru.ServiPeru.Patters;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

//public class ConexionBD {

//    private static String url="jdbc:sqlserver://localhost:1521;databaseName=ServiPeru;TrustServerCertificate=true";
//    private static String userName = "Administrador";
//    private static String password = "8326";
//    private static Connection con;

//    public static Connection getConexion() throws SQLException {

  //      con = DriverManager.getConnection(url,userName, password);

    //    return con;
   // }

//}

package com.example.ServiPeru.ServiPeru.Patters;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Azure SQL usa el puerto 1433 y requiere usuario completo con @nombreServidor
    private static String url = "jdbc:sqlserver://servi-serviperu.database.windows.net:1433;database=ServiPeru;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    private static String userName = "Administrador@servi-serviperu";
    private static String password = "J71126785j";
    private static Connection con;

    public static Connection getConexion() throws SQLException {
        try {
            con = DriverManager.getConnection(url, userName, password);
            if (con != null) {
                System.out.println("Conexión exitosa a Azure SQL");
            }
            return con;
        } catch (SQLException e) {
            System.out.println("Fallo la conexión a Azure SQL: " + e.getMessage());
            throw e;
        }
    }
}
