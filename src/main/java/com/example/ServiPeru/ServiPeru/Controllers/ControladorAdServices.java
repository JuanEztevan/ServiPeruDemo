package com.example.ServiPeru.ServiPeru.Controllers;

import com.example.ServiPeru.ServiPeru.Model.Empresas;
import com.example.ServiPeru.ServiPeru.Patters.ConexionBD;
import com.example.ServiPeru.ServiPeru.Service.IServiceEmpresasImpl;
import com.example.ServiPeru.ServiPeru.Service.IServiceOperariosImpl;
import com.example.ServiPeru.ServiPeru.Service.IServiceServicioPorRealizarImpl;
import com.example.ServiPeru.ServiPeru.Service.IServiceUsuarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class ControladorAdServices {
    @Autowired
    private IServiceServicioPorRealizarImpl serviceServicioPorRealizar;
    @Autowired
    private IServiceOperariosImpl serviceOperarios;
    @Autowired
    private IServiceUsuarioImpl serviceUsuario;
    @PostMapping("/guardar-servicio")
    public String guardarServicio(@RequestParam int codigoEmpresa,
                                  @RequestParam String tipoServicio,
                                  @RequestParam String fechaDeRealizacion,
                                  @RequestParam String lugarDeRealizacion) {
        // Llama al servicio para guardar el servicio en la base de datos
        String resultado = serviceServicioPorRealizar.crear(codigoEmpresa, tipoServicio, fechaDeRealizacion, lugarDeRealizacion);

        // Redirige a una página de éxito o maneja el resultado según tu lógica
        if (resultado.equals("Agregado Correctamente")) {
            return "redirect:/Servicios";
        } else {
            return "redirect:/inicio";
        }
    }
    @PostMapping("/guardar-Empleado")
    public String guardarOpUs(@RequestParam String NombreOp,
                              @RequestParam String Apellido,
                              @RequestParam String DNI,
                              @RequestParam String Telefono,
                              @RequestParam String Correo,
                              @RequestParam String Usuario,
                              @RequestParam String Contraseña,
                              @RequestParam String Cargo
                              ) {

        // Llama al servicio para guardar el servicio en la base de datos
        int codigo = generarCodigoAleatorio();

        String res = serviceOperarios.crear(codigo,NombreOp,Apellido,DNI,Telefono,Correo);
        String res1 = serviceUsuario.crear(codigo,Usuario,Contraseña,Cargo);


        if (res.equals("Agregado Correctamente")) {
            return "redirect:/Empleados";
        } else {
            return "redirect:/inicio";
        }

    }

    private int generarCodigoAleatorio() {
        // Crear una instancia de la clase Random
        Random random = new Random();
        int codigoGenerado;
        
        do {
            try (Connection connection = ConexionBD.getConexion()) {

                codigoGenerado = random.nextInt(90000) + 15000;

                if (!codigoYaExisteEnAlgunaTabla(connection, codigoGenerado)) {
                    return codigoGenerado;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } while (true);
    }
    private boolean codigoYaExisteEnAlgunaTabla(Connection connection, int codigo) throws SQLException {
        // Ajusta el SQL según la estructura de tu base de datos
        String sql = "SELECT COUNT(*) FROM Operarios WHERE Codigo = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, codigo);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }

        return false;
    }
}
