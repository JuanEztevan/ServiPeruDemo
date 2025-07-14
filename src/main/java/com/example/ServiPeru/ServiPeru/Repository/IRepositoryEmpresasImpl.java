package com.example.ServiPeru.ServiPeru.Repository;

import com.example.ServiPeru.ServiPeru.Model.Empresas;
import com.example.ServiPeru.ServiPeru.Patters.ConexionBD;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class IRepositoryEmpresasImpl implements IRepositoryEmpresas{
    @Override
    public List<Empresas> Listar() {
        String SQL = "select * from Empresas";

        List<Empresas> empresa = new ArrayList<>();
        //Da error pero si funcion OJO
        try(Connection con = ConexionBD.getConexion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            ){
            while (rs.next()){
                Empresas emp = new Empresas();
                emp.setCodigo(rs.getInt(1));
                emp.setNombre(rs.getString(2));
                emp.setDireccion(rs.getString(3));
                emp.setCiudad(rs.getString(4));
                emp.setCodPostal(rs.getString(5));
                emp.setTelefono(rs.getString(6));
                emp.setCorreo(rs.getString(7));

                empresa.add(emp);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return empresa;
    }

    @Override
    public String crear(int codigo, String Nombre, String Direccion, String Ciudad, String codPostal, String Telefono, String Correo) {
        int codigoAleatorio = codigo;

        // Modifica este SQL según la estructura de tu tabla
        String sql = "INSERT INTO Empresas (Codigo, Nombre, Direccion, Ciudad, CodigoPostal, Telefono, Correoelectronico) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = ConexionBD.getConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, codigoAleatorio);
            preparedStatement.setString(2, Nombre);
            preparedStatement.setString(3, Direccion);
            preparedStatement.setString(4, Ciudad);
            preparedStatement.setString(5, codPostal);
            preparedStatement.setString(6, Telefono);
            preparedStatement.setString(7, Correo);

            // Ejecutar la inserción
            preparedStatement.executeUpdate();

            return "Agregado Correctamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al agregar el servicio";
        }
    }

}
