package com.archivos.fitmanager.controller;

import com.archivos.fitmanager.dao.AsistenciaDAO;
import com.archivos.fitmanager.model.Asistencia;
import java.sql.SQLException;
import java.sql.Timestamp;
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
}
