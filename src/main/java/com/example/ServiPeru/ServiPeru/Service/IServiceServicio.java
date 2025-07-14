package com.example.ServiPeru.ServiPeru.Service;

import com.example.ServiPeru.ServiPeru.Model.Servicio;

import java.util.List;

public interface IServiceServicio {
    List<Servicio> Listar();
    String crear(int Codigo,int CodEmpresa,String TypServicio,String Fecha,String Lugar,String Supervisor,String TelSupervisor,String Material,String HInicio,String HFinal,int NumOperarios,int Distancia,int Accidentes,int Tarifa);

}
