package com.archivos.fitmanager.model;

/**
 *
 * @author vicente
 */
public class Membresia {
     private int idMembresia;
    private int idTipoMembresia;
    private String tipoNombre; 
    private double descuento;

    public Membresia() {}

    public Membresia(int idMembresia, int idTipoMembresia, String tipoNombre, double descuento) {
        this.idMembresia = idMembresia;
        this.idTipoMembresia = idTipoMembresia;
        this.tipoNombre = tipoNombre;
        this.descuento = descuento;
    }

    // Getters y Setters
    public int getIdMembresia() { return idMembresia; }
    public void setIdMembresia(int idMembresia) { this.idMembresia = idMembresia; }

    public int getIdTipoMembresia() { return idTipoMembresia; }
    public void setIdTipoMembresia(int idTipoMembresia) { this.idTipoMembresia = idTipoMembresia; }

    public String getTipoNombre() { return tipoNombre; }
    public void setTipoNombre(String tipoNombre) { this.tipoNombre = tipoNombre; }

    public double getDescuento() { return descuento; }
    public void setDescuento(double descuento) { this.descuento = descuento; }

    @Override
    public String toString() {
        return tipoNombre + " (" + descuento + "%)";
    }
}
