package com.archivos.fitmanager.dao;

import com.archivos.fitmanager.db.DBConfig;
import com.archivos.fitmanager.model.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author vicente
 */
public class EmpleadoDAO {
    public Empleado login(String username, String passwordPlain) {
        String sql = """
            SELECT e.id_empleado, e.nombre, e.apellido, r.nombre AS rol, e.usuario_login
            FROM empleado e
            JOIN rol r ON e.id_rol = r.id_rol
            WHERE e.usuario_login = ?
            AND e.contrasena = crypt(?::text, e.contrasena)
        """;

        try (Connection c = DBConfig.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, passwordPlain);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Empleado(
                        rs.getInt("id_empleado"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("rol"),
                        rs.getString("usuario_login")
                    );
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
