package com.example.ServiPeru.ServiPeru.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servicio {
    private int Codigo;
    private int CodEmpresa;
    private String TypServicio;
    private String Fecha;
    private String Lugar;
    private String Supervisor;
    private String TelSupervisor;
    private String Material;
    private String HInicio;
    private String HFinal;
    private int NumOperarios;
    private int Distancia;
    private int Accidentes;
    private int Tarifa;

}
