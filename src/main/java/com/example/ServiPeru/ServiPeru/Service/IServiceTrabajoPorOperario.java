package com.example.ServiPeru.ServiPeru.Service;

import com.example.ServiPeru.ServiPeru.Model.TrabajoPorOperario;

import java.util.List;

public interface IServiceTrabajoPorOperario {
    List<TrabajoPorOperario> Listar();
    TrabajoPorOperario crear(int cod);

}
