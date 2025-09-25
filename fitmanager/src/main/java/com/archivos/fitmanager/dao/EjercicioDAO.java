package com.archivos.fitmanager.dao;

import com.archivos.fitmanager.model.Ejercicio;
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
public class EjercicioDAO {
    private final Connection conn;

    public EjercicioDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean crearEjercicio(Ejercicio ejercicio) throws SQLException {
        String sql = "INSERT INTO ejercicio(nombre, series, repeticiones, duracion_minutos, id_equipo) " +
                     "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, ejercicio.getNombre());
            stmt.setInt(2, ejercicio.getSeries());
            stmt.setInt(3, ejercicio.getRepeticiones());
            stmt.setInt(4, ejercicio.getDuracionMinutos());
            stmt.setInt(5, ejercicio.getIdEquipo());
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        ejercicio.setIdEjercicio(rs.getInt(1));
                    }
                }
                return true;
            }
        }
        return false;
    }

    // Leer todos
    public List<Ejercicio> obtenerEjercicios() throws SQLException {
        List<Ejercicio> lista = new ArrayList<>();
        String sql = "SELECT * FROM ejercicio";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(new Ejercicio(
                        rs.getInt("id_ejercicio"),
                        rs.getString("nombre"),
                        rs.getInt("series"),
                        rs.getInt("repeticiones"),
                        rs.getInt("duracion_minutos"),
                        rs.getInt("id_equipo")
                ));
            }
        }
        return lista;
    }

    // Leer uno por ID
    public Ejercicio obtenerEjercicioPorId(int id) throws SQLException {
        String sql = "SELECT * FROM ejercicio WHERE id_ejercicio = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Ejercicio(
                            rs.getInt("id_ejercicio"),
                            rs.getString("nombre"),
                            rs.getInt("series"),
                            rs.getInt("repeticiones"),
                            rs.getInt("duracion_minutos"),
                            rs.getInt("id_equipo")
                    );
                }
            }
        }
        return null;
    }

    // Leer ejercicios de una rutina
    public List<Ejercicio> obtenerEjerciciosPorRutina(int idRutina) throws SQLException {
        List<Ejercicio> lista = new ArrayList<>();
        String sql = "SELECT e.* FROM ejercicio e " +
 "INNER JOIN rutina_ejercicio re ON e.id_ejercicio = re.id_ejercicio "
                + "WHERE re.id_rutina = ? ORDER BY re.orden";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idRutina);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Ejercicio(
                            rs.getInt("id_ejercicio"),
                            rs.getString("nombre"),
                            rs.getInt("series"),
                            rs.getInt("repeticiones"),
                            rs.getInt("duracion_minutos"),
                            rs.getInt("id_equipo")
                    ));
                }
            }
        }
        return lista;
    }

    public int obtenerIdPorNombre(String nombre) throws SQLException {
        String sql = "SELECT id_ejercicio FROM ejercicio WHERE nombre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_ejercicio");
            }
        }
        return -1; 
    }
}
