package com.example.ServiPeru.ServiPeru.Service;

import com.example.ServiPeru.ServiPeru.Model.Materiales;
import com.example.ServiPeru.ServiPeru.Repository.IRepositoryMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IServiceMaterialImpl implements IServiceMaterial{
    @Autowired
    private IRepositoryMaterial repositoryMaterial;

    @Override
    public List<Materiales> Listar() {
        return repositoryMaterial.Listar();
    }

    @Override
    public String crear(int codigo,String nombre,int Cant,String FechaComp,String FechaRev) {
        return repositoryMaterial.crear(codigo,nombre,Cant,FechaComp,FechaRev);
    }

}
