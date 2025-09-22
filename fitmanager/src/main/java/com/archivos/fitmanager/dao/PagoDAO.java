package com.archivos.fitmanager.dao;

import com.archivos.fitmanager.model.Pago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vicente
 */
public class PagoDAO {
    private final Connection conn;

    public PagoDAO(Connection conn) {
        this.conn = conn;
    }

    // Registrar un pago básico
    public boolean registrarPagoBasico(Pago pago) throws SQLException {
        String sql = "INSERT INTO pago (id_tipo_pago, monto, fecha_inicio, fecha_fin, id_cliente) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pago.getIdTipoPago());
            stmt.setDouble(2, pago.getMonto());
            stmt.setDate(3, pago.getFechaInicio());
            stmt.setDate(4, pago.getFechaFin());
            stmt.setInt(5, pago.getIdCliente());

            return stmt.executeUpdate() > 0;
        }
    }

    // Registrar un pago de servicios adicionales 
    public int registrarPagoServicio(Pago pago) throws SQLException {
        String sql = "INSERT INTO pago (id_tipo_pago, monto, id_cliente) " +
                     "VALUES (?, ?, ?) RETURNING id_pago";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pago.getIdTipoPago());
            stmt.setDouble(2, pago.getMonto());
            stmt.setInt(3, pago.getIdCliente());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_pago"); 
                }
            }
        }
        return -1;
    }
}