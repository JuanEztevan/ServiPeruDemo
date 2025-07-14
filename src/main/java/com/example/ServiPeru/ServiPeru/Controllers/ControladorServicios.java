package com.example.ServiPeru.ServiPeru.Controllers;

import com.example.ServiPeru.ServiPeru.Model.*;
import com.example.ServiPeru.ServiPeru.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;
@Controller
public class ControladorServicios {
    @Autowired
    private IServiceServicioImpl serviceServicio;
    @Autowired
    private IServiceServicioPorRealizar serviceServicioPorRealizar;

    @GetMapping("/Servicios")
    public String Listar(Model model){
        List<ServicioPorRealizar> porRealizars = new ArrayList<>();
        List<Servicio> servicios = new ArrayList<>();

        porRealizars = serviceServicioPorRealizar.Listar();
        servicios = serviceServicio.Listar();

        model.addAttribute("ServiciosPor",porRealizars);
        model.addAttribute("listado",servicios);

        return "Servicios";
    }
    @Autowired
    private IServiceEmpresasImpl serviceEmpresas;
    @Autowired
    private IServiceTipoDeServicio tiposDeServicio;
    @PostMapping("/NewService")
    public String nuevo(Model model){

        List<TipoDeServicio> tipos = new ArrayList<>();
        List<Empresas> empresas = new ArrayList<>();

        empresas = serviceEmpresas.Listar();
        tipos= tiposDeServicio.Listar();

        model.addAttribute("tiposDeServicio", tipos);
        model.addAttribute("empresas", empresas);

        return "AddServices";
    }
}
