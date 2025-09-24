package com.archivos.fitmanager.model;

import java.sql.Timestamp;

/**
 *
 * @author vicente
 */
public class Asistencia {
    private long idAsistencia;
    private Timestamp fechaHora;
    private int idCliente;
    private int idSucursal;

    public Asistencia() {}

    public Asistencia(long idAsistencia, Timestamp fechaHora, int idCliente, int idSucursal) {
        this.idAsistencia = idAsistencia;
        this.fechaHora = fechaHora;
        this.idCliente = idCliente;
        this.idSucursal = idSucursal;
    }

    public long getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(long idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }
}