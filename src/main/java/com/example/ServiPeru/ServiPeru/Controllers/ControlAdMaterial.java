package com.example.ServiPeru.ServiPeru.Controllers;

import com.example.ServiPeru.ServiPeru.Model.CategoriaMaterial;
import com.example.ServiPeru.ServiPeru.Model.Materiales;
import com.example.ServiPeru.ServiPeru.Service.IServiceCategoriasMaterialImpl;
import com.example.ServiPeru.ServiPeru.Service.IServiceMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Controller
public class ControlAdMaterial {
    @Autowired
    private IServiceCategoriasMaterialImpl serviceCategoriasMaterial;
    @Autowired
    private IServiceMaterial serviceMaterial;

    @GetMapping("/MaterialesAd")
    public String Listar(Model model){
        List<CategoriaMaterial> categorias = new ArrayList<>();
        List<Materiales> Materiales = new ArrayList<>();
        categorias = serviceCategoriasMaterial.Listar();
        Materiales = serviceMaterial.Listar();

        model.addAttribute("listado",categorias);
        model.addAttribute("Materiales",Materiales);

        return "MaterialesAd";
    }
    @PostMapping("/NewMat")
    public String nuevoMaterial(Model model){
        return "AddMaterial";
    }
    @PostMapping("/guardar-material")
    public String AgregarMaterial(@RequestParam int categoria,
                                  @RequestParam String Nombre,
                                  @RequestParam int Cantidad,
                                  @RequestParam String FechaComp,
                                  @RequestParam String FechaRev){
        String res = serviceMaterial.crear(categoria,Nombre,Cantidad,FechaComp,FechaRev);

        if (res.equals("Agregado Correctamente")) {
            return "redirect:/Materiales";
        } else {
            return "redirect:/inicio";
        }

    }
}
