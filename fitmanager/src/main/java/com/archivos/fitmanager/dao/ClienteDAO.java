package com.archivos.fitmanager.dao;

import com.archivos.fitmanager.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author vicente
 */
public class ClienteDAO {

    private Connection conn;

    public ClienteDAO(Connection conn) {
        this.conn = conn;
    }

    // Registrar nuevo cliente
    public boolean registrarClienteCompleto(Cliente cliente) {
        String sqlCliente = "INSERT INTO cliente (nombre, apellido, telefono) VALUES (?, ?, ?) RETURNING id_cliente, fecha_registro";
        String sqlEntrenador = "INSERT INTO entrenador_cliente (id_entrenador, id_cliente) VALUES (?, ?)";
        String sqlMembresia = "INSERT INTO cliente_membresia (id_cliente, id_membresia) VALUES (?, ?)";

        try {
            conn.setAutoCommit(false); // iniciar transacción

            int idCliente;
            // Insertar cliente y obtener id y fecha de registro
            try (PreparedStatement ps = conn.prepareStatement(sqlCliente)) {
                ps.setString(1, cliente.getNombre());
                ps.setString(2, cliente.getApellido());
                ps.setString(3, cliente.getTelefono());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    idCliente = rs.getInt("id_cliente");
                    cliente.setIdCliente(idCliente);
                    cliente.setFechaRegistro(rs.getTimestamp("fecha_registro"));
                } else {
                    conn.rollback();
                    return false;
                }
            }

            // Asignar entrenador si existe
            if (cliente.getIdEntrenador() != null) {
                try (PreparedStatement ps = conn.prepareStatement(sqlEntrenador)) {
                    ps.setInt(1, cliente.getIdEntrenador());
                    ps.setInt(2, idCliente);
                    ps.executeUpdate();
                }
            }

            // Asignar membresía si existe
            if (cliente.getIdMembresia() != null) {
                try (PreparedStatement ps = conn.prepareStatement(sqlMembresia)) {
                    ps.setInt(1, idCliente);
                    ps.setInt(2, cliente.getIdMembresia());
                    ps.executeUpdate();
                }
            }

            conn.commit(); // confirmar transacción
            conn.setAutoCommit(true);
            return true;

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        }
    }
}
