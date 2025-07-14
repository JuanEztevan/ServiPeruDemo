package com.example.ServiPeru.ServiPeru.Service;

import com.example.ServiPeru.ServiPeru.Model.MaterialUsado;
import com.example.ServiPeru.ServiPeru.Model.Materiales;
import com.example.ServiPeru.ServiPeru.Model.Servicio;
import com.example.ServiPeru.ServiPeru.Model.ServicioPorRealizar;
import com.example.ServiPeru.ServiPeru.Repository.IRepositoryMaterial;
import com.example.ServiPeru.ServiPeru.Repository.IRepositoryMaterialUsado;
import com.example.ServiPeru.ServiPeru.Repository.IRepositoryServicio;
import com.example.ServiPeru.ServiPeru.Repository.IRepositoryServiciosPorRealizar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class ServiceDashboardImpl implements IServiceDashboard {

    @Autowired
    private IRepositoryMaterial repoMaterial;

    @Autowired
    private IRepositoryMaterialUsado repoMaterialUsado;

    @Autowired
    private IRepositoryServicio repoServicio;

    @Override
    public int obtenerTotalMaterialesEntrada() {
        return repoMaterial.Listar().size();
    }

    @Override
    public int obtenerTotalMaterialesSalida() {
        return repoMaterialUsado.Listar().size();
    }

    @Override
    public int obtenerServiciosCompletados() {
        return repoServicio.Listar().size();
    }

    @Override
    public List<Map<String, String>> obtenerServiciosRecientes() {
        List<Servicio> lista = repoServicio.Listar();
        List<Map<String, String>> recientes = new ArrayList<>();

        // Mostramos solo los 5 últimos (si hay)
        lista.stream()
                .sorted((a, b) -> b.getFecha().compareTo(a.getFecha()))
                .limit(5)
                .forEach(serv -> {
                    Map<String, String> map = new HashMap<>();
                    map.put("Codigo", String.valueOf(serv.getCodigo()));
                    map.put("TipoServicio", serv.getTypServicio());
                    map.put("NombreEmpresa", ""); // Puedes reemplazar esto si accedes a la empresa
                    map.put("FechaDeRealizacion", serv.getFecha());
                    map.put("LugarDeRealizacion", serv.getLugar());
                    recientes.add(map);
                });

        return recientes;
    }
}
