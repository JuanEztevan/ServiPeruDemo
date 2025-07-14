package com.example.ServiPeru.ServiPeru.Repository;

import com.example.ServiPeru.ServiPeru.Model.Usuario;

import java.util.List;

public interface IRepositoryUsuario {
    String crear(int Codigo, String Usuario, String Contraseña, String Cargo);
    Usuario validarUsuario(String usuario, String contraseña);

}
