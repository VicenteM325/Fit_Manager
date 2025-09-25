package com.archivos.fitmanager.dao;

import com.archivos.fitmanager.db.DBConfig;
import com.archivos.fitmanager.model.Sucursal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vicente
 */
public class SucursalDAO {
      public List<Sucursal> obtenerTodas() {
        List<Sucursal> lista = new ArrayList<>();
        String sql = "SELECT id_sucursal, nombre, ubicacion, capacidad_maquinas FROM sucursal ORDER BY nombre";

        try (Connection c = DBConfig.getConnection();
             Statement st = c.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Sucursal(
                        rs.getInt("id_sucursal"),
                        rs.getString("nombre"),
                        rs.getString("ubicacion"),
                        rs.getInt("capacidad_maquinas")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Sucursal obtenerSucursalPorId(int id) throws SQLException {
        String sql = "SELECT id_sucursal, nombre, ubicacion, capacidad_maquinas FROM sucursal WHERE id_sucursal = ?";
        try (Connection c = DBConfig.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Sucursal(
                        rs.getInt("id_sucursal"),
                        rs.getString("nombre"),
                        rs.getString("ubicacion"),
                        rs.getInt("capacidad_maquinas")
                );
            }
        }
        return null;
    }
}
