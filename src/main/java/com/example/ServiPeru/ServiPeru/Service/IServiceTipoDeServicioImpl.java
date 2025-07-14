package com.example.ServiPeru.ServiPeru.Service;

import com.example.ServiPeru.ServiPeru.Model.TipoDeServicio;
import com.example.ServiPeru.ServiPeru.Repository.IRepositoryServicio;
import com.example.ServiPeru.ServiPeru.Repository.IRepositoryTipoDeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IServiceTipoDeServicioImpl implements IServiceTipoDeServicio{
    @Autowired
    private IRepositoryTipoDeServicio repositoryTipoDeServicio;

    @Override
    public List<TipoDeServicio> Listar() {
        return repositoryTipoDeServicio.Listar();
    }

}
