package com.archivos.fitmanager.dao;

import com.archivos.fitmanager.model.Rutina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vicente
 */
public class RutinaDAO {
    private final Connection conn;

    public RutinaDAO(Connection conn) {
        this.conn = conn;
    }

    public Rutina crearRutina(Rutina rutina) throws SQLException {
        String sql = "INSERT INTO rutina(nombre, fecha_inicio, id_cliente, id_entrenador) " +
                     "VALUES (?, current_date, ?, ?) RETURNING id_rutina";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, rutina.getNombre());
            stmt.setInt(2, rutina.getIdCliente());
            stmt.setInt(3, rutina.getIdEntrenador());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    rutina.setIdRutina(rs.getInt("id_rutina"));
                }
            }
        }
        return rutina;
    }

    public void asignarEjercicio(int idRutina, int idEjercicio, int orden) throws SQLException {
        String sql = "INSERT INTO rutina_ejercicio(id_rutina, id_ejercicio, orden) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idRutina);
            stmt.setInt(2, idEjercicio);
            stmt.setInt(3, orden);
            stmt.executeUpdate();
        }
    }

    public List<Rutina> obtenerRutinasPorCliente(int idCliente) throws SQLException {
        List<Rutina> lista = new ArrayList<>();
        String sql = "SELECT * FROM rutina WHERE id_cliente = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Rutina r = new Rutina(
                        rs.getInt("id_rutina"),
                        rs.getString("nombre"),
                        rs.getDate("fecha_inicio"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_entrenador")
                    );
                    lista.add(r);
                }
            }
        }
        return lista;
    }
}