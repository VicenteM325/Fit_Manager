package com.archivos.fitmanager.dao;

import com.archivos.fitmanager.model.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vicente
 */
public class EquipoDAO {
    private final Connection conn;

    public EquipoDAO(Connection conn) {
        this.conn = conn;
    }

    public void insertarEquipo(Equipo equipo) throws SQLException {
        String sql = "INSERT INTO equipo (nombre, estado, id_sucursal) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, equipo.getNombre());
            stmt.setString(2, equipo.getEstado());
            if (equipo.getIdSucursal() != null) {
                stmt.setInt(3, equipo.getIdSucursal());
            } else {
                stmt.setNull(3, Types.INTEGER);
            }
            stmt.executeUpdate();
        }
    }

    public List<Equipo> listarEquipos() throws SQLException {
        List<Equipo> equipos = new ArrayList<>();
        String sql = "SELECT * FROM equipo ORDER BY id_equipo";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Equipo e = new Equipo();
                e.setIdEquipo(rs.getInt("id_equipo"));
                e.setNombre(rs.getString("nombre"));
                e.setEstado(rs.getString("estado"));
                e.setIdSucursal((Integer) rs.getObject("id_sucursal"));
                equipos.add(e);
            }
        }
        return equipos;
    }
}
