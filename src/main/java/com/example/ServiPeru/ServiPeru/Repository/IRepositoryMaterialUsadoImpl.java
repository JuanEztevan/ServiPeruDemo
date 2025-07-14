package com.example.ServiPeru.ServiPeru.Repository;

import com.example.ServiPeru.ServiPeru.Model.CategoriaMaterial;
import com.example.ServiPeru.ServiPeru.Model.Empresas;
import com.example.ServiPeru.ServiPeru.Model.MaterialUsado;
import com.example.ServiPeru.ServiPeru.Patters.ConexionBD;
import org.springframework.stereotype.Repository;

import java.lang.invoke.CallSite;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class IRepositoryMaterialUsadoImpl implements IRepositoryMaterialUsado{
    @Override
    public List<MaterialUsado> Listar() {
        String SQL = "select * from MaterialUsado";
        List<MaterialUsado> MatUsado = new ArrayList<>();
        //Da error pero si funcion OJO
        try(Connection con = ConexionBD.getConexion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while (rs.next()){
                MaterialUsado MatU = new MaterialUsado();
                MatU.setCodigo(rs.getInt(1));
                MatU.setNombreMaterial(rs.getString(2));
                MatU.setCantidadUsada(rs.getInt(3));
                MatU.setCantidadPerdida(rs.getInt(4));

                MatUsado.add(MatU);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return MatUsado;
    }

    @Override
    public int crear(MaterialUsado Objeto) {
        return 0;
    }

}
