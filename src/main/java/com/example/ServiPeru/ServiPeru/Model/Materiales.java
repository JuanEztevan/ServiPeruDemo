package com.example.ServiPeru.ServiPeru.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Materiales {
    private int codigo;
    private String nombre;
    private int Cant;
    private String FechaComp;
    private String FechaRev;

}
