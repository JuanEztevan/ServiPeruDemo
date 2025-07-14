package com.example.ServiPeru.ServiPeru.Repository;

import com.example.ServiPeru.ServiPeru.Model.Operarios;

import java.util.List;

public interface IRepositoryOperarios {
    List<Operarios> Listar();
    String crear(int codigoAleatorio, String Nombre, String Apellido, String DNI, String Telefono, String Correo);

}
