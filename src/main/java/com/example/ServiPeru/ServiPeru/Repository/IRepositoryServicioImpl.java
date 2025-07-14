package com.example.ServiPeru.ServiPeru.Repository;

import com.example.ServiPeru.ServiPeru.Model.Servicio;
import com.example.ServiPeru.ServiPeru.Patters.ConexionBD;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class IRepositoryServicioImpl implements IRepositoryServicio{
    @Override
    public List<Servicio> Listar() {
        String SQL = "select * from Servicio";

        List<Servicio> services = new ArrayList<>();

        try(Connection con = ConexionBD.getConexion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while (rs.next()){
                Servicio serv = new Servicio();
                serv.setCodigo(rs.getInt(1));
                serv.setCodEmpresa(rs.getInt(2));
                serv.setTypServicio(rs.getString(3));
                serv.setFecha(rs.getString(4));
                serv.setLugar(rs.getString(5));
                serv.setSupervisor(rs.getString(6));
                serv.setTelSupervisor(rs.getString(7));
                serv.setMaterial(rs.getString(8));
                serv.setHInicio(rs.getString(9));
                serv.setHFinal(rs.getString(10));
                serv.setNumOperarios(rs.getInt(11));
                serv.setDistancia(rs.getInt(12));
                serv.setAccidentes(rs.getInt(13));
                serv.setTarifa(rs.getInt(14));

                services.add(serv);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return services;
    }

    @Override
    public String crear(int Codigo,int CodEmpresa,String TypServicio,String Fecha,String Lugar,String Supervisor,String TelSupervisor,String Material,String HInicio,String HFinal,int NumOperarios,int Distancia,int Accidentes,int Tarifa) {

        String sql = "INSERT INTO Servicio VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = ConexionBD.getConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, Codigo);
            preparedStatement.setInt(2, CodEmpresa);
            preparedStatement.setString(3, TypServicio);
            preparedStatement.setString(4, Fecha);
            preparedStatement.setString(5, Lugar);
            preparedStatement.setString(6, Supervisor);
            preparedStatement.setString(7, TelSupervisor);
            preparedStatement.setString(8, Material);
            preparedStatement.setString(9, HInicio);
            preparedStatement.setString(10, HFinal);
            preparedStatement.setInt(11, NumOperarios);
            preparedStatement.setInt(12, Distancia);
            preparedStatement.setInt(13, Accidentes);
            preparedStatement.setInt(14, Tarifa);

            // Ejecutar la inserción
            preparedStatement.executeUpdate();

            return "Agregado Correctamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al agregar el servicio";
        }
    }

}
