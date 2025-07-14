package com.example.ServiPeru.ServiPeru.Service;

import com.example.ServiPeru.ServiPeru.Model.Usuario;
import com.example.ServiPeru.ServiPeru.Repository.IRepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IServiceUsuarioImpl implements IServiceUsuario{

    @Autowired
    private IRepositoryUsuario repositoryUsuario;

    @Override
    public String crear(int Codigo, String Usuario, String Contraseña, String Cargo) {
        return repositoryUsuario.crear(Codigo,Usuario,Contraseña,Cargo);
    }
    public Usuario validarUsuario(String usuario, String contraseña) {

        return repositoryUsuario.validarUsuario(usuario, contraseña);
    }

}
