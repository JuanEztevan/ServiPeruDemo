package com.example.ServiPeru.ServiPeru.Service;

import java.util.List;
import java.util.Map;

public interface IServiceDashboard {
    int obtenerTotalMaterialesEntrada();
    int obtenerTotalMaterialesSalida();
    int obtenerServiciosCompletados();
    List<Map<String, String>> obtenerServiciosRecientes();
}
