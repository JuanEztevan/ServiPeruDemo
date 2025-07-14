package com.example.ServiPeru.ServiPeru.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialUsado {
    int  codigo;
    String NombreMaterial;
    int CantidadUsada;
    int CantidadPerdida;
}
