package com.archivos.fitmanager.dao;

import com.archivos.fitmanager.db.DBConfig;
import com.archivos.fitmanager.model.Asistencia;
import com.archivos.fitmanager.model.AsistenciaHistorial;
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

        try (Connection conn = DBConfig.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

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

        try (Connection conn = DBConfig.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                clientes.add(rs.getInt("id_cliente") + " - " + rs.getString("cliente"));
            }
        }
        return clientes;
    }

    public List<Asistencia> obtenerAsistenciasPorCliente(int idCliente) throws SQLException {
        List<Asistencia> asistencias = new ArrayList<>();
        String sql = "SELECT * FROM fitmanager.asistencia WHERE id_cliente = ? ORDER BY fecha_hora DESC";

        try (Connection conn = DBConfig.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

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

    public List<AsistenciaHistorial> obtenerHistorialPorEntrenador(int idEntrenador) throws SQLException {
        String sql = """
        SELECT e.id_empleado, e.nombre || ' ' || e.apellido AS entrenador,
               c.id_cliente, c.nombre || ' ' || c.apellido AS cliente,
               a.id_asistencia, a.fecha_hora, s.nombre AS sucursal
        FROM fitmanager.asistencia a
        JOIN fitmanager.cliente c ON a.id_cliente = c.id_cliente
        JOIN fitmanager.entrenador_cliente ec ON c.id_cliente = ec.id_cliente
        JOIN fitmanager.empleado e ON ec.id_entrenador = e.id_empleado
        LEFT JOIN fitmanager.sucursal s ON a.id_sucursal = s.id_sucursal
        WHERE e.id_empleado = ?
        ORDER BY a.fecha_hora DESC
    """;

        List<AsistenciaHistorial> historial = new ArrayList<>();

        try (Connection conn = DBConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idEntrenador);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    AsistenciaHistorial h = new AsistenciaHistorial(
                            rs.getInt("id_asistencia"),
                            rs.getInt("id_cliente"),
                            rs.getString("cliente"),
                            rs.getTimestamp("fecha_hora"),
                            rs.getString("sucursal")
                    );
                    historial.add(h);
                }
            }
        }
        return historial;
    }
}
