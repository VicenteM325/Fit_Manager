package com.archivos.fitmanager.controller;

import com.archivos.fitmanager.service.RutinaService;
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
        if (ejerciciosIds == null || ejerciciosIds.size() < 4) {
            throw new IllegalArgumentException("Una rutina debe contener al menos 4 ejercicios.");
        }

        int cantidadRutinas = rutinaService.contarRutinasPorCliente(idCliente);
        if (cantidadRutinas >= 5) {
            throw new IllegalStateException("El cliente ya tiene 5 rutinas asignadas.");
        }

        Rutina rutina = new Rutina();
        rutina.setNombre(nombre);
        rutina.setIdEntrenador(idEntrenador);
        rutina.setIdCliente(idCliente);

        return rutinaService.crearRutinaConEjercicios(rutina, ejerciciosIds);
    }
}