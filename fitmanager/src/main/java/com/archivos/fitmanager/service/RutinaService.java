package com.archivos.fitmanager.service;

import com.archivos.fitmanager.dao.RutinaDAO;
import com.archivos.fitmanager.model.Rutina;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vicente
 */
public class RutinaService {

    private final Connection conn;
    private final RutinaDAO rutinaDAO;

    public RutinaService(Connection conn) {
        this.conn = conn;
        this.rutinaDAO = new RutinaDAO(conn);
    }

    public Rutina crearRutinaConEjercicios(Rutina rutina, List<Integer> ejerciciosIds) throws SQLException {
        // Validar que la rutina tenga al menos 4 ejercicios
        if (ejerciciosIds == null || ejerciciosIds.size() < 4) {
            throw new SQLException("La rutina debe tener al menos 4 ejercicios.");
        }

        try {
            conn.setAutoCommit(false);


            Rutina nueva = rutinaDAO.crearRutina(rutina);

            int orden = 1;
            for (Integer idEjercicio : ejerciciosIds) {
                rutinaDAO.asignarEjercicio(nueva.getIdRutina(), idEjercicio, orden++);
            }

            conn.commit();
            return nueva;
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public int contarRutinasPorCliente(int idCliente) throws SQLException {
        return rutinaDAO.contarPorCliente(idCliente);
    }
}
