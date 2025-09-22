package com.archivos.fitmanager.dao;

import com.archivos.fitmanager.db.DBConfig;
import com.archivos.fitmanager.model.Rol;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author vicente
 */
public class RolDAO {
    public List<Rol> obtenerTodos() {
        List<Rol> lista = new ArrayList<>();
        String sql = "SELECT id_rol, nombre FROM rol ORDER BY nombre";

        try (Connection c = DBConfig.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Rol(rs.getInt("id_rol"), rs.getString("nombre")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
