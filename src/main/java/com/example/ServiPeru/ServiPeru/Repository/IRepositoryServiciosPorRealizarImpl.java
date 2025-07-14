package com.example.ServiPeru.ServiPeru.Repository;

import com.example.ServiPeru.ServiPeru.Model.ServicioPorRealizar;
import com.example.ServiPeru.ServiPeru.Patters.ConexionBD;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class IRepositoryServiciosPorRealizarImpl implements IRepositoryServiciosPorRealizar{
    @Override
    public List<ServicioPorRealizar> Listar() {
        String SQL = "select * from ServiciosPorRealizar";

        List<ServicioPorRealizar> NewServi = new ArrayList<>();
        //Da error pero si funcion OJO
        try(Connection con = ConexionBD.getConexion();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
        ){
            while (rs.next()){
                ServicioPorRealizar NewS = new ServicioPorRealizar();
                NewS.setCodigo(rs.getInt(1));
                NewS.setCodigoEmpresa(rs.getInt(2));
                NewS.setTipoServicio(rs.getString(3));
                NewS.setFechaDeRealizacion(rs.getString(4));
                NewS.setLugarDeRealizacion(rs.getString(5));

                NewServi.add(NewS);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return NewServi;
    }


    @Override
    public String crear(int codigoEmpresa, String tipoServicio, String fechaDeRealizacion, String lugarDeRealizacion) {
        int codigoAleatorio = generarCodigoAleatorio();

        // Modifica este SQL según la estructura de tu tabla
        String sql = "INSERT INTO ServiciosPorRealizar (Codigo, CodigoDeEmpresa, TipoDeServicio, FechaDeRealizacion, LugarDeRealizacion) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = ConexionBD.getConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, codigoAleatorio);
            preparedStatement.setInt(2, codigoEmpresa);
            preparedStatement.setString(3, tipoServicio);
            preparedStatement.setString(4, fechaDeRealizacion);
            preparedStatement.setString(5, lugarDeRealizacion);

            // Ejecutar la inserción
            preparedStatement.executeUpdate();

            return "Agregado Correctamente";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al agregar el servicio";
        }
    }
    @Override
    public String eliminar(int codigo) {
        String sql = "DELETE FROM ServiciosPorRealizar WHERE codigo = ?";
        try (Connection connection = ConexionBD.getConexion();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, codigo);
            preparedStatement.executeUpdate();

            return "Eliminado";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al eliminar";
        }
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
        String sql = "SELECT COUNT(*) FROM ServiciosPorRealizar WHERE Codigo = ?";

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
