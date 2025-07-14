package com.example.ServiPeru.ServiPeru.Service;

import com.example.ServiPeru.ServiPeru.Model.Empresas;

import java.util.List;

public interface IServiceEmpresas {
    List<Empresas> Listar();
    String crear(int codigo, String Nombre, String Direccion, String Ciudad, String codPostal, String Telefono, String Correo);

}
