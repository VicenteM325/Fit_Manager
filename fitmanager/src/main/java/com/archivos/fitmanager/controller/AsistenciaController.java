package com.archivos.fitmanager.controller;

import com.archivos.fitmanager.dao.AsistenciaDAO;
import com.archivos.fitmanager.model.Asistencia;
import com.archivos.fitmanager.model.AsistenciaHistorial;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vicente
 */
public class AsistenciaController {
    private AsistenciaDAO asistenciaDAO;

    public AsistenciaController() {
        this.asistenciaDAO = new AsistenciaDAO();
    }

    public void registrarAsistencia(int idCliente, int idSucursal) throws SQLException {
        Asistencia asistencia = new Asistencia();
        asistencia.setFechaHora(new Timestamp(System.currentTimeMillis()));
        asistencia.setIdCliente(idCliente);
        asistencia.setIdSucursal(idSucursal);

        asistenciaDAO.registrarAsistencia(asistencia);
    }

    public List<Asistencia> obtenerAsistencias() {
        try {
            return asistenciaDAO.obtenerAsistencias();
        } catch (SQLException e) {
            System.err.println("Error obteniendo asistencias: " + e.getMessage());
            return null;
        }
    }

    public List<String> obtenerClientesConAsistencias() {
        try {
            return asistenciaDAO.obtenerClientesConAsistencias();
        } catch (SQLException e) {
            System.err.println("Error obteniendo lista de clientes: " + e.getMessage());
            return null;
        }
    }

    public List<AsistenciaHistorial> historialPorCliente(int idCliente) throws SQLException {
        List<Asistencia> asistencias = asistenciaDAO.obtenerAsistenciasPorCliente(idCliente);
        List<AsistenciaHistorial> historial = new ArrayList<>();

        for (Asistencia a : asistencias) {
            historial.add(new AsistenciaHistorial(
                    (int) a.getIdAsistencia(),
                    a.getIdCliente(),
                    "Cliente " + a.getIdCliente(), 
                    a.getFechaHora(),
                    "Sucursal " + a.getIdSucursal()
            ));
        }
        return historial;
    }

    public List<AsistenciaHistorial> historialPorEntrenador(int idEntrenador) throws SQLException {
        return asistenciaDAO.obtenerHistorialPorEntrenador(idEntrenador);
    }
    
    
}
