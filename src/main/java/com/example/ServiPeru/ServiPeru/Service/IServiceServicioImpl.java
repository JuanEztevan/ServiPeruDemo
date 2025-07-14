package com.example.ServiPeru.ServiPeru.Service;

import com.example.ServiPeru.ServiPeru.Model.Servicio;
import com.example.ServiPeru.ServiPeru.Repository.IRepositoryServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IServiceServicioImpl implements IServiceServicio{
    @Autowired
    private IRepositoryServicio repositoryServicio;

    @Override
    public List<Servicio> Listar() {
        return repositoryServicio.Listar();
    }

    @Override
    public String crear(int Codigo,int CodEmpresa,String TypServicio,String Fecha,String Lugar,String Supervisor,String TelSupervisor,String Material,String HInicio,String HFinal,int NumOperarios,int Distancia,int Accidentes,int Tarifa) {
        return repositoryServicio.crear(Codigo,CodEmpresa,TypServicio,Fecha,Lugar,Supervisor,TelSupervisor,Material,HInicio,HFinal,NumOperarios,Distancia,Accidentes,Tarifa);
    }


}
