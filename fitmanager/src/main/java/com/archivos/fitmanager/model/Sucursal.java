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

    public Sucursal(int idSucursal, String nombre, String ubicacion, int capacidadMaquinas) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidadMaquinas = capacidadMaquinas;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
