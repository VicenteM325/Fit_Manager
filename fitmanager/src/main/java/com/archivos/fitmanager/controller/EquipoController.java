package com.archivos.fitmanager.controller;

import com.archivos.fitmanager.dao.EquipoDAO;
import com.archivos.fitmanager.model.Equipo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vicente
 */
public class EquipoController {
    private final EquipoDAO equipoDAO;

    public EquipoController(Connection conn) {
        this.equipoDAO = new EquipoDAO(conn);
    }

    public void crearEquipo(String nombre, String estado, Integer idSucursal) throws SQLException {
        Equipo equipo = new Equipo();
        equipo.setNombre(nombre);
        equipo.setEstado(estado);
        equipo.setIdSucursal(idSucursal);
        equipoDAO.insertarEquipo(equipo);
    }

    public List<Equipo> obtenerEquipos() throws SQLException {
        return equipoDAO.listarEquipos();
    }

}