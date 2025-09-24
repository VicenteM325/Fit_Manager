package com.archivos.fitmanager.controller;

import com.archivos.fitmanager.dao.EjercicioDAO;
import com.archivos.fitmanager.model.Ejercicio;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vicente
 */
public class EjercicioController {
    private final EjercicioDAO dao;

    public EjercicioController(Connection conn) {
        this.dao = new EjercicioDAO(conn);
    }

    public boolean crearEjercicio(Ejercicio e) throws SQLException {
        return dao.crearEjercicio(e);
    }

    public List<Ejercicio> listarEjercicios() throws SQLException {
        return dao.obtenerEjercicios();
    }

    public Ejercicio obtenerEjercicio(int id) throws SQLException {
        return dao.obtenerEjercicioPorId(id);
    }
}