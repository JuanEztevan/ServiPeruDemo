package com.example.ServiPeru.ServiPeru.Controllers;

import com.example.ServiPeru.ServiPeru.Model.CategoriaMaterial;
import com.example.ServiPeru.ServiPeru.Model.Materiales;
import com.example.ServiPeru.ServiPeru.Model.Operarios;
import com.example.ServiPeru.ServiPeru.Service.IServiceOperariosImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorOperarios {
    @Autowired
    private IServiceOperariosImpl serviceOperarios;

    @GetMapping("/Empleados")
    public String Listar(Model model){
        List<Operarios> operario = new ArrayList<>();
        operario = serviceOperarios.Listar();

        model.addAttribute("listado",operario);

        return "Empleados";
    }
}
