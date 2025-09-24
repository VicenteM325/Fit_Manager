package com.archivos.fitmanager.model;

import java.sql.Date;

/**
 *
 * @author vicente
 */

    public class Rutina {
    private int idRutina;
    private String nombre;
    private Date fechaInicio;
    private int idCliente;
    private int idEntrenador;

    public Rutina() {}

    public Rutina(int idRutina, String nombre, Date fechaInicio, int idCliente, int idEntrenador) {
        this.idRutina = idRutina;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.idCliente = idCliente;
        this.idEntrenador = idEntrenador;
    }

    // Getters y Setters
    public int getIdRutina() { return idRutina; }
    public void setIdRutina(int idRutina) { this.idRutina = idRutina; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdEntrenador() { return idEntrenador; }
    public void setIdEntrenador(int idEntrenador) { this.idEntrenador = idEntrenador; }
}