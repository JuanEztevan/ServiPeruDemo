package com.example.ServiPeru.ServiPeru.Service;

import com.example.ServiPeru.ServiPeru.Model.CategoriaMaterial;
import com.example.ServiPeru.ServiPeru.Repository.IRepositoryCategoriasMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IServiceCategoriasMaterialImpl implements IServiceCategoriasMaterial{
    @Autowired
    private IRepositoryCategoriasMaterial repositoryCategoriasMaterial;

    @Override
    public List<CategoriaMaterial> Listar() {
        return repositoryCategoriasMaterial.Listar();
    }

}
