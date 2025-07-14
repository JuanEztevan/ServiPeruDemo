package com.example.ServiPeru.ServiPeru.Controllers;

import com.example.ServiPeru.ServiPeru.Model.Empresas;
import com.example.ServiPeru.ServiPeru.Model.Servicio;
import com.example.ServiPeru.ServiPeru.Model.ServicioPorRealizar;
import com.example.ServiPeru.ServiPeru.Model.TipoDeServicio;
import com.example.ServiPeru.ServiPeru.Service.IServiceEmpresasImpl;
import com.example.ServiPeru.ServiPeru.Service.IServiceServicioImpl;
import com.example.ServiPeru.ServiPeru.Service.IServiceServicioPorRealizar;
import com.example.ServiPeru.ServiPeru.Service.IServiceTipoDeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.ArrayList;
import java.util.List;
@Controller
public class ControlAdServicios {
    @Autowired
    private IServiceServicioImpl serviceServicio;
    @Autowired
    private IServiceServicioPorRealizar serviceServicioPorRealizar;

    @GetMapping("/ServiciosAd")
    public String Listar(Model model){
        List<ServicioPorRealizar> porRealizars = new ArrayList<>();
        List<Servicio> servicios = new ArrayList<>();

        porRealizars = serviceServicioPorRealizar.Listar();
        servicios = serviceServicio.Listar();

        model.addAttribute("ServiciosPor",porRealizars);
        model.addAttribute("listado",servicios);

        return "ServiciosAd";
    }
    @Autowired
    private IServiceEmpresasImpl serviceEmpresas;
    @Autowired
    private IServiceTipoDeServicio tiposDeServicio;
    @PostMapping("/NewService1")
    public String nuevo(Model model){

        List<TipoDeServicio> tipos = new ArrayList<>();
        List<Empresas> empresas = new ArrayList<>();

        empresas = serviceEmpresas.Listar();
        tipos= tiposDeServicio.Listar();

        model.addAttribute("tiposDeServicio", tipos);
        model.addAttribute("empresas", empresas);

        return "AddServicesAd";
    }
    @PostMapping("/NewOp")
    public String nuevoOp(Model model){

        return "AddEmpleado";
    }
}
