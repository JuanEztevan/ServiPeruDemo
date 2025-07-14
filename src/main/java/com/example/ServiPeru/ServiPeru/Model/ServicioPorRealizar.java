package com.example.ServiPeru.ServiPeru.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicioPorRealizar {
    int Codigo;
    int CodigoEmpresa;
    String TipoServicio;
    String FechaDeRealizacion;
    String LugarDeRealizacion;

}
