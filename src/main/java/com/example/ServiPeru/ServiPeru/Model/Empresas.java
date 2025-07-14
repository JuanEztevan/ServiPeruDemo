package com.example.ServiPeru.ServiPeru.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Empresas {
    private int codigo;
    private String Nombre;
    private String Direccion;
    private String Ciudad;
    private String codPostal;
    private String Telefono;
    private String Correo;

}
