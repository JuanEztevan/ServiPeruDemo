package com.example.ServiPeru.ServiPeru.Controllers;

import com.example.ServiPeru.ServiPeru.Patters.ConexionBD;
import com.example.ServiPeru.ServiPeru.Service.IServiceContratosImpl;
import com.example.ServiPeru.ServiPeru.Service.IServiceEmpresasImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

@Controller
public class ControlEmpresasNew {
    @Autowired
    private IServiceEmpresasImpl serviceEmpresas;
    @Autowired
    private IServiceContratosImpl serviceContratos;
    @PostMapping("/guardar-empresa")
    public String nuevo(@RequestParam String Nombre,
                        @RequestParam String Direccion,
                        @RequestParam String Ciudad,
                        @RequestParam String codPostal,
                        @RequestParam String Telefono,
                        @RequestParam String Correo,
                        @RequestParam String FechaConfirmacion,
                        @RequestParam String FechaInicio,
                        @RequestParam String FechaFinal){
        int codigo = generarCodigoAleatorio();
        String res = serviceEmpresas.crear(codigo,Nombre,Direccion,Ciudad,codPostal,Telefono,Correo);
        String res1 = serviceContratos.crear(codigo,FechaConfirmacion,FechaInicio,FechaFinal);

        if (res.equals("Agregado Correctamente")) {
            return "redirect:/Empresas";
        } else {
            return "redirect:/inicio";
        }
    }
    @PostMapping("/NewEmpre")
    public String nuevaEmpresa(Model model){
        return "AddEmpresas";
    }
    private int generarCodigoAleatorio() {
        // Crear una instancia de la clase Random
        Random random = new Random();
        int codigoGenerado;

        // Intentar generar un código único hasta que se logre
        do {
            try (Connection connection = ConexionBD.getConexion()) {
                // Generar un número aleatorio en el rango de 10000 a 99999
                codigoGenerado = random.nextInt(90000) + 10000;

                // Verificar si el código ya existe en alguna tabla
                if (!codigoYaExisteEnAlgunaTabla(connection, codigoGenerado)) {
                    return codigoGenerado;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } while (true); // Repetir hasta obtener un código único
    }
    private boolean codigoYaExisteEnAlgunaTabla(Connection connection, int codigo) throws SQLException {
        // Ajusta el SQL según la estructura de tu base de datos
        String sql = "SELECT COUNT(*) FROM Empresas WHERE Codigo = ?";

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
