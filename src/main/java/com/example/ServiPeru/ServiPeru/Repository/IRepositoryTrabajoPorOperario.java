package com.example.ServiPeru.ServiPeru.Repository;


import com.example.ServiPeru.ServiPeru.Model.TrabajoPorOperario;

import java.util.List;

public interface IRepositoryTrabajoPorOperario {
    List<TrabajoPorOperario> Listar();
    int crear(TrabajoPorOperario Objeto);
}
