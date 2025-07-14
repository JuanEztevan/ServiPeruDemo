package com.example.ServiPeru.ServiPeru.Repository;

import com.example.ServiPeru.ServiPeru.Model.Contrato;

import java.util.List;

public interface IRepositoryContratos {
    List<Contrato> Listar();
    String crear(int Codigo, String FechaConfirmacion, String FechaInicio, String FechaFinal);

}
