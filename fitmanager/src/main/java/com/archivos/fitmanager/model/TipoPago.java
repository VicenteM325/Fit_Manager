package com.archivos.fitmanager.model;

/**
 *
 * @author vicente
 */
public class TipoPago {
    private int idTipoPago;
    private String nombre;
    
    public TipoPago(){
    }

    public TipoPago(int idTipoPago, String nombre) {
        this.idTipoPago = idTipoPago;
        this.nombre = nombre;
    }

    // Getters y Setters
    public int getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(int idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}