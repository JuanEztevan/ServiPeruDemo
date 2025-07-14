package com.example.ServiPeru.ServiPeru.Repository;

import com.example.ServiPeru.ServiPeru.Model.Materiales;

import java.util.List;

public interface IRepositoryMaterial {
    List<Materiales> Listar();
    String crear(int codigo,String nombre,int Cant,String FechaComp,String FechaRev);



}
