package com.archivos.fitmanager.controller;

import com.archivos.fitmanager.dao.ClienteDAO;
import com.archivos.fitmanager.model.Cliente;
import java.sql.Connection;

/**
 *
 * @author vicente
 */
public class ClienteController {
    private ClienteDAO clienteDAO;

    public ClienteController(Connection conn) {
        this.clienteDAO = new ClienteDAO(conn);
    }


    // Registrar cliente completo: asignar entrenador y membresía
    public boolean registrarClienteCompleto(String nombre, String apellido, String telefono,
            Integer idEntrenador, Integer idMembresia) {
        if (nombre == null || nombre.isEmpty()
                || apellido == null || apellido.isEmpty()
                || telefono == null || telefono.isEmpty()) {
            return false; // Validación simple
        }

        Cliente cliente = new Cliente(nombre, apellido, telefono, idEntrenador, idMembresia);
        return clienteDAO.registrarClienteCompleto(cliente);
    }
}
