package com.example.ServiPeru.ServiPeru.Service;

import com.example.ServiPeru.ServiPeru.Model.MaterialUsado;
import com.example.ServiPeru.ServiPeru.Repository.IRepositoryMaterialUsado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IServiceMaterialUsadoImpl implements IServiceMaterialUsado{
    @Autowired
    private IRepositoryMaterialUsado repositoryMaterialUsado;

    @Override
    public List<MaterialUsado> Listar() {
        return null;
    }

    @Override
    public MaterialUsado crear(int cod) {
        return null;
    }

}
