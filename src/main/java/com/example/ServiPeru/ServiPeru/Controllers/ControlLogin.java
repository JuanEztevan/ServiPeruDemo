package com.example.ServiPeru.ServiPeru.Controllers;

import com.example.ServiPeru.ServiPeru.Model.Usuario;
import com.example.ServiPeru.ServiPeru.Service.IServiceUsuarioImpl;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ControlLogin {
    @Autowired
    private IServiceUsuarioImpl serviceUsuario;

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String usuario, @RequestParam String contraseña, Model model) {
        // Validar el usuario y la contraseña en el servicio
        Usuario usuarioValidado = serviceUsuario.validarUsuario(usuario, contraseña);

        if (usuarioValidado != null) {

            model.addAttribute("cargo", usuarioValidado.getCargo());
            String cargo = usuarioValidado.getCargo();
            // Redirige según el cargo del usuario
            if ("Empleados".equals(usuarioValidado.getCargo())) {
                System.out.println(cargo);
                return "redirect:/inicioEmp";
            } else if ("Administracion".equals(usuarioValidado.getCargo())) {
                System.out.println(cargo);
                return "redirect:/inicioAd";
            }  else if ("Dueño".equals(usuarioValidado.getCargo())) {
                System.out.println(cargo);
                return "redirect:/inicio";
            }  else if ("Desarrollador".equals(usuarioValidado.getCargo())) {
                System.out.println(cargo);
                return "redirect:/inicio";
            }else {
                // Cargo no reconocido, redirige a una página por defecto
                return "redirect:/default";
            }
        } else {
            // Agrega un mensaje de error al modelo y vuelve a la página de login
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }
}
