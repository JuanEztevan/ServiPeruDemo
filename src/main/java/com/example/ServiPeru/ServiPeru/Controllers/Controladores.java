package com.example.ServiPeru.ServiPeru.Controllers;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.example.ServiPeru.ServiPeru.Service.IServiceDashboard;
import com.example.ServiPeru.ServiPeru.Model.ServicioPorRealizar;
import com.example.ServiPeru.ServiPeru.Repository.IRepositoryServiciosPorRealizar;
import com.example.ServiPeru.ServiPeru.Model.Empresas;
import com.example.ServiPeru.ServiPeru.Service.IServiceEmpresasImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Controladores {
    @Autowired
    private IServiceEmpresasImpl serviceEmpresas;
    @GetMapping("/Empresas")
    public String Listar(Model model){
        List<Empresas> empresa = new ArrayList<>();
        empresa = serviceEmpresas.Listar();

        model.addAttribute("listado",empresa);

        return "Empresas";
    }
    @GetMapping("/Login")
    public String Login(){
        return "Login";
    }
    /*
    @GetMapping("/inicio")
    public String Inicio(){
        return "inicio";
    }
     */

    @Autowired
    private IRepositoryServiciosPorRealizar repoServiciosPorRealizar;

    @GetMapping("/inicio")
    public String Inicio(Model model){
        List<ServicioPorRealizar> servicios = repoServiciosPorRealizar.Listar();
        model.addAttribute("servicios", servicios);

        // Datos ficticios para la gráfica
        model.addAttribute("porcentajeEntrada", 45);
        model.addAttribute("porcentajeSalida", 30);
        model.addAttribute("porcentajeServicios", 25);

        return "inicio";
    }
    @GetMapping("/inicioEmp")
    public  String inicioEmp(){
        return "inicioEmp";
    }

}
