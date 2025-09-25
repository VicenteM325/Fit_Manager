package com.archivos.fitmanager.dao;

import com.archivos.fitmanager.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


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
    
    public List<Cliente> obtenerClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT id_cliente, nombre FROM cliente";

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                clientes.add(c);
            }
        }
        return clientes;
    }

    // Buscar clientes por nombre o apellido
    public List<Cliente> buscarClientesPorNombre(String nombre) throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT id_cliente, nombre, apellido FROM cliente "
                + "WHERE LOWER(nombre) LIKE LOWER(?) OR LOWER(apellido) LIKE LOWER(?) "
                + "ORDER BY nombre LIMIT 10";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + nombre + "%");
            ps.setString(2, "%" + nombre + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre") + " " + rs.getString("apellido"));
                clientes.add(c);
            }
        }
        return clientes;
    }

    public List<Cliente> obtenerClientesPorEntrenador(int idEntrenador) throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = """
        SELECT c.id_cliente, c.nombre, c.apellido, c.telefono
        FROM cliente c
        INNER JOIN entrenador_cliente ec ON c.id_cliente = ec.id_cliente
        WHERE ec.id_entrenador = ?
    """;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idEntrenador);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono")
                );
                clientes.add(c);
            }
        }
        return clientes;
    }
}
