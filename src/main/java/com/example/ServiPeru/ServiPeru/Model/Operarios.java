package com.example.ServiPeru.ServiPeru.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Operarios {
    private int Codigo;
    private String Nombre;
    private String Apellido;
    private String DNI;
    private String Telefono;
    private String Correo;

}
