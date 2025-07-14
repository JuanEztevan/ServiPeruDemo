package com.example.ServiPeru.ServiPeru.Service;

import com.example.ServiPeru.ServiPeru.Model.ServicioPorRealizar;

import java.util.List;

public interface IServiceServicioPorRealizar {
    List<ServicioPorRealizar> Listar();
    public String crear(int codigoEmpresa, String tipoServicio, String fechaDeRealizacion, String lugarDeRealizacion);
    public String eliminar(int codigo);

}
