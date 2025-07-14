package com.example.ServiPeru.ServiPeru.Repository;

import com.example.ServiPeru.ServiPeru.Model.CategoriaMaterial;
import com.example.ServiPeru.ServiPeru.Model.Empresas;
import com.example.ServiPeru.ServiPeru.Patters.ConexionBD;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Repository
public class IRepositoryCategoriasMaterialImpl implements IRepositoryCategoriasMaterial {
    @Override
    public List<CategoriaMaterial> Listar() {
        String SQL = "SELECT [Codigo de categoria],[Nombre de categoria],Ejemplos from CategoriaDeMaterial";
        List<CategoriaMaterial> categoria = new ArrayList<>();

        try(Connection con = ConexionBD.getConexion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while (rs.next()){
                CategoriaMaterial cat = new CategoriaMaterial();
                cat.setCodigo(rs.getInt(1));
                cat.setNombreCategoria(rs.getString(2));
                cat.setEjemplos(rs.getString(3));

                categoria.add(cat);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return categoria;
    }

}
