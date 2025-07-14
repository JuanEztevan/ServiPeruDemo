package com.example.ServiPeru.ServiPeru.Service;

import com.example.ServiPeru.ServiPeru.Model.TrabajoPorOperario;
import com.example.ServiPeru.ServiPeru.Repository.IRepositoryTrabajoPorOperario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IServiceTrabajoPorOperarioImpl implements IServiceTrabajoPorOperario{
    @Autowired
    private IRepositoryTrabajoPorOperario repositoryTrabajoPorOperario;

    @Override
    public List<TrabajoPorOperario> Listar() {
        return null;
    }

    @Override
    public TrabajoPorOperario crear(int cod) {
        return null;
    }

}
