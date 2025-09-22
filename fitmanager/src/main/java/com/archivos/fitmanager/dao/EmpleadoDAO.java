package com.archivos.fitmanager.dao;

import com.archivos.fitmanager.db.DBConfig;
import com.archivos.fitmanager.model.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public boolean registrarEmpleado(Empleado emp) {
        String sql = """
        INSERT INTO empleado (nombre, apellido, telefono, usuario_login, contrasena, id_rol, id_sucursal)
        VALUES (?, ?, ?, ?, crypt(?, gen_salt('bf')), ?, ?)
    """;

        try (Connection con = DBConfig.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getApellido());
            ps.setString(3, emp.getTelefono());
            ps.setString(4, emp.getUsuarioLogin());
            ps.setString(5, emp.getContrasena());
            ps.setInt(6, emp.getIdRol());
            if (emp.getIdSucursal() != null) {
                ps.setInt(7, emp.getIdSucursal());
            } else {
                ps.setNull(7, java.sql.Types.INTEGER);
            }

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Empleado> obtenerEntrenadores() {
        List<Empleado> lista = new ArrayList<>();
        String sql = """
        SELECT e.id_empleado, e.nombre, e.apellido
        FROM empleado e
        JOIN rol r ON e.id_rol = r.id_rol
        WHERE r.nombre = 'Entrenador'
        ORDER BY e.nombre, e.apellido
    """;

        try (Connection con = DBConfig.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt("id_empleado"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                lista.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return lista;
    }

}
