package com.example.ServiPeru.ServiPeru.Repository;

import com.example.ServiPeru.ServiPeru.Model.CategoriaMaterial;
import com.example.ServiPeru.ServiPeru.Model.MaterialUsado;

import java.util.List;

public interface IRepositoryMaterialUsado {
    List<MaterialUsado> Listar();
    int crear(MaterialUsado Objeto);

}
