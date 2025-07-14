package com.example.ServiPeru.ServiPeru.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contrato {
    int  codigo;
    int FechaConfirmacion;
    int FechaInicio;
    int FechaFinal;
}
