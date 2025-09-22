package com.archivos.fitmanager.dao;

import com.archivos.fitmanager.model.Membresia;
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
public class MembresiaDAO {

    private Connection conn;

    public MembresiaDAO(Connection conn) {
        this.conn = conn;
    }

    // Listar todas las membresías
    public List<Membresia> listarMembresias() {
        List<Membresia> lista = new ArrayList<>();
        String sql = "SELECT m.id_membresia, m.id_tipo_membresia, tm.nombre AS tipo_nombre, m.descuento "
                + "FROM membresia m "
                + "JOIN tipo_membresia tm ON m.id_tipo_membresia = tm.id_tipo_membresia "
                + "ORDER BY tm.nombre";

        try (Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Membresia m = new Membresia(
                        rs.getInt("id_membresia"),
                        rs.getInt("id_tipo_membresia"),
                        rs.getString("tipo_nombre"),
                        rs.getDouble("descuento")
                );
                lista.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Registrar nueva membresía
    public boolean registrarMembresia(int idTipo, double descuento) {
        String sql = "INSERT INTO membresia (id_tipo_membresia, descuento) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idTipo);
            ps.setDouble(2, descuento);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
