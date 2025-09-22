package com.archivos.fitmanager.model;

import java.sql.Date;

/**
 *
 * @author vicente
 */
public class Pago {
    private int idPago;
    private int idTipoPago;
    private double monto;
    private Date fechaPago;
    private Date fechaInicio;
    private Date fechaFin;
    private int idCliente;

    public Pago() {}

    // Getters y Setters
    public int getIdPago() { return idPago; }
    public void setIdPago(int idPago) { this.idPago = idPago; }

    public int getIdTipoPago() { return idTipoPago; }
    public void setIdTipoPago(int idTipoPago) { this.idTipoPago = idTipoPago; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public Date getFechaPago() { return fechaPago; }
    public void setFechaPago(Date fechaPago) { this.fechaPago = fechaPago; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public Date getFechaFin() { return fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
}
