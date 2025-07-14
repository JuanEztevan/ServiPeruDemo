package com.example.ServiPeru.ServiPeru.Repository;

import com.example.ServiPeru.ServiPeru.Model.Contrato;
import com.example.ServiPeru.ServiPeru.Patters.ConexionBD;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class IRepositoryContratosImpl implements IRepositoryContratos{
    @Override
    public List<Contrato> Listar() {
        String SQL = "select * from Contratos";
        List<Contrato> Contratos = new ArrayList<>();
        //Da error pero si funcion OJO
        try(Connection con = ConexionBD.getConexion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while (rs.next()){
                Contrato cont = new Contrato();
                cont.setCodigo(rs.getInt(1));
                cont.setFechaConfirmacion(rs.getInt(2));
                cont.setFechaInicio(rs.getInt(3));
                cont.setFechaFinal(rs.getInt(4));

                Contratos.add(cont);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return Contratos;
    }

    @Override
    public String crear(int Codigo, String FechaConfirmacion, String FechaInicio, String FechaFinal) {
        int codigoAleatorio = Codigo;

        // Modifica este SQL según la estructura de tu tabla
        String sql = "INSERT INTO Contratos VALUES (?, ?, ?, ?, null)";;

        try (Connection connection = ConexionBD.getConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, codigoAleatorio);
            preparedStatement.setString(2, FechaConfirmacion);
            preparedStatement.setString(3, FechaInicio);
            preparedStatement.setString(4, FechaFinal);
            // Ejecutar la inserción
            preparedStatement.executeUpdate();
            return "Agregado Correctamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al agregar el servicio";
        }
    }

}
