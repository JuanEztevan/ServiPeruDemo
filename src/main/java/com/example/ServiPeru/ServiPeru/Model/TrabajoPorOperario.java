package com.example.ServiPeru.ServiPeru.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrabajoPorOperario {
    int codigoOperario;
    int codigoServicio;
    int horasTrabajadas;
    int tarifa;
    String Descuento;
    String bono;
}
