package com.archivos.fitmanager.model;

/**
 *
 * @author vicente
 */
public class Ejercicio {
    private int idEjercicio;
    private String nombre;
    private int series;
    private int repeticiones;
    private int duracionMinutos;
    private int idEquipo;

    public Ejercicio() {}

    // Constructor básico
    public Ejercicio(int idEjercicio, String nombre, int series, int repeticiones, int duracionMinutos, int idEquipo) {
        this.idEjercicio = idEjercicio;
        this.nombre = nombre;
        this.series = series;
        this.repeticiones = repeticiones;
        this.duracionMinutos = duracionMinutos;
        this.idEquipo = idEquipo;
    }

    // Getters y Setters
    public int getIdEjercicio() { return idEjercicio; }
    public void setIdEjercicio(int idEjercicio) { this.idEjercicio = idEjercicio; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getSeries() { return series; }
    public void setSeries(int series) { this.series = series; }

    public int getRepeticiones() { return repeticiones; }
    public void setRepeticiones(int repeticiones) { this.repeticiones = repeticiones; }

    public int getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; }

    public int getIdEquipo() { return idEquipo; }
    public void setIdEquipo(int idEquipo) { this.idEquipo = idEquipo; }
}