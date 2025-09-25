package com.archivos.fitmanager.controller;

import com.archivos.fitmanager.dao.ClienteDAO;
import com.archivos.fitmanager.model.Cliente;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Cliente> buscarClientesPorNombre(String nombre) throws SQLException {
        if (nombre == null || nombre.isEmpty()) {
            return new ArrayList<>();
        }
        return clienteDAO.buscarClientesPorNombre(nombre);
    }
    
    public List<Cliente> obtenerClientesPorEntrenador(int idEntrenador) throws SQLException {
    return clienteDAO.obtenerClientesPorEntrenador(idEntrenador);
}
}
