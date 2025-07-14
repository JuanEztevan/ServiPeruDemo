package com.example.ServiPeru.ServiPeru.Service;

import com.example.ServiPeru.ServiPeru.Model.Contrato;

import java.util.List;

public interface IServiceContratos {
    List<Contrato> Listar();
    String crear(int Codigo, String FechaConfirmacion, String FechaInicio, String FechaFinal);

}
