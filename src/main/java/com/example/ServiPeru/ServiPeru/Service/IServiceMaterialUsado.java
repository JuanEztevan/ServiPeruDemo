package com.example.ServiPeru.ServiPeru.Service;

import com.example.ServiPeru.ServiPeru.Model.MaterialUsado;

import java.util.List;

public interface IServiceMaterialUsado {
    List<MaterialUsado> Listar();
    MaterialUsado crear(int cod);

}
