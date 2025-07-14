package com.example.ServiPeru.ServiPeru.Repository;

import com.example.ServiPeru.ServiPeru.Model.Empresas;
import com.example.ServiPeru.ServiPeru.Model.TipoDeServicio;
import com.example.ServiPeru.ServiPeru.Patters.ConexionBD;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntBiFunction;

@Repository
public class IRepositoryTipoDeServicioImpl implements IRepositoryTipoDeServicio{
    @Override
    public List<TipoDeServicio> Listar() {
        String SQL = "select * from TipoDeServicio";

        List<TipoDeServicio> tipe = new ArrayList<>();
        //Da error pero si funcion OJO
        try(Connection con = ConexionBD.getConexion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while (rs.next()){
                TipoDeServicio tipoSer = new TipoDeServicio();
                tipoSer.setTipo(rs.getString(1));
                tipoSer.setTarifa(rs.getInt(2));
                tipoSer.setPagoAOperario(rs.getInt(3));

                tipe.add(tipoSer);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return tipe;
    }

}
