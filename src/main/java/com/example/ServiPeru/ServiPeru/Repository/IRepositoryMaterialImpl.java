package com.example.ServiPeru.ServiPeru.Repository;

import com.example.ServiPeru.ServiPeru.Model.Empresas;
import com.example.ServiPeru.ServiPeru.Model.Materiales;
import com.example.ServiPeru.ServiPeru.Patters.ConexionBD;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class IRepositoryMaterialImpl implements IRepositoryMaterial{
    @Override
    public List<Materiales> Listar() {
        String SQL = "select * from Material";

        List<Materiales> materiales = new ArrayList<>();
        //Da error pero si funcion OJO
        try(Connection con = ConexionBD.getConexion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while (rs.next()){
                Materiales mats = new Materiales();
                mats.setCodigo(rs.getInt(1));
                mats.setNombre(rs.getString(2));
                mats.setCant(rs.getInt(3));
                mats.setFechaComp(rs.getString(4));
                mats.setFechaRev(rs.getString(5));

                materiales.add(mats);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return materiales;
    }

    @Override
    public String crear(int codigo,String nombre,int Cant,String FechaComp,String FechaRev) {
        int codigoAleatorio = codigo;

        // Modifica este SQL según la estructura de tu tabla
        String sql = "INSERT INTO Material VALUES (?, ?, ?, ?, ?)";;

        try (Connection connection = ConexionBD.getConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, codigoAleatorio);
            preparedStatement.setString(2, nombre);
            preparedStatement.setInt(3, Cant);
            preparedStatement.setString(4, FechaComp);
            preparedStatement.setString(5, FechaRev);
            // Ejecutar la inserción
            preparedStatement.executeUpdate();
            return "Agregado Correctamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al agregar el servicio";
        }
    }


}
