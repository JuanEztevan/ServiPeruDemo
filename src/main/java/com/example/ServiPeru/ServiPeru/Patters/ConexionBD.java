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

public class ConexionBD
{

    private static String url = System.getenv("jdbc:sqlserver://servi-serviperu.database.windows.net:1433;database=ServiPeru;user=Administrador@servi-serviperu;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");  // URL de la base de datos en Azure
    private static String userName = System.getenv("DB_USER"); // Usuario en Azure SQL
    private static String password = System.getenv("DB_PASSWORD"); // Contraseña de la base de datos
    private static Connection con;

    public static Connection getConexion() throws SQLException
    {
        try
        {
            con = DriverManager.getConnection(url, userName, password);
            if (con != null)
            {
                System.out.println("Conexión exitosa");
            }
            return con;
        } catch (SQLException e)
        {
            System.out.println("Falló la conexión");
            e.printStackTrace(); // Para imprimir detalles de la excepción y ayudar en la depuración
        }
        return null;
    }
}
