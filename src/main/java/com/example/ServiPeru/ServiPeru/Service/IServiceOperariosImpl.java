package com.example.ServiPeru.ServiPeru.Service;

import com.example.ServiPeru.ServiPeru.Model.Operarios;
import com.example.ServiPeru.ServiPeru.Repository.IRepositoryOperarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IServiceOperariosImpl implements IServiceOperarios{
    @Autowired
    private IRepositoryOperarios repositoryOperarios;

    @Override
    public List<Operarios> Listar() {
        return repositoryOperarios.Listar();
    }

    @Override
    public String crear(int codigoAleatorio, String Nombre, String Apellido, String DNI, String Telefono, String Correo) {
        return repositoryOperarios.crear(codigoAleatorio,Nombre,Apellido,DNI,Telefono,Correo);
    }

}
