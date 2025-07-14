package com.example.ServiPeru.ServiPeru.Repository;

import com.example.ServiPeru.ServiPeru.Model.Materiales;
import com.example.ServiPeru.ServiPeru.Model.Operarios;
import com.example.ServiPeru.ServiPeru.Patters.ConexionBD;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class IRepositoryOperariosImpl implements IRepositoryOperarios{
    @Override
    public List<Operarios> Listar() {
        String SQL = "select * from Operarios";
        List<Operarios> operario = new ArrayList<>();
        //Da error pero si funcion OJO
        try(Connection con = ConexionBD.getConexion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while (rs.next()){
                Operarios op = new Operarios();
                op.setCodigo(rs.getInt(1));
                op.setNombre(rs.getString(2));
                op.setApellido(rs.getString(3));
                op.setDNI(rs.getString(4));
                op.setTelefono(rs.getString(5));
                op.setCorreo(rs.getString(6));

                operario.add(op);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return operario;
    }

    @Override
    public String crear(int Codigo, String Nombre, String Apellido, String DNI, String Telefono, String Correo) {
        int codigoAleatorio = Codigo;

        String sql = "INSERT INTO Operarios (Codigo, Nombres, Apellidos, DNI, Telefono, Correoelectronico, foto) " +
                "VALUES (?, ?, ?, ?, ?, ?, null)";
        try (Connection connection = ConexionBD.getConexion();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, codigoAleatorio);
            preparedStatement.setString(2, Nombre);
            preparedStatement.setString(3, Apellido);
            preparedStatement.setString(4, DNI);
            preparedStatement.setString(5, Telefono);
            preparedStatement.setString(6, Correo);

            // Ejecutar la inserción
            preparedStatement.executeUpdate();

            return "Agregado Correctamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al agregar el servicio";
        }
    }
}
