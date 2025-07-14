package com.example.ServiPeru.ServiPeru.Controllers;

import com.example.ServiPeru.ServiPeru.Model.ServicioPorRealizar;
import com.example.ServiPeru.ServiPeru.Service.IServiceServicioImpl;
import com.example.ServiPeru.ServiPeru.Service.IServiceServicioPorRealizarImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControlNewService {
    @Autowired
    public IServiceServicioPorRealizarImpl serviceServicioPorRealizar;
    @Autowired
    public IServiceServicioImpl serviceServicio;

    @PostMapping("/editar")
    public String nuevos(@RequestParam int codigo,
                        @RequestParam int codigoEmpresa,
                        @RequestParam String tipoServicio,
                        @RequestParam String fechaRealizacion,
                        @RequestParam String lugarRealizacion,
                        @RequestParam String Supervisor,
                        @RequestParam String TelefonoSup,
                        @RequestParam String Material,
                        @RequestParam String HoraIni,
                        @RequestParam String Horafina,
                        @RequestParam int NumOperarios,
                        @RequestParam int Distancia,
                        @RequestParam int Accidentes,
                        @RequestParam int Tarifa){
        serviceServicioPorRealizar.eliminar(codigo);
        String res = serviceServicio.crear(codigo,codigoEmpresa,tipoServicio,fechaRealizacion,lugarRealizacion,Supervisor,TelefonoSup,Material,HoraIni,Horafina,NumOperarios,Distancia,Accidentes,Tarifa);

        if (res.equals("Agregado Correctamente")) {
            return "redirect:/Servicios";
        } else {
            return "redirect:/inicio";
        }
    }
}
