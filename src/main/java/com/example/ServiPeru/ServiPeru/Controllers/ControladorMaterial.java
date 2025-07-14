package com.example.ServiPeru.ServiPeru.Controllers;

import com.example.ServiPeru.ServiPeru.Model.CategoriaMaterial;
import com.example.ServiPeru.ServiPeru.Model.Materiales;
import com.example.ServiPeru.ServiPeru.Service.IServiceCategoriasMaterialImpl;
import com.example.ServiPeru.ServiPeru.Service.IServiceMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorMaterial {
    @Autowired
    private IServiceCategoriasMaterialImpl serviceCategoriasMaterial;
    @Autowired
    private IServiceMaterial serviceMaterial;

    @GetMapping("/Materiales")
    public String Listar(Model model){
        List<CategoriaMaterial> categorias = new ArrayList<>();
        List<Materiales> Materiales = new ArrayList<>();
        categorias = serviceCategoriasMaterial.Listar();
        Materiales = serviceMaterial.Listar();

        model.addAttribute("listado",categorias);
        model.addAttribute("Materiales",Materiales);

        return "Materiales";
    }

}