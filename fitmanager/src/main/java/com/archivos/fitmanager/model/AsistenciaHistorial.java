package com.archivos.fitmanager.model;

import java.sql.Timestamp;

/**
 *
 * @author vicente
 */
public class AsistenciaHistorial {

    private int idAsistencia;
    private int idCliente;
    private String nombreCliente;
    private Timestamp fechaHora;
    private String sucursal;

    public AsistenciaHistorial(int idAsistencia, int idCliente, String nombreCliente, Timestamp fechaHora, String sucursal) {
        this.idAsistencia = idAsistencia;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.fechaHora = fechaHora;
        this.sucursal = sucursal;
    }

    // Getters
    public int getIdAsistencia() {
        return idAsistencia;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public String getSucursal() {
        return sucursal;
    }
}
