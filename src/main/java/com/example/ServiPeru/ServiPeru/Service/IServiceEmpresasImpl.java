package com.example.ServiPeru.ServiPeru.Service;

import com.example.ServiPeru.ServiPeru.Model.Empresas;
import com.example.ServiPeru.ServiPeru.Repository.IRepositoryEmpresas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IServiceEmpresasImpl implements IServiceEmpresas{
    @Autowired
    private IRepositoryEmpresas repositoryEmpresas;

    @Override
    public List<Empresas> Listar() {
        return repositoryEmpresas.Listar();
    }

    @Override
    public String crear(int codigo, String Nombre, String Direccion, String Ciudad, String codPostal, String Telefono, String Correo) {
        return repositoryEmpresas.crear( codigo, Nombre, Direccion, Ciudad, codPostal, Telefono, Correo);
    }



}
