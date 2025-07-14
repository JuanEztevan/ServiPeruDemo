package com.example.ServiPeru.ServiPeru.Service;

import com.example.ServiPeru.ServiPeru.Model.Contrato;
import com.example.ServiPeru.ServiPeru.Repository.IRepositoryContratos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IServiceContratosImpl implements IServiceContratos{
    @Autowired
    private IRepositoryContratos repositoryContratos;

    @Override
    public List<Contrato> Listar() {
        return null;
    }

    @Override
    public String crear(int Codigo, String FechaConfirmacion, String FechaInicio, String FechaFinal) {
        return repositoryContratos.crear( Codigo,  FechaConfirmacion,  FechaInicio,  FechaFinal);
    }


}
