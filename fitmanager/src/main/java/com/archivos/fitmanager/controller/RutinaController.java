package com.archivos.fitmanager.controller;

import com.archivos.fitmanager.RutinaService;
import com.archivos.fitmanager.model.Rutina;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vicente
 */
public class RutinaController {
    private final RutinaService rutinaService;

    public RutinaController(Connection conn) {
        this.rutinaService = new RutinaService(conn);
    }

    public Rutina crearRutina(int idEntrenador, int idCliente, String nombre, List<Integer> ejerciciosIds) throws SQLException {
        Rutina rutina = new Rutina();
        rutina.setNombre(nombre);
        rutina.setIdEntrenador(idEntrenador);
        rutina.setIdCliente(idCliente);

        return rutinaService.crearRutinaConEjercicios(rutina, ejerciciosIds);
    }
}