package com.archivos.fitmanager.dao;

import com.archivos.fitmanager.db.DBConfig;
import com.archivos.fitmanager.model.Asistencia;
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
public class AsistenciaDAO {

    public void registrarAsistencia(Asistencia asistencia) throws SQLException {
        String sql = "INSERT INTO fitmanager.asistencia (fecha_hora, id_cliente, id_sucursal) VALUES (?, ?, ?)";

        try (Connection conn = DBConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTimestamp(1, asistencia.getFechaHora());
            stmt.setInt(2, asistencia.getIdCliente());
            stmt.setInt(3, asistencia.getIdSucursal());
            stmt.executeUpdate();
        }
    }

    public List<Asistencia> obtenerAsistencias() throws SQLException {
        List<Asistencia> asistencias = new ArrayList<>();
        String sql = "SELECT * FROM fitmanager.asistencia ORDER BY fecha_hora DESC";

        try (Connection conn = DBConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Asistencia a = new Asistencia();
                a.setIdAsistencia(rs.getLong("id_asistencia"));
                a.setFechaHora(rs.getTimestamp("fecha_hora"));
                a.setIdCliente(rs.getInt("id_cliente"));
                a.setIdSucursal(rs.getInt("id_sucursal"));
                asistencias.add(a);
            }
        }
        return asistencias;
    }

    public List<String> obtenerClientesConAsistencias() throws SQLException {
        List<String> clientes = new ArrayList<>();
        String sql = """
            SELECT c.id_cliente, c.nombre || ' ' || c.apellido AS cliente
            FROM fitmanager.asistencia a
            JOIN fitmanager.cliente c ON a.id_cliente = c.id_cliente
            ORDER BY a.fecha_hora DESC
        """;

        try (Connection conn = DBConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                clientes.add(rs.getInt("id_cliente") + " - " + rs.getString("cliente"));
            }
        }
        return clientes;
    }
    
    public List<Asistencia> obtenerAsistenciasPorCliente(int idCliente) throws SQLException {
    List<Asistencia> asistencias = new ArrayList<>();
    String sql = "SELECT * FROM fitmanager.asistencia WHERE id_cliente = ? ORDER BY fecha_hora DESC";

    try (Connection conn = DBConfig.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idCliente);
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Asistencia a = new Asistencia();
                a.setIdAsistencia(rs.getLong("id_asistencia"));
                a.setFechaHora(rs.getTimestamp("fecha_hora"));
                a.setIdCliente(rs.getInt("id_cliente"));
                a.setIdSucursal(rs.getInt("id_sucursal"));
                asistencias.add(a);
            }
        }
    }
    return asistencias;
}
}