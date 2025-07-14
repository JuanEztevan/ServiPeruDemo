package com.example.ServiPeru.ServiPeru.Repository;

import com.example.ServiPeru.ServiPeru.Model.Empresas;
import com.example.ServiPeru.ServiPeru.Model.Usuario;
import com.example.ServiPeru.ServiPeru.Patters.ConexionBD;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class IRepositoryUsuarioImpl implements IRepositoryUsuario{


    @Override
    public String crear(int Codigo, String Usuario, String Contraseña, String Cargo) {
        // Modifica este SQL según la estructura de tu tabla
        String sql = "INSERT INTO Usuarios (Codigo, Usuario, Contraseña, Cargo) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection connection = ConexionBD.getConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, Codigo);
            preparedStatement.setString(2, Usuario);
            preparedStatement.setString(3, Contraseña);
            preparedStatement.setString(4, Cargo);
            // Ejecutar la inserción
            preparedStatement.executeUpdate();

            return "Agregado Correctamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al agregar el servicio";
        }
    }

    public Usuario validarUsuario(String usuario, String contraseña) {
        String SQL = "SELECT * FROM Usuarios WHERE Usuario = '" + usuario + "' AND Contraseña = '" + contraseña + "'";

        try (Connection con = ConexionBD.getConexion();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                // Usuario y contraseña válidos, guardamos información adicional
                Usuario usuarioValidado = new Usuario();
                usuarioValidado.setId(rs.getInt(1));
                usuarioValidado.setCodigo(rs.getInt(2));
                usuarioValidado.setUsuario(rs.getString(3));
                usuarioValidado.setPassword(rs.getString(4));
                usuarioValidado.setCargo(rs.getString(5));

                return usuarioValidado;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
