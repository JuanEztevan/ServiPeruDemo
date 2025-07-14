package com.example.ServiPeru.ServiPeru.Service;

import com.example.ServiPeru.ServiPeru.Model.ServicioPorRealizar;
import com.example.ServiPeru.ServiPeru.Repository.IRepositoryServiciosPorRealizar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IServiceServicioPorRealizarImpl implements IServiceServicioPorRealizar{
    @Autowired
    private IRepositoryServiciosPorRealizar repositoryServiciosPorRealizar;

    @Override
    public List<ServicioPorRealizar> Listar() {
        return repositoryServiciosPorRealizar.Listar();
    }

    @Override
    public String crear(int codigoEmpresa, String tipoServicio, String fechaDeRealizacion, String lugarDeRealizacion) {
        return repositoryServiciosPorRealizar.crear( codigoEmpresa,tipoServicio, fechaDeRealizacion,lugarDeRealizacion);
    }
    @Override
    public String eliminar(int codigo){
        return repositoryServiciosPorRealizar.eliminar(codigo);
    }
}
