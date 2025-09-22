package com.archivos.fitmanager.controller;

import com.archivos.fitmanager.dao.MembresiaDAO;
import com.archivos.fitmanager.model.Membresia;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author vicente
 */
public class MembresiaController {

    private MembresiaDAO membresiaDAO;

    public MembresiaController(Connection conn) {
        this.membresiaDAO = new MembresiaDAO(conn);
    }

    public List<Membresia> listarMembresias() {
        return membresiaDAO.listarMembresias();
    }

    public boolean registrarMembresia(int idTipo, double descuento) {
        return membresiaDAO.registrarMembresia(idTipo, descuento);
    }
}
