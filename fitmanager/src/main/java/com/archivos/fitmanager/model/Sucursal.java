package com.archivos.fitmanager.model;

/**
 *
 * @author vicente
 */
public class Sucursal {
    private int idSucursal;
    private String nombre;
    private String ubicacion;
    private int capacidadMaquinas;

    public Sucursal() {}

    public Sucursal(int idSucursal, String nombre, String ubicacion, int capacidadMaquinas) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidadMaquinas = capacidadMaquinas;
    }

    // Getters y Setters
    public int getIdSucursal() { return idSucursal; }
    public void setIdSucursal(int idSucursal) { this.idSucursal = idSucursal; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public int getCapacidadMaquinas() { return capacidadMaquinas; }
    public void setCapacidadMaquinas(int capacidadMaquinas) { this.capacidadMaquinas = capacidadMaquinas; }

    @Override
    public String toString() {
        return nombre + " (" + ubicacion + ")";
    }
}