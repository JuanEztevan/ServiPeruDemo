package com.example.ServiPeru.ServiPeru.Controllers;

import com.example.ServiPeru.ServiPeru.Model.Empresas;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorEmpo {

    @GetMapping("/ServiciosEmp")
    public String serviemp(){
        return "ServiciosEmp";
    }
    @GetMapping("/PagosEmp")
    public String pagoEmp(){
        return "PagosEmp";
    }
}
