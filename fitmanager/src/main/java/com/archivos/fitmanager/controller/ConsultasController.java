package com.archivos.fitmanager.controller;

import com.archivos.fitmanager.dao.AsistenciaDAO;
import com.archivos.fitmanager.dao.PagoDAO;
import com.archivos.fitmanager.model.Asistencia;
import com.archivos.fitmanager.model.Pago;
import com.archivos.fitmanager.model.TipoPago;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vicente
 */
public class ConsultasController {

    private PagoDAO pagoDAO;
    private AsistenciaDAO asistenciaDAO;

    public ConsultasController(Connection conn) {
        this.pagoDAO = new PagoDAO(conn);
        this.asistenciaDAO = new AsistenciaDAO();
    }

    
    public List<String> obtenerInfoCliente(int idCliente) {
        List<String> info = new ArrayList<>();
        try {
            // Obtener pagos del cliente
            List<Pago> pagos = pagoDAO.obtenerPagosPorCliente(idCliente);
            if (!pagos.isEmpty()) {
                info.add("=== PAGOS ===");
                for (Pago p : pagos) {
                    StringBuilder sb = new StringBuilder();
                    TipoPago tipo = pagoDAO.obtenerTipoPagoPorId(p.getIdTipoPago());
                    sb.append("Pago ID: ").append(p.getIdPago())
                      .append(", Tipo: ").append(tipo != null ? tipo.getNombre() : "Desconocido")
                      .append(", Monto: Q").append(p.getMonto());

                    if (p.getIdPlan() != 0) {
                        sb.append(", Plan ID: ").append(p.getIdPlan());
                    }
                    if (p.getFechaInicio() != null && p.getFechaFin() != null) {
                        sb.append(", Desde: ").append(p.getFechaInicio())
                          .append(" Hasta: ").append(p.getFechaFin());
                    }

                    // Servicios adicionales
                    List<String> servicios = pagoDAO.obtenerServiciosAdicionalesPorPago(p.getIdPago());
                    if (!servicios.isEmpty()) {
                        sb.append(", Servicios: ").append(String.join(", ", servicios));
                    }

                    info.add(sb.toString());
                }
            } else {
                info.add("No hay pagos registrados.");
            }

            // Obtener asistencias
            List<Asistencia> asistencias = asistenciaDAO.obtenerAsistenciasPorCliente(idCliente);
            if (!asistencias.isEmpty()) {
                info.add("=== ASISTENCIAS ===");
                for (Asistencia a : asistencias) {
                    info.add("Asistencia ID: " + a.getIdAsistencia() +
                             ", Fecha/Hora: " + a.getFechaHora() +
                             ", Sucursal ID: " + a.getIdSucursal());
                }
            } else {
                info.add("No hay asistencias registradas.");
            }

        } catch (SQLException e) {
            info.add("Error al obtener información: " + e.getMessage());
        }
        return info;
    }

}
