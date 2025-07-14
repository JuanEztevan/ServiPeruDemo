/*package com.example.ServiPeru.ServiPeru.Controllers;

import com.example.ServiPeru.ServiPeru.Service.IServiceServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorModificarServ {
    @Autowired
    private IServiceServicioImpl serviceServicio;

    @PostMapping("/ModificarServicio")
    public String modificarServicio(@RequestParam int codigo,
                                    @RequestParam int codigoEmpresa,
                                    @RequestParam String tipoServicio,
                                    @RequestParam String fechaRealizacion,
                                    @RequestParam String lugarRealizacion,
                                    Model model) {

        // Agrega los datos al modelo para que estén disponibles en la página Thymeleaf
        model.addAttribute("codigo", codigo);
        model.addAttribute("codigoEmpresa", codigoEmpresa);
        model.addAttribute("tipoServicio", tipoServicio);
        model.addAttribute("fechaRealizacion", fechaRealizacion);
        model.addAttribute("lugarRealizacion", lugarRealizacion);

        // Redirige a la página "EditServices"
        return "EditServices";
    }


}


 */

package com.example.ServiPeru.ServiPeru.Controllers;

import com.example.ServiPeru.ServiPeru.Model.Materiales;
import com.example.ServiPeru.ServiPeru.Service.IServiceMaterialImpl;
import com.example.ServiPeru.ServiPeru.Service.IServiceServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControladorModificarServ {

    @Autowired
    private IServiceServicioImpl serviceServicio;

    @Autowired
    private IServiceMaterialImpl serviceMaterial;

    @PostMapping("/ModificarServicio")
    public String modificarServicio(@RequestParam int codigo,
                                    @RequestParam int codigoEmpresa,
                                    @RequestParam String tipoServicio,
                                    @RequestParam String fechaRealizacion,
                                    @RequestParam String lugarRealizacion,
                                    Model model) {

        // Datos del servicio a modificar
        model.addAttribute("codigo", codigo);
        model.addAttribute("codigoEmpresa", codigoEmpresa);
        model.addAttribute("tipoServicio", tipoServicio);
        model.addAttribute("fechaRealizacion", fechaRealizacion);
        model.addAttribute("lugarRealizacion", lugarRealizacion);

        // Lista de materiales disponibles
        List<Materiales> materiales = serviceMaterial.Listar();
        model.addAttribute("materialesDisponibles", materiales);

        // Redirige a la página EditService.html (revisa que el nombre esté bien)
        return "EditServices";
    }
}
