package com.archivos.fitmanager.dao;

import com.archivos.fitmanager.model.Pago;
import com.archivos.fitmanager.model.TipoPago;

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
public class PagoDAO {
    private final Connection conn;

    public PagoDAO(Connection conn) {
        this.conn = conn;
    }

    // Registrar un pago básico (con fechas)
    public boolean registrarPagoBasico(Pago pago) throws SQLException {
        String sql = "INSERT INTO pago (id_tipo_pago, monto, fecha_inicio, fecha_fin, id_cliente, id_Plan) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, pago.getIdTipoPago());
            stmt.setDouble(2, pago.getMonto());
            stmt.setDate(3, pago.getFechaInicio());
            stmt.setDate(4, pago.getFechaFin());
            stmt.setInt(5, pago.getIdCliente());
            stmt.setInt(6, pago.getIdPlan());

            return stmt.executeUpdate() > 0;
        }
    }

    // Registrar un pago de servicio (sin fechas, retorna ID generado)
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

    // Obtener todos los pagos
    public List<Pago> obtenerPagos() throws SQLException {
        String sql = "SELECT * FROM pago";
        List<Pago> pagos = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pago pago = new Pago();
                pago.setIdPago(rs.getInt("id_pago"));
                pago.setIdTipoPago(rs.getInt("id_tipo_pago"));
                pago.setMonto(rs.getDouble("monto"));
                pago.setFechaInicio(rs.getDate("fecha_inicio"));
                pago.setFechaFin(rs.getDate("fecha_fin"));
                pago.setIdCliente(rs.getInt("id_cliente"));
                pagos.add(pago);
            }
        }
        return pagos;
    }

    // Obtener pagos por cliente
    public List<Pago> obtenerPagosPorCliente(int idCliente) throws SQLException {
        String sql = "SELECT * FROM pago WHERE id_cliente = ?";
        List<Pago> pagos = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Pago pago = new Pago();
                    pago.setIdPago(rs.getInt("id_pago"));
                    pago.setIdTipoPago(rs.getInt("id_tipo_pago"));
                    pago.setMonto(rs.getDouble("monto"));
                    pago.setFechaInicio(rs.getDate("fecha_inicio"));
                    pago.setFechaFin(rs.getDate("fecha_fin"));
                    pago.setIdCliente(rs.getInt("id_cliente"));
                    pagos.add(pago);
                }
            }
        }
        return pagos;
    }

    // Buscar pago por ID
    public Pago obtenerPagoPorId(int idPago) throws SQLException {
        String sql = "SELECT * FROM pago WHERE id_pago = ?";
        Pago pago = null;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPago);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pago = new Pago();
                    pago.setIdPago(rs.getInt("id_pago"));
                    pago.setIdTipoPago(rs.getInt("id_tipo_pago"));
                    pago.setMonto(rs.getDouble("monto"));
                    pago.setFechaInicio(rs.getDate("fecha_inicio"));
                    pago.setFechaFin(rs.getDate("fecha_fin"));
                    pago.setIdCliente(rs.getInt("id_cliente"));
                }
            }
        }
        return pago;
    }

    // Eliminar pago
    public boolean eliminarPago(int idPago) throws SQLException {
        String sql = "DELETE FROM pago WHERE id_pago = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idPago);
            return stmt.executeUpdate() > 0;
        }
    }

    // ================== TIPOS DE PAGO ==================

    // Obtener todos los tipos de pago 
    public List<TipoPago> obtenerTiposPago() throws SQLException {
        String sql = "SELECT * FROM tipo_pago";
        List<TipoPago> tipos = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TipoPago tipo = new TipoPago();
                tipo.setIdTipoPago(rs.getInt("id_tipo_pago"));
                tipo.setNombre(rs.getString("nombre"));
                tipos.add(tipo);
            }
        }
        return tipos;
    }

    // Buscar tipo de pago por ID
    public TipoPago obtenerTipoPagoPorId(int idTipoPago) throws SQLException {
        String sql = "SELECT * FROM tipo_pago WHERE id_tipo_pago = ?";
        TipoPago tipo = null;

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTipoPago);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    tipo = new TipoPago();
                    tipo.setIdTipoPago(rs.getInt("id_tipo_pago"));
                    tipo.setNombre(rs.getString("nombre"));
                }
            }
        }
        return tipo;
    }

    public List<String> obtenerPlanesBasicos() throws SQLException {
        List<String> planes = new ArrayList<>();
        String sql = "SELECT id_plan, nombre, duracion_meses, costo FROM plan_basico";
        try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                planes.add(rs.getInt("id_plan") + " - "
                        + rs.getString("nombre") + " ("
                        + rs.getInt("duracion_meses") + " meses, Q"
                        + rs.getBigDecimal("costo") + ")");
            }
        }
        return planes;
    }

    public List<String> obtenerServiciosAdicionales() throws SQLException {
        List<String> servicios = new ArrayList<>();
        String sql = "SELECT id_servicio, nombre, costo FROM servicio_adicional";
        try (PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                servicios.add(rs.getInt("id_servicio") + " - "
                        + rs.getString("nombre") + " ("
                        + rs.getBigDecimal("costo") + ")");
            }
        }
        return servicios;
    }

    public double obtenerCostoPlan(int idPlan) throws SQLException {
        String sql = "SELECT costo FROM plan_basico WHERE id_plan = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPlan);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("costo");
            }
        }
        return 0.0;
    }

    public double obtenerCostoServicio(int idServicio) throws SQLException {
        String sql = "SELECT costo FROM servicio_adicional WHERE id_servicio = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idServicio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("costo");
            }
        }
        return 0.0;
    }
    
    public boolean registrarPagoConServicios(Pago pago, List<Integer> serviciosSeleccionados) throws SQLException {
    String sqlPago = "INSERT INTO pago (id_tipo_pago, monto, fecha_inicio, fecha_fin, id_cliente, id_plan) " +
                     "VALUES (?, ?, ?, ?, ?, ?) RETURNING id_pago";

    String sqlPagoServicio = "INSERT INTO pago_servicio (id_pago, id_servicio, cantidad) VALUES (?, ?, ?)";

    try {
        conn.setAutoCommit(false); // Inicia la transacción
        int idPagoGenerado = -1;

        // Insertar el pago
        try (PreparedStatement ps = conn.prepareStatement(sqlPago)) {
            ps.setInt(1, pago.getIdTipoPago());
            ps.setDouble(2, pago.getMonto());
            ps.setDate(3, pago.getFechaInicio());
            ps.setDate(4, pago.getFechaFin());
            if (pago.getIdCliente() != 0) {
                ps.setInt(5, pago.getIdCliente());
            } else {
                ps.setNull(5, java.sql.Types.INTEGER);
            }
            if (pago.getIdPlan() != 0) {
                ps.setInt(6, pago.getIdPlan());
            } else {
                ps.setNull(6, java.sql.Types.INTEGER);
            }

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idPagoGenerado = rs.getInt("id_pago");
            }
        }

        //Insertar servicios adicionales asociados al pago
        if (serviciosSeleccionados != null && !serviciosSeleccionados.isEmpty()) {
            try (PreparedStatement ps = conn.prepareStatement(sqlPagoServicio)) {
                for (Integer idServicio : serviciosSeleccionados) {
                    ps.setInt(1, idPagoGenerado);
                    ps.setInt(2, idServicio);
                    ps.setInt(3, 1);
                    ps.addBatch();
                }
                ps.executeBatch();
            }
        }

        conn.commit(); 
        return true;

    } catch (SQLException e) {
        conn.rollback(); 
        throw e;
    } finally {
        conn.setAutoCommit(true);
    }
}

}
