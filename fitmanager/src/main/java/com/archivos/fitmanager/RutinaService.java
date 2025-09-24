package com.archivos.fitmanager;

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
        try {
            conn.setAutoCommit(false);

            // Crear la rutina
            Rutina nueva = rutinaDAO.crearRutina(rutina);

            // Asignar los ejercicios con orden incremental
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
}
