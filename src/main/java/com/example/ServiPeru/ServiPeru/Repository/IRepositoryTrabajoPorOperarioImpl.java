package com.example.ServiPeru.ServiPeru.Repository;

import com.example.ServiPeru.ServiPeru.Model.Empresas;
import com.example.ServiPeru.ServiPeru.Model.TipoDeServicio;
import com.example.ServiPeru.ServiPeru.Model.TrabajoPorOperario;
import com.example.ServiPeru.ServiPeru.Patters.ConexionBD;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class IRepositoryTrabajoPorOperarioImpl implements IRepositoryTrabajoPorOperario{
    @Override
    public List<TrabajoPorOperario> Listar() {
        String SQL = "select * from TrabajoPorOperario";

        List<TrabajoPorOperario> TrabajoOp = new ArrayList<>();
        //Da error pero si funcion OJO
        try(Connection con = ConexionBD.getConexion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while (rs.next()){
                TrabajoPorOperario TrabaOp = new TrabajoPorOperario();
                TrabaOp.setCodigoOperario(rs.getInt(1));
                TrabaOp.setCodigoServicio(rs.getInt(2));
                TrabaOp.setHorasTrabajadas(rs.getInt(3));
                TrabaOp.setTarifa(rs.getInt(4));
                TrabaOp.setDescuento(rs.getString(5));
                TrabaOp.setBono(rs.getString(6));

                TrabajoOp.add(TrabaOp);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return TrabajoOp;
    }

    @Override
    public int crear(TrabajoPorOperario Objeto) {
        return 0;
    }

}
